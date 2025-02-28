package br.com.ohgestor.msadmin.api.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Modulo {

    GOM("Gestor de Oficinas Mecânicas"),
    GCV("Gestor de Comercio e Varejo");

    private final String nome;
}
