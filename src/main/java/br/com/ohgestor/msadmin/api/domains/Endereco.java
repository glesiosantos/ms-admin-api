package br.com.ohgestor.msadmin.api.domains;

import br.com.ohgestor.msadmin.api.enuns.UnidadeFederacao;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {

    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "uf")
    private UnidadeFederacao estado;
    private String complemento;
    private String latitude;
    private String longitude;
}
