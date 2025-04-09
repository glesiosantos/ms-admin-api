package br.com.ohgestor.msadmin.api.web.requests;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record PedidoRequest(
        @NotBlank(message = "ID Cliente é campo obrigatório") String idCliente,
        @NotBlank(message = "CPF é campo obrigatório") @CPF(message = "CPF informado é invalido") String cpfProprietario,
        @NotBlank(message = "NOME DO PROPRIETÁRIO é campo obrigatório") String nomeProprietario,
        @NotBlank(message = "Plano é campo obrigatório") String plano,
        String periodoTeste,
        boolean testeGratuito,
        @NotBlank(message = "Vencimento é campo obrigatório") String vencimento
) {}
