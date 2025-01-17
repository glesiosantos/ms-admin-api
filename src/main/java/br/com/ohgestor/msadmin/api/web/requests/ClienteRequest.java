package br.com.ohgestor.msadmin.api.web.requests;

import java.util.List;

public record ClienteRequest(
        String cpfCnpj,
        String razaoSocial,
        String nomeFantasia,
        String nomeDoProprietario,
        String cep,
        String logradouro,
        String bairro,
        String cidade,
        String estado,
        List<String> contatos
) {}
