package br.com.ohgestor.msadmin.api.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    public String tokenGenerate(UserDetails userDetails);

    public String validarToken(String token);
}
