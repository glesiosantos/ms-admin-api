package br.com.ohgestor.msadmin.api.services.impl;

import br.com.ohgestor.msadmin.api.domains.Usuario;
import br.com.ohgestor.msadmin.api.repositories.UsuarioRepository;
import br.com.ohgestor.msadmin.api.services.UsuarioService;
import br.com.ohgestor.msadmin.api.web.mappers.UsuarioMapper;
import br.com.ohgestor.msadmin.api.web.requests.UsuarioRequest;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public Usuario cadastraUsuario(UsuarioRequest request) throws Exception {
        Optional<Usuario> optional = usuarioRepository.findByEmail(request.email());
        if(optional.isPresent()) throw new BadRequestException("Usuário ja cadastrado no sistema");
        var usuario = usuarioMapper.converterRequestParaModel(request);
        usuario.setSenha(passwordEncoder.encode("102030"));
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> carregarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario buscarPeloEmail(String email) throws Exception{
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new BadRequestException("Nenhum usuário encontrado"));
    }
}
