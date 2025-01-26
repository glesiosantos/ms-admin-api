package br.com.ohgestor.msadmin.api.web.requests;

import java.util.List;

public record ClienteRequest(
        String cpfCnpj,
        String razaoSocial,
        String nomeFantasia,
        String nomeDoProprietario,
        int vencimento,
        String cidade,
        String estado,
        List<String> contatos,
        List<String> modulos
) {}
