package br.com.ohgestor.msadmin.api.domains;

import br.com.ohgestor.msadmin.api.abstrato.Auditoria;
import br.com.ohgestor.msadmin.api.enuns.Modulo;
import br.com.ohgestor.msadmin.api.enuns.SituacaoPedido;
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
@Table(name = "pedidos")
public class Pedido extends Auditoria {

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Modulo modulo;

    @Enumerated(EnumType.STRING)
    private SituacaoPedido situacao;

    @Column(name = "qtd_usuario")
    private int quantidadeDeUsuarios;

    @ManyToOne
    @JoinColumn(name = "usuario_responsavel_id")
    private Usuario usuarioVenda;

    @Column(name = "qr-code", unique = true, nullable = false, columnDefinition = "TEXT")
    private String qrCode;

    @Column(name = "chave_compartilhamento", unique = true, nullable = false)
    private String chaveCompartilhamento;

    @Column(name = "dt_expiracao", unique = true, nullable = false)
    private String dataExpiracao;
}
