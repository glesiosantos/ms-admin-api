package br.com.ohgestor.msadmin.api.web.requests;

public record ClienteFiltroRequest(
        String nome,
        String cpfCnpj,
        int vencimento
) {}
