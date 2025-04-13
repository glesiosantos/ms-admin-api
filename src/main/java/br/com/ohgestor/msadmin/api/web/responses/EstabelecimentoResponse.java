package br.com.ohgestor.msadmin.api.web.responses;

import java.time.LocalDate;
import java.util.Set;

public record EstabelecimentoResponse(
        String idCliente,
        String tipoPessoa,
        String documento,
        String razao,
        String fantasia,
        String plano,
        String modulo,
        boolean ativo,
        int diaVencimento,
        boolean integrado,
        String cpfProprietario,
        String proprietario,
        String cep,
        String logradouro,
        String bairro,
        String cidade,
        String estado,
        String latitude,
        String longitude,
        boolean periodoDeTeste,
        LocalDate dataVencimentoTeste,
        Set<String> contatos
) {}
