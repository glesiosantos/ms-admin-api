package br.com.ohgestor.msadmin.api.web.responses;

public record ClienteResponse(
        String cpfCnpj,
        String razao,
        String fantasia,
        String proprietario,
        int vencimento,
        int totalUsuario,
        String cidade,
        String estado,
        String contatos,
        String modulos
) {}
