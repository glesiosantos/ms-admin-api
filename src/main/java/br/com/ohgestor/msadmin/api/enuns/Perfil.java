package br.com.ohgestor.msadmin.api.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Perfil {

    ADMIN("Administrador"),
    COMUM("Comum"),
    VENDE("Vendedor");

    private final String nome;
}
