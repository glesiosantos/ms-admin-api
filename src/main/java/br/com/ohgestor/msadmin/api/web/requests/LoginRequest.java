package br.com.ohgestor.msadmin.api.web.requests;

public record LoginRequest(
        String email,
        String senha
) {
}
