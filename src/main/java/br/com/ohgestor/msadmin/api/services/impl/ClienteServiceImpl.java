package br.com.ohgestor.msadmin.api.services.impl;

import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.repositories.ClienteRepository;
import br.com.ohgestor.msadmin.api.repositories.UsuarioRepository;
import br.com.ohgestor.msadmin.api.services.ClienteService;
import br.com.ohgestor.msadmin.api.services.exceptions.ObjetoNaoEncontradoException;
import br.com.ohgestor.msadmin.api.services.exceptions.ObjetoRegistradoException;
import br.com.ohgestor.msadmin.api.web.mappers.ClienteMapper;
import br.com.ohgestor.msadmin.api.web.requests.ClienteRequest;
import br.com.ohgestor.msadmin.api.web.responses.EstabelecimentoResponse;
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
    public Cliente addCliente(ClienteRequest request) throws Exception {

        Optional<Cliente> optional = clienteRepository.findByCpfOuCnpj(request.documento());

        if(optional.isPresent()) throw new ObjetoRegistradoException(
                String.format("Cliente ja registrado em nossa base com este CPF ou CNPJ %s", request.documento()));

        var cliente = clienteMapper.converterRequestParaModel(request);
        return clienteRepository.save(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public Cliente buscarClientePeloCpfOuCnpj(String documento) throws Exception {
        return clienteRepository.findByCpfOuCnpj(documento)
                .orElseThrow(() -> new ObjetoNaoEncontradoException(String.format("Nenhum cliente encontrado com este CPF ou CNPJ '%s'", documento)));
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
