package br.com.ohgestor.msadmin.api.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoPessoa {

    PF("Pessoa Física"),
    PJ("Pessoa Jurídica");

    private final String tipo;
}
