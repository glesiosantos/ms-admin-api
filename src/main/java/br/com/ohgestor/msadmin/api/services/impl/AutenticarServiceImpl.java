package br.com.ohgestor.msadmin.api.services.impl;

import br.com.ohgestor.msadmin.api.services.AutenticarService;
import br.com.ohgestor.msadmin.api.services.JwtService;
import br.com.ohgestor.msadmin.api.web.requests.LoginRequest;
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

    @Override
    public String autenticar(LoginRequest request) throws Exception {
        var authenticated = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.senha()));
        return jwtService.tokenGenerate((UserDetails) authenticated.getPrincipal());
    }
}
