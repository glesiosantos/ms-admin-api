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
import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Auditoria extends EntidadeAbstrata{

    @CreatedDate
    @Column(name = "dt_criado_em", nullable = false, updatable = false, columnDefinition = "DATE default 'now()'")
    private LocalDate dataCriadoEm;

    @LastModifiedDate
    @Column(name = "dt_atualizado_em", columnDefinition = "DATE")
    private LocalDate dataAtualizadoEm;
}
