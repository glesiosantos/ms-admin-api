package br.com.ohgestor.msadmin.api.web.responses;

public record ErroResponse(
        String mensagem,
        int status,
        long horario,
        String path
) {}
