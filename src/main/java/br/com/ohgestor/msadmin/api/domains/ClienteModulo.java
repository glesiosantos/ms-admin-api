package br.com.ohgestor.msadmin.api.domains;

import br.com.ohgestor.msadmin.api.abstrato.Auditoria;
import br.com.ohgestor.msadmin.api.abstrato.EntidadeAbstrata;
import br.com.ohgestor.msadmin.api.enuns.Modulo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
@Entity
@Table(name = "tb_cliente_modulo")
public class ClienteModulo extends Auditoria {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Modulo modulo;

    @Column(columnDefinition = "boolean DEFAULT 'true'")
    private boolean ativo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vendedor", nullable = false)
    private Usuario responsavelVenda;
}
