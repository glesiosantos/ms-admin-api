package br.com.ohgestor.msadmin.api.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SegmentoComercial {

    OMC("Oficinas Mecânicas de Carros", Modulo.GOM),
    OMM("Oficinas Mecânicas de Motos", Modulo.GOM),
    ECA("Estabelecimentos de Acessórios Automotivo", Modulo.GOM);

    public final String descricao;
    public final Modulo modulo;
}
