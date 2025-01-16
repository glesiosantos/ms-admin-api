package br.com.ohgestor.msadmin.api.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Modulo {

    OFICINA("Módulo de Oficinas", 39.9, 24.9);

    private final String nome;
    private final Double precoPorUsuarioMensal;
    private final Double precoPorUsuarioAnual;
}
