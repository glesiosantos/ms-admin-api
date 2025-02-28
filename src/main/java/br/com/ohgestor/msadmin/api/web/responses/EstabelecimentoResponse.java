package br.com.ohgestor.msadmin.api.web.responses;

import java.util.Set;

public record EstabelecimentoResponse(
        Long id,
        String cpfOuCnpj,
        String razaoSocial,
        String nomeFantasia,
        String plano,
        String modulo,
        int vencimento,
        String cpfProprietario,
        String proprietario,
        String cep,
        String logradouro,
        String bairro,
        String cidade,
        String estado,
        String latitude,
        String longitude,
        Set<String> contatos
) {}
