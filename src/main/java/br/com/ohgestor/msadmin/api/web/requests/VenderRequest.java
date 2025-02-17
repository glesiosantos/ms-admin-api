package br.com.ohgestor.msadmin.api.web.requests;

public record VenderRequest(
        Long idEstabelecimento,
        String cpf,
        String nomeProprietario,
        String modulo,
        int dataVencimento
) {}
