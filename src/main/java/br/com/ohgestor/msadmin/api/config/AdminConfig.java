package br.com.ohgestor.msadmin.api.config;

import br.com.ohgestor.msadmin.api.domains.Usuario;
import br.com.ohgestor.msadmin.api.enuns.Perfil;
import br.com.ohgestor.msadmin.api.repositories.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;

@Configuration
@Slf4j
public class AdminConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Usuario usuario = Usuario.builder()
            .nome("Administrador")
            .email("admin@ohgestor.com.br")
                .avatar("default.png")
            .senha(passwordEncoder.encode("102030"))
            .ativo(true)
            .perfil(Perfil.ADMIN)
            .dataCriadoEm(Instant.now())
            .build();

        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            System.out.println("*** *** *** Usuário ja cadastrado no banco!");
        } else {
            usuarioRepository.save(usuario);
            log.info("***** ******** ******* *******");
            log.info("Usuário cadastrado com sucesso");
        }
    }
}
