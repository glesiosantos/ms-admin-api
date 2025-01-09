package br.com.ohgestor.msadmin.api.web.requests;

public record UsuarioRequest(
        String nome,
        String cpf,
        String email
) {
}
