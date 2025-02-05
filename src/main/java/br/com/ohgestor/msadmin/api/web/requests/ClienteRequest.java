package br.com.ohgestor.msadmin.api.web.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ClienteRequest(
        @NotNull(message = "Campo DOCUMENTO é obrigatório") String documento,
        @NotNull(message = "Campo RAZÃO é obrigatório") String razao,
        @NotNull(message = "Campo NOME FANTASIA é obrigatório") String fantasia,
        @NotNull(message = "Campo CEP é obrigatório") String cep,
        @NotNull(message = "Campo LOGRADOURO é obrigatório") String logradouro,
        @NotNull(message = "Campo BAIRRO é obrigatório") String bairro,
        @NotNull(message = "Campo CIDADE é obrigatório") String cidade,
        @NotNull(message = "Campo ESTADO é obrigatório") String estado,
        @NotNull(message = "Campo ESTABELECIMENTO é obrigatório") String estabelecimento,
        @NotEmpty(message = "Campo contatos não pode ser vazio") List<String> contatos,
        String latitude,
        String longitude
) {}
