package br.com.ohgestor.msadmin.api.services.impl;

import br.com.ohgestor.msadmin.api.domains.Usuario;
import br.com.ohgestor.msadmin.api.services.AutenticarService;
import br.com.ohgestor.msadmin.api.services.JwtService;
import br.com.ohgestor.msadmin.api.services.UsuarioService;
import br.com.ohgestor.msadmin.api.web.requests.LoginRequest;
import br.com.ohgestor.msadmin.api.web.responses.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AutenticarServiceImpl implements AutenticarService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UsuarioService usuarioService;

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
}
