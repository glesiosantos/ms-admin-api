package br.com.ohgestor.msadmin.api.web.requests;

import java.util.List;

public record ClienteRequest(
        String documento,
        String razao,
        String fantasia,
        String cep,
        String logradouro,
        String bairro,
        String cidade,
        String estado,
        List<String> contatos,
        String latitude,
        String longitude
) {}
