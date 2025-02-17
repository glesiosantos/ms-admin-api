package br.com.ohgestor.msadmin.api.domains;

import br.com.ohgestor.msadmin.api.abstrato.EntidadeAbstrata;
import br.com.ohgestor.msadmin.api.enuns.EstabelecimentoComercial;
import br.com.ohgestor.msadmin.api.utils.ContatoPadraoConverter;
import br.com.ohgestor.msadmin.api.utils.UpperCaseConverter;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@ToString
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente extends EntidadeAbstrata {

    @Convert(converter = UpperCaseConverter.class)
    @Column(name = "razao", length = 150, nullable = false)
    private String razaoSocial;

    @Convert(converter = UpperCaseConverter.class)
    @Column(name = "nm_fantasia", length = 150, nullable = false)
    private String nomeFantasia;

    @Convert(converter = UpperCaseConverter.class)
    @Column(length = 150)
    private String proprietario;

    @Column(name = "cpf", length = 11)
    private String cpfProprietario;

    @Column(name = "cpf_cnpj", length = 15, nullable = false, unique = true)
    private String cpfOuCnpj;

    private int vencimento;

    @Column(name = "ativo", columnDefinition = "boolean DEFAULT 'false'")
    private boolean ativo;

    @Column(name = "nr_usuario", columnDefinition = "INT DEFAULT '0'")
    private int numeroUsuario;

    @Embedded
    private Endereco endereco;

    @Column(columnDefinition = "BOOLEAN DEFAULT 'false'")
    private boolean integrado;

    @Convert(converter = ContatoPadraoConverter.class)
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_cliente_contatos",
            joinColumns = @JoinColumn(name = "cliente_id"))
    private Set<String> contatos;

    @Enumerated(EnumType.STRING)
    @Column(name = "estabelecimento", length = 3, nullable = false, columnDefinition = "CHAR(3) default 'OME'")
    private EstabelecimentoComercial estabelecimento;
}
