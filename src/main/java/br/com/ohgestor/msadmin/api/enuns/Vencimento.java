package br.com.ohgestor.msadmin.api.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Vencimento {

    CINCO("Cinco",5),
    DEZ("Dez",10),
    QUINZE("Quinze", 15),
    VINTE("Vinte", 20),
    VINCI("Vinte e Cinco", 25);

    private final String descricao;
    private final int dia;
}
