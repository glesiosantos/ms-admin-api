package br.com.ohgestor.msadmin.api.services.impl;

import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.repositories.ClienteRepository;
import br.com.ohgestor.msadmin.api.repositories.UsuarioRepository;
import br.com.ohgestor.msadmin.api.services.ClienteService;
import br.com.ohgestor.msadmin.api.web.mappers.ClienteMapper;
import br.com.ohgestor.msadmin.api.web.requests.ClienteRequest;
import br.com.ohgestor.msadmin.api.web.responses.ClienteResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public Cliente addCliente(ClienteRequest request) throws BadRequestException {
        var cliente = clienteMapper.converterRequestParaModel(request);
        return clienteRepository.save(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClienteResponse> carregarClientes() {
        List<ClienteResponse> clientes = new ArrayList<>();
        clienteRepository.findAll().stream().forEach(cliente -> clientes.add(
                        new ClienteResponse(cliente.getCpfCnpj(), cliente.getRazaoSocial(), cliente.getNomeFantasia(), cliente.getProprietario(), cliente.getDataVencimento(), cliente.getNumeroUsuario(), cliente.getEndereco().getCidade(), cliente.getEndereco().getEstado().toString(), cliente.getContatos(), cliente.isIntegrado(), cliente.getEstabelecimento().getNome())
                ));

        return clientes;
    }
}
