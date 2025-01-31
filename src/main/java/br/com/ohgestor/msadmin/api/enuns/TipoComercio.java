package br.com.ohgestor.msadmin.api.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoComercio {

    CBC("COMERCIO DE BENS DE CONSUMO"),
    IEX("IMPORTAÇÃO E EXPORTAÇÃO"),
    CRA("COMERCIO DE ROUPAS E ACESSÓRIOS"),
    CMC("COMERCIO DE MATERIAIS DE CONSTRUÇÃO"),
    CME("COMERCIO DE MEDICAMENTOS"),
    CVP("COMERCIO DE VEÍCULOS E PEÇAS"),
    CUD("COMERCIO DE UTENSILIOS DOMESTICOS");

    private final String nome;
}
