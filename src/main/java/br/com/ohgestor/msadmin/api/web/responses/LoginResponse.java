package br.com.ohgestor.msadmin.api.web.responses;

public record LoginResponse(
        String token,
        String apelido,
        String avatar,
        String perfil
) {}
