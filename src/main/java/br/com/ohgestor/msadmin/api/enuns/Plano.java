package br.com.ohgestor.msadmin.api.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Plano {

    TESTE("Teste", 0.0, 1, 7),
    BASIC("Básico", 29.9, 2, 30),
    INTER("Intermediário", 59.9, 5, 30),
    PROFI("Profissional", 99.9, 10,30);

    private final String descricao;
    private final double valor;
    private final int totalUsuario;
    private final int totalDias;
}
