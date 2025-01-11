package br.com.ohgestor.msadmin.api.services;

import br.com.ohgestor.msadmin.api.web.requests.LoginRequest;

public interface AutenticarService {

    String autenticar(LoginRequest request) throws Exception;
}
