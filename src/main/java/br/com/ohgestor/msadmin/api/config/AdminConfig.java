package br.com.ohgestor.msadmin.api.config;

import br.com.ohgestor.msadmin.api.domains.Usuario;
import br.com.ohgestor.msadmin.api.enuns.Perfil;
import br.com.ohgestor.msadmin.api.repositories.UsuarioRepository;
import br.com.ohgestor.msadmin.api.services.UsuarioService;
import br.com.ohgestor.msadmin.api.web.requests.UsuarioRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;

@Configuration
@Slf4j
public class AdminConfig implements CommandLineRunner{

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private void criarUsuarioAdmin() throws Exception {

        UsuarioRequest request = new UsuarioRequest("Administrador", "glesioss@gmail.com", "ADMIN", true);

        if (usuarioService.existeUsuarioComEsteEmail(request.email())) {
            System.out.println("*** *** *** Usuário ja cadastrado no banco!");
        } else {
            usuarioService.cadastraUsuario(request);
            log.info("Usuário cadastrado com sucesso");
        }
    }

    @Override
    public void run(String... args) throws Exception {
        criarUsuarioAdmin();
    }
}
