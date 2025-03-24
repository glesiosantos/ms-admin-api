package br.com.ohgestor.msadmin.api.abstrato;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Auditoria extends EntidadeAbstrata{

    @CreatedDate
    @Column(name = "dt_criado_em", nullable = false, updatable = false)
    private Instant dataCriadoEm;

    @LastModifiedDate
    @Column(name = "dt_atualizado_em", columnDefinition = "DATE")
    private Instant dataAtualizadoEm;
}
