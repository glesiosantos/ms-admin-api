package br.com.ohgestor.msadmin.api.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Modulo {

    OMG("Gestor de Oficinas Mecânicas", 1, 29.9);

    private final String nome;
    private final int totalUsuario;
    private final Double preco;
}
