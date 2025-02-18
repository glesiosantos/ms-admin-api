package br.com.ohgestor.msadmin.api.web.responses;

public record ModuloResponse(
        String sigla,
        String descricao,
        int unidade,
        double preco
) {}
