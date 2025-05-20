package br.com.ohgestor.msadmin.api.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Plano {

    BASIC("Básico", 49.9, 2, 30, 20),
    INTER("Intermediário", 69.9, 5, 30,0),
    PROFI("Profissional", 99.9, 10,30,0),
    TESTE("Teste", 0, 1, 7,0);

    private final String descricao;
    private final double valor;
    private final int totalUsuario;
    private final int totalDias;
    private final double descontoPromocional;
}
