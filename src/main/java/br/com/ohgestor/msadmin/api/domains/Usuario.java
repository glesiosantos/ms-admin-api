package br.com.ohgestor.msadmin.api.domains;

import br.com.ohgestor.msadmin.api.abstrato.Auditoria;
import br.com.ohgestor.msadmin.api.enuns.Perfil;
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
@Table(name = "tb_usuario")
public class Usuario extends Auditoria {

    @Column(length = 150, nullable = false)
    private String avatar;

    @Column(length = 150, nullable = false)
    private String nome;

    @Column(length = 150, nullable = false, unique = true, updatable = false)
    private String email;

    @Column(length = 150, nullable = false)
    private String senha;

    @Column(columnDefinition = "BOOLEAN default 'false'")
    private boolean ativo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 5, columnDefinition = "CHAR(5) default 'COMUM'")
    private Perfil perfil;
}
