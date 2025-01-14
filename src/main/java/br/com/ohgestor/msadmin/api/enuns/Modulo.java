package br.com.ohgestor.msadmin.api.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Modulo {

    OFICINA("Módulo de Oficinas", 24.9);

    private final String nome;
    private final Double precoPorUsuario;
}
