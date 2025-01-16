package br.com.ohgestor.msadmin.api.domains;

import br.com.ohgestor.msadmin.api.abstrato.EntidadeAbstrata;
import br.com.ohgestor.msadmin.api.enuns.Modulo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_cliente")
public class Cliente extends EntidadeAbstrata {

    @Column(name = "razao", length = 150, nullable = false)
    private String razaoSocial;

    @Column(name = "nm_fantasia", length = 150, nullable = false)
    private String nomeFantasia;

    @Column(name = "proprietario", length = 150, nullable = false)
    private String nomeDoProprietario;

    @Column(name = "cpf_cnpj", length = 15, nullable = false, unique = true)
    private String cpfCnpj;

    @Column(name = "dt_vencimento", nullable = false)
    private int dataVencimento;

    @Column(name = "ativo", columnDefinition = "boolean DEFAULT 'false'")
    private boolean ativo;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_cliente_contatos",
            joinColumns = @JoinColumn(name = "cliente_id"))
    private Set<String> contatos;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_cliente_modulos")
    private Set<Modulo> modulos;
}
