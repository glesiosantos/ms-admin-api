package br.com.ohgestor.msadmin.api.services;

import br.com.ohgestor.msadmin.api.web.requests.LoginRequest;
import br.com.ohgestor.msadmin.api.web.responses.LoginResponse;

public interface AutenticarService {

    LoginResponse autenticar(LoginRequest request) throws Exception;
}
