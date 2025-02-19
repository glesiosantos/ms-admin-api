package br.com.ohgestor.msadmin.api.services.impl;

import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.domains.Pedido;
import br.com.ohgestor.msadmin.api.domains.Usuario;
import br.com.ohgestor.msadmin.api.enuns.Modulo;
import br.com.ohgestor.msadmin.api.enuns.SituacaoPedido;
import br.com.ohgestor.msadmin.api.enuns.Vencimento;
import br.com.ohgestor.msadmin.api.repositories.ClienteRepository;
import br.com.ohgestor.msadmin.api.repositories.PedidoRepository;
import br.com.ohgestor.msadmin.api.repositories.UsuarioRepository;
import br.com.ohgestor.msadmin.api.services.PedidoService;
import br.com.ohgestor.msadmin.api.services.exceptions.ObjetoNaoEncontradoException;
import br.com.ohgestor.msadmin.api.web.requests.PedidoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public Pedido registrarPedido(PedidoRequest request) throws Exception{
        var cliente = retornarClienteCadastrado(request);

        // salvando dados do proprietário
        cliente.setProprietario(request.proprietario());
        cliente.setCpfProprietario(request.cpf().replace(".", "").replace("-",""));
        cliente.setModulo(Modulo.valueOf(request.modulo()));
        cliente.setVencimento(Vencimento.valueOf(request.vencimento()).getDia());
        clienteRepository.save(cliente);

        // Gerando pedido
        var pedido = Pedido.builder()
                .cliente(cliente)
                .usuarioVenda(buscarUsuarioVenda())
                .situacao(SituacaoPedido.PENDENTE)
                .modulo(Modulo.valueOf(request.modulo()))
                .quantidadeDeUsuarios(request.qtdUsuario())
                .build();

        // TODO: caso o cliente queira fechar, gere um pedido local com a situação de 'PENDENTE'
        //  e enviar as informações para api de pagamento e gerar a cobrança tipo pix
        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> carregarMeusPedido(Usuario usuario) {
        return List.of();
    }

    private Cliente retornarClienteCadastrado(PedidoRequest request) throws ObjetoNaoEncontradoException {
        return clienteRepository.findById(request.idEstabelecimento()).orElseThrow(() ->
                new ObjetoNaoEncontradoException(String.format("Nenhum empresa encontrada com este %s", request.idEstabelecimento())));
    }

    private Usuario buscarUsuarioVenda() throws ObjetoNaoEncontradoException {
        var email = SecurityContextHolder.getContext().getAuthentication().getName();
        return usuarioRepository.findByEmail(email).orElseThrow(() ->
                new ObjetoNaoEncontradoException(String.format("Nenhum empresa encontrada com este %s",email)));
    }
}
