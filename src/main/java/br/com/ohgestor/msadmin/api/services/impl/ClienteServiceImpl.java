package br.com.ohgestor.msadmin.api.services.impl;

import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.enuns.Vencimento;
import br.com.ohgestor.msadmin.api.repositories.ClienteRepository;
import br.com.ohgestor.msadmin.api.repositories.UsuarioRepository;
import br.com.ohgestor.msadmin.api.services.ClienteService;
import br.com.ohgestor.msadmin.api.services.exceptions.ObjetoNaoEncontradoException;
import br.com.ohgestor.msadmin.api.web.mappers.ClienteMapper;
import br.com.ohgestor.msadmin.api.web.requests.ClienteRequest;
import br.com.ohgestor.msadmin.api.web.requests.VenderRequest;
import br.com.ohgestor.msadmin.api.web.responses.EstabelecimentoResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq-exchange.oficina-exchange}")
    private String exchangeName;

    @Override
    public Cliente addCliente(ClienteRequest request) throws BadRequestException {
        var cliente = clienteMapper.converterRequestParaModel(request);
        return clienteRepository.save(cliente);
    }

    @Override
    public EstabelecimentoResponse registrarModulo(VenderRequest request) throws Exception{
        Optional<Cliente> optional = clienteRepository.findById(request.idEstabelecimento());
        if(optional.isEmpty()) throw new ObjetoNaoEncontradoException("Nenhum cliente encontrado com este id");
        // popular os dados do proprietário, a data de vencimento e total de usuário registrado
        optional.get().setProprietario(request.proprietario());
        optional.get().setCpfProprietario(request.cpf().replace(".", "").replace("-",""));
        optional.get().setVencimento(Vencimento.valueOf(request.vencimento()).getDia());
        optional.get().setNumeroUsuario(1);
        optional.get().setAtivo(true);
        optional.get().setIntegrado(true);
        // TODO: Registrar o estabelecimento em uma api de pagamento para gerar as cobranças via API da ASSAS
        //  - Estudar documentação - 3
        // TODO: Ao receber uma confirmação da API de pagamento cadastrar a empresa na API correspondente
        var response = clienteMapper.converterClienteEmEstabelecimento(clienteRepository.save(optional.get()));
        notificarRabbitMQ( response, exchangeName);
        return response;
    }

    @Override
    public void notificarRabbitMQ(EstabelecimentoResponse response, String exchange) {
        rabbitTemplate.convertAndSend(exchange, "", response);
    }

    @Transactional(readOnly = true)
    @Override
    public List<EstabelecimentoResponse> carregarClientes() {
        List<EstabelecimentoResponse> estabelecimentos = new ArrayList<>();
        clienteRepository.findAll().forEach(cliente -> estabelecimentos.add(clienteMapper.converterClienteEmEstabelecimento(cliente)));
        return estabelecimentos;
    }

}
