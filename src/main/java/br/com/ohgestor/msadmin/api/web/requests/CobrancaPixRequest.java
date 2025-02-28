package br.com.ohgestor.msadmin.api.web.requests;

public record CobrancaPixRequest(
        String cpfCnpj,
        String razaoSocial,
        Double valorCobranca
) {}
