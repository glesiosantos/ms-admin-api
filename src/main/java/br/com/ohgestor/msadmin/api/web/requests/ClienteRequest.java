package br.com.ohgestor.msadmin.api.web.requests;

import java.util.List;

public record ClienteRequest(
        String cpfCnpj,
        String razaoSocial,
        String nomeFantasia,
        String cep,
        String logradouro,
        String bairro,
        String cidade,
        String estado,
        String latitude,
        String longitude,
        int dataVencimento,
        String modulo,
        String cpfProprietario,
        String nomeDoProprietario,
        List<String> contatos
) {}
