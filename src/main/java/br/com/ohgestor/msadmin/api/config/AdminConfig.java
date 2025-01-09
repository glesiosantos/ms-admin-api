package br.com.ohgestor.msadmin.api.config;

import br.com.ohgestor.msadmin.api.domains.Usuario;
import br.com.ohgestor.msadmin.api.enuns.Perfil;
import br.com.ohgestor.msadmin.api.repositories.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;

@Configuration
@Slf4j
public class AdminConfig {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void criarUsuarioAdministrativo(){
        Usuario usuario = Usuario.builder()
                .nome("Administrador")
                .email("admin@ohgestor.com.br")
                .senha(passwordEncoder.encode("102030"))
                .ativo(true)
                .perfil(Perfil.ADMIN)
                .dataCriadoEm(Instant.now())
                .build();

        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            log.warn("Usuário ja cadastrado no banco!");
        } else {
            usuarioRepository.save(usuario);
            log.info("Usuário cadastrado com sucesso");
        }
    }

}
