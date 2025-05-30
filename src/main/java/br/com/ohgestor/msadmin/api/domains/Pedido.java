package br.com.ohgestor.msadmin.api.domains;

import br.com.ohgestor.msadmin.api.abstrato.Auditoria;
import br.com.ohgestor.msadmin.api.enuns.Plano;
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
    private Plano plano;

    @Enumerated(EnumType.STRING)
    private SituacaoPedido situacao;

    @ManyToOne
    @JoinColumn(name = "usuario_responsavel_id")
    private Usuario usuarioVenda;

    @Column(name = "qr_code", unique = true, nullable = false, columnDefinition = "TEXT")
    private String qrCode;

    @Column(name = "chave_compartilhamento", unique = true, nullable = false)
    private String chaveCompartilhamento;

    @Column(name = "id_cob_asaas", nullable = false, unique = true)
    private String codigoAsaasCobranca;

    @Column(name = "dt_expiracao", nullable = false)
    private String dataExpiracaoPagamento;
}
