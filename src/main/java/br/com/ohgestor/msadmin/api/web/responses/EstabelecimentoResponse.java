package br.com.ohgestor.msadmin.api.web.responses;

public record EstabelecimentoResponse(
        String cpfOuCnpj,
        String razaoSocial,
        String nomeFantasia,
        int totalDeUsuario,
        int vencimento,
        String cpfProprietario,
        String proprietario,
        String cep,
        String logradouro,
        String bairro,
        String cidade,
        String estado,
        String latitude,
        String longitude
) {}
