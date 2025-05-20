package br.com.ohgestor.msadmin.api.domains;

import br.com.ohgestor.msadmin.api.abstrato.EntidadeAbstrata;
import br.com.ohgestor.msadmin.api.conversores.DocumentoConversor;
import br.com.ohgestor.msadmin.api.enuns.Modulo;
import br.com.ohgestor.msadmin.api.enuns.Plano;
import br.com.ohgestor.msadmin.api.enuns.SegmentoComercial;
import br.com.ohgestor.msadmin.api.enuns.TipoPessoa;
import br.com.ohgestor.msadmin.api.utils.ContatoPadraoConverter;
import br.com.ohgestor.msadmin.api.utils.UpperCaseConverter;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
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

    @Enumerated(EnumType.STRING)
    private TipoPessoa tipo;

    @Convert(converter = UpperCaseConverter.class)
    @Column(name = "razao", length = 150, nullable = false)
    private String razaoSocial;

    @Convert(converter = UpperCaseConverter.class)
    @Column(name = "nm_fantasia", length = 150, nullable = false)
    private String nomeFantasia;

    @Convert(converter = UpperCaseConverter.class)
    @Column(length = 150)
    private String proprietario;

    @Convert(converter = DocumentoConversor.class)
    @Column(name = "cpf_proprietario")
    private String cpfProprietario;

    @Column(name = "desconto_promocional")
    private boolean descontoPromocional;

    @Convert(converter = DocumentoConversor.class)
    @Column(name = "cpf_cnpj")
    private String cpfOuCnpj;

    @Enumerated(EnumType.STRING)
    private SegmentoComercial segmento;

    private int vencimento;

    @Column(name = "ativo")
    private boolean ativo;

    @Embedded
    private Endereco endereco;

    private boolean integrado;

    @Convert(converter = ContatoPadraoConverter.class)
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "cliente_contatos",
            joinColumns = @JoinColumn(name = "cliente_id"))
    private Set<String> contatos;

    @Enumerated(EnumType.STRING)
    private Modulo modulo;

    @Enumerated(EnumType.STRING)
    private Plano plano;

    @Column(name = "dt_vencimento_teste")
    private LocalDate dataVencimentoTeste;
}
