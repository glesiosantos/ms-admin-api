package br.com.ohgestor.msadmin.api.web.requests;

public record VenderRequest(
        Long idEstabelecimento,
        String cpf,
        String proprietario,
        String modulo,
        String vencimento
) {}
