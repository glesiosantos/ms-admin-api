package br.com.ohgestor.msadmin.api.services.impl;

import br.com.ohgestor.msadmin.api.domains.Usuario;
import br.com.ohgestor.msadmin.api.repositories.UsuarioRepository;
import br.com.ohgestor.msadmin.api.services.EnvioEmailService;
import br.com.ohgestor.msadmin.api.services.UsuarioService;
import br.com.ohgestor.msadmin.api.services.exceptions.ObjetoNaoEncontradoException;
import br.com.ohgestor.msadmin.api.utils.GeradorUtils;
import br.com.ohgestor.msadmin.api.web.mappers.UsuarioMapper;
import br.com.ohgestor.msadmin.api.web.requests.EmailRequest;
import br.com.ohgestor.msadmin.api.web.requests.UsuarioRequest;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.context.Context;

import java.security.SecureRandom;
import java.util.Base64;
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

    @Autowired
    private EnvioEmailService envioEmailService;

    @Override
    public Usuario cadastraUsuario(UsuarioRequest request) throws Exception {
        Optional<Usuario> optional = usuarioRepository.findByEmail(request.email());
        if(optional.isPresent()) throw new BadRequestException("Usuário ja cadastrado no sistema");
        var usuario = usuarioMapper.converterRequestParaModel(request);

        // gerar senha aleatoria
        var senha = GeradorUtils.geradorSenhaAleatorias(6);
        envioDeEmail(usuario, senha);
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> carregarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void updateDadosUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario buscarPeloEmail(String email) throws Exception{
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new ObjetoNaoEncontradoException("Nenhum usuário encontrado"));
    }

    private void envioDeEmail(Usuario usuario, String senha) {
        var emailRequest = new EmailRequest(usuario.getEmail(),
                "Novo usuário no Oh Gestor", "Obrigado por se registrar no nosso sistema de vendas. Agora você tem acesso a uma plataforma completa para gerenciar suas compras, vendas e muito mais.");
        Context context = new Context();
        context.setVariable("nomeUsuario", usuario.getNome());
        context.setVariable("texto", emailRequest.texto());
        context.setVariable("email", usuario.getEmail());
        context.setVariable("senha", senha);
        envioEmailService.enviarEmailComTemplate(emailRequest,"email-template", context);
    }
}
