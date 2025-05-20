package br.com.ohgestor.msadmin.api.services.impl;

import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.domains.Pedido;
import br.com.ohgestor.msadmin.api.domains.Usuario;
import br.com.ohgestor.msadmin.api.enuns.*;
import br.com.ohgestor.msadmin.api.repositories.ClienteRepository;
import br.com.ohgestor.msadmin.api.repositories.PedidoRepository;
import br.com.ohgestor.msadmin.api.repositories.UsuarioRepository;
import br.com.ohgestor.msadmin.api.repositories.filtros.PedidoSpecification;
import br.com.ohgestor.msadmin.api.services.AsaasClientService;
import br.com.ohgestor.msadmin.api.services.PedidoService;
import br.com.ohgestor.msadmin.api.services.exceptions.ObjetoNaoEncontradoException;
import br.com.ohgestor.msadmin.api.services.filtros.PedidoFiltro;
import br.com.ohgestor.msadmin.api.web.mappers.PedidoMapper;
import br.com.ohgestor.msadmin.api.web.requests.PedidoRequest;
import br.com.ohgestor.msadmin.api.web.responses.PedidoResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PedidoServiceImpl.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private AsaasClientService asaasClientService;

    @Autowired
    private PedidoMapper pedidoMapper;

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public PedidoResponse registrarPedido(PedidoRequest request) throws Exception{
        var cliente = retornarClienteCadastrado(request);

        // salvando dados do proprietário e Módulo selecionado
        cliente.setProprietario(request.nomeProprietario());
        cliente.setCpfProprietario(request.cpfProprietario());
        cliente.setModulo(Modulo.valueOf(request.modulo()));
        cliente.setPlano(Plano.valueOf(request.plano()));

        Usuario usuario = usuarioRepository.findByEmail(Usuario.recuperarUsuarioLogado())
                .orElseThrow(() -> new ObjetoNaoEncontradoException("Responsável de vendas não encontrado"));

        Pedido pedido = null;

        if (Plano.valueOf(request.plano()).equals(Plano.TESTE)) {
            cliente.setAtivo(true);
            cliente.setDataVencimentoTeste(LocalDate.now().plusDays(Plano.TESTE.getTotalDias()));
            pedido = Pedido.builder()
                    .usuarioVenda(usuario)
                    .cliente(cliente)
                    .situacao(SituacaoPedido.PENDENTE)
                    .build();
        } else {
            cliente.setVencimento(Vencimento.valueOf(request.vencimento()).getDia());
            cliente.setDescontoPromocional(request.descontoPromocional());
            pedido = asaasClientService.carregarCobrancasPixComQrCode(cliente, usuario, SituacaoPedido.PENDENTE, Plano.valueOf(request.plano()));
        }

        clienteRepository.save(cliente);
        return pedidoMapper.converterModeloParaResponse(pedidoRepository.save(pedido));
    }

    @Override
    public List<Pedido> carregarMeusPedido(Usuario usuario) {
        return List.of();
    }

    @Override
    public PedidoResponse buscarPedidoPeloId(String id) throws Exception {
        var pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new ObjetoNaoEncontradoException(String.format("Nenhum pedido encontrado com id %s", id)));
        return pedidoMapper.converterModeloParaResponse(pedido);
    }

    @Override
    public List<PedidoResponse> buscarPedidos(PedidoFiltro filtro) {
        return pedidoRepository.findAll(PedidoSpecification.comFiltros(filtro))
                .stream().map(pedido -> pedidoMapper.converterModeloParaResponseParaListagem(pedido)).toList();
    }

    @Override
    @Scheduled(fixedRate = 60000)
    public void confirmarPagamentoDePedidosPendentes() {
        LOGGER.info("Inicializando confirmação de pagamento .... ");
        pedidoRepository.findPedidoPelaSuaSituacao(SituacaoPedido.PENDENTE.name()).forEach(pedido -> {
            try {
                if (pedido.getCodigoAsaasCobranca() == null || pedido.getCodigoAsaasCobranca().isEmpty()) {
                   LOGGER.warn("Código Asaas não encontrado para o pedido ID: {}", pedido.getId());
                   return;
                }

                String statusCobbranca = asaasClientService.carregarStatusDoPagamentoAsaas(pedido.getCodigoAsaasCobranca());
                if("RECEIVED".equals(statusCobbranca)) {
                    pedido.setSituacao(SituacaoPedido.CONCLUIDO);
                    pedidoRepository.save(pedido);

                    var cliente = pedido.getCliente();
                    cliente.setAtivo(true);
                    clienteRepository.save(cliente);
                    LOGGER.info("Pedido ID {} atualizado para CONCLUIDO", pedido.getId());
                }
            } catch (Exception e) {
                LOGGER.error("Erro ao processar pedido ID {}: {}", pedido.getId(), e.getMessage(), e);
            }
        });
        LOGGER.info("Finalizando confirmação de pagamento .... ");
    }

    @Override
    public boolean confirmarPagamento(Pedido pedido) throws Exception {
        var cobranca = asaasClientService.carregarStatusDoPagamentoAsaas(pedido.getCodigoAsaasCobranca());
        System.out.println("status "+cobranca);
        return false;
    }

    private Cliente retornarClienteCadastrado(PedidoRequest request) throws ObjetoNaoEncontradoException {
        return clienteRepository.findById(request.idCliente()).orElseThrow(() ->
                new ObjetoNaoEncontradoException(String.format("Nenhum empresa encontrada com este %s", request.idCliente())));
    }

    private Usuario buscarUsuarioVenda() throws ObjetoNaoEncontradoException {
        var email = SecurityContextHolder.getContext().getAuthentication().getName();
        return usuarioRepository.findByEmail(email).orElseThrow(() ->
                new ObjetoNaoEncontradoException(String.format("Nenhum empresa encontrada com este %s",email)));
    }
}
