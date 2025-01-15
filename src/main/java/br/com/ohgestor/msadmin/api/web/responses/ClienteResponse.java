package br.com.ohgestor.msadmin.api.web.responses;

import java.util.List;

public record ClienteResponse(
        String cpfCnpj,
        String razao,
        String fantasia,
        String proprietario,
        int vencimento,
        int totalUsuario,
        List<String> contatos,
        List<String> modulos
) {}
