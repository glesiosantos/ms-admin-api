package br.com.ohgestor.msadmin.api.abstrato;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class EntidadeAbstrata implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
}