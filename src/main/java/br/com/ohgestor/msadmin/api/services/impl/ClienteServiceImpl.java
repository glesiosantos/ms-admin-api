package br.com.ohgestor.msadmin.api.services.impl;

import br.com.ohgestor.msadmin.api.domains.Cliente;
import br.com.ohgestor.msadmin.api.domains.ClienteModulo;
import br.com.ohgestor.msadmin.api.domains.Usuario;
import br.com.ohgestor.msadmin.api.enuns.Modulo;
import br.com.ohgestor.msadmin.api.repositories.ClienteRepository;
import br.com.ohgestor.msadmin.api.repositories.UsuarioRepository;
import br.com.ohgestor.msadmin.api.services.ClienteService;
import br.com.ohgestor.msadmin.api.web.mappers.ClienteMapper;
import br.com.ohgestor.msadmin.api.web.requests.ClienteRequest;
import br.com.ohgestor.msadmin.api.web.responses.ClienteResponse;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
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
        var usuario = carregarUsuarioAutenticado();
        var cliente = clienteMapper.converterRequestParaModel(request);
        cliente.setAtivo(true);
        cliente.setNumeroDeUsuario(1);
        cliente.setModulos(List.of(associarModuloAoCliente(request, cliente, usuario)));
        return clienteRepository.save(cliente);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Cliente> filtrarClientes() {
        return clienteRepository.findAll();
    }

    private Usuario carregarUsuarioAutenticado() throws BadRequestException {
        return usuarioRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(() -> new BadRequestException("Usuário não encontrado!"));
    }

    private static ClienteModulo associarModuloAoCliente(ClienteRequest request, Cliente cliente, Usuario usuario) {
        return ClienteModulo.builder()
                .cliente(cliente)
                .modulo(Modulo.valueOf(request.modulo()))
                .responsavelVenda(usuario)
                .build();
    }
}
