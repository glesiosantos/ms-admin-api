package br.com.ohgestor.msadmin.api.services.impl;

import br.com.ohgestor.msadmin.api.domains.Usuario;
import br.com.ohgestor.msadmin.api.services.AutenticarService;
import br.com.ohgestor.msadmin.api.services.EnvioEmailService;
import br.com.ohgestor.msadmin.api.services.JwtService;
import br.com.ohgestor.msadmin.api.services.UsuarioService;
import br.com.ohgestor.msadmin.api.utils.GeradorUtils;
import br.com.ohgestor.msadmin.api.web.requests.EmailRequest;
import br.com.ohgestor.msadmin.api.web.requests.LoginRequest;
import br.com.ohgestor.msadmin.api.web.responses.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

@Service
public class AutenticarServiceImpl implements AutenticarService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EnvioEmailService envioEmailService;

    @Override
    public LoginResponse autenticar(LoginRequest request) throws Exception {
        var authenticated = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.senha()));
        Usuario usuario = usuarioService.buscarPeloEmail(authenticated.getName());
        String token = jwtService.tokenGenerate((UserDetails) authenticated.getPrincipal());
        return new LoginResponse(token, usuario.getNome(), usuario.getEmail(), usuario.getAvatar(), usuario.getPerfil().name());
    }

    @Override
    public boolean validarToken(String token) {
        return jwtService.validarToken(token.substring(7)).isEmpty();
    }

    @Override
    public void alterarSenha(String novaSenha) throws Exception {
        var usuario = usuarioService.buscarPeloEmail(Usuario.recuperarUsuarioLogado());
        usuario.setSenha(passwordEncoder.encode(novaSenha));
        usuarioService.updateDadosUsuario(usuario);
    }

    @Override
    public void recuperarAcesso(String email) throws Exception {
        var usuario = usuarioService.buscarPeloEmail(email);
        var novaSenha = GeradorUtils.geradorSenhaAleatorias(6);

        var emailRequest = new EmailRequest(usuario.getEmail(),
                "Seu Novo Acesso Está Disponível!",
                null);

        Context context = new Context();
        context.setVariable("nomeUsuario", usuario.getNome());
        context.setVariable("email", usuario.getEmail());
        context.setVariable("novaSenha", novaSenha);
        envioEmailService.enviarEmailComTemplate(emailRequest, "recuperar-acesso", context);
    }
}
