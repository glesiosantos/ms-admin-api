package br.com.ohgestor.msadmin.api.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gratuito {

    SETE(7, "7 Dias"),
    QUINZE(15, "15 Dias"),
    TRINTA(30, "30 Dias");

    private final int totalDias;
    private final String descricao;
}
