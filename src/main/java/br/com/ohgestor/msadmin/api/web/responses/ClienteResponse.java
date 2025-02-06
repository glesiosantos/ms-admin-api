package br.com.ohgestor.msadmin.api.web.responses;

import java.util.Set;

public record ClienteResponse(
        String cpfCnpj,
        String razao,
        String fantasia,
        String proprietario,
        int vencimento,
        int totalUsuario,
        String cidade,
        String estado,
        Set<String> contatos,
        boolean integrado,
        String estabelecimento
) {}
