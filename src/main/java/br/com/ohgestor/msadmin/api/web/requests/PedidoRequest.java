package br.com.ohgestor.msadmin.api.web.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record PedidoRequest(
        @NotNull(message = "ID Estabelecimento é campo obrigatório") Long idEstabelecimento,
        @NotBlank(message = "CPF é campo obrigatório") @CPF(message = "CPF informado é invalido") String cpf,
        @NotBlank(message = "NOME DO PROPRIETÁRIO é campo obrigatório") String proprietario,
        @NotBlank(message = "MÓDULO é campo obrigatório") String plano,
        @NotBlank(message = "VENCIMENTO é campo obrigatório") String vencimento
) {}
