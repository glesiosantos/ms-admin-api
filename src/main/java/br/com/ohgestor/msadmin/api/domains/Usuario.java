package br.com.ohgestor.msadmin.api.domains;

import br.com.ohgestor.msadmin.api.abstrato.Auditoria;
import br.com.ohgestor.msadmin.api.enuns.Perfil;
import br.com.ohgestor.msadmin.api.utils.UpperCaseConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.context.SecurityContextHolder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario extends Auditoria {

    @Column(length = 150, nullable = false)
    private String avatar;

    @Convert(converter = UpperCaseConverter.class)
    @Column(length = 150, nullable = false)
    private String nome;

    @Column(nullable = false, updatable = false)
    private String email;

    @JsonIgnore
    private String senha;

    private boolean ativo;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    public static String recuperarUsuarioLogado() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
