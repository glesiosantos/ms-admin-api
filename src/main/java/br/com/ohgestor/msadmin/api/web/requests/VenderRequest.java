package br.com.ohgestor.msadmin.api.web.requests;

public record VenderRequest(
        Long idCliente,
        String cpf,
        String nomeProprietario,
        String modulo,
        String diaVencimento
) {}
