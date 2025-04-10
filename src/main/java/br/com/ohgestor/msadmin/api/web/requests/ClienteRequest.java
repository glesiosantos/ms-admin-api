package br.com.ohgestor.msadmin.api.web.requests;

import br.com.ohgestor.msadmin.api.web.validators.CPFouCNPJ;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ClienteRequest(
        String idCliente,
        @CPFouCNPJ(message = "CPF/CNPJ é obrigatório") String documento,
        @NotNull(message = "Campo Tipo de Pessoa é obrigatório") String tipo,
        @NotNull(message = "Campo RAZÃO é obrigatório") String razao,
        @NotNull(message = "Campo NOME FANTASIA é obrigatório") String fantasia,
        @NotNull(message = "Campo CEP é obrigatório") String cep,
        @NotNull(message = "Campo LOGRADOURO é obrigatório") String logradouro,
        @NotNull(message = "Campo BAIRRO é obrigatório") String bairro,
        @NotNull(message = "Campo CIDADE é obrigatório") String cidade,
        @NotNull(message = "Campo ESTADO é obrigatório") String estado,
        @NotEmpty(message = "Campo contatos não pode ser vazio") List<String> contatos,
        String latitude,
        String longitude
) {}
