package br.com.ohgestor.msadmin.api.services;

import br.com.ohgestor.msadmin.api.domains.Usuario;
import br.com.ohgestor.msadmin.api.web.requests.LoginRequest;
import br.com.ohgestor.msadmin.api.web.responses.LoginResponse;

public interface AutenticarService {

    LoginResponse autenticar(LoginRequest request) throws Exception;

    boolean validarToken(String token);

    void alterarSenha(String novaSenha) throws Exception;

    void recuperarAcesso(String email) throws Exception;
}
