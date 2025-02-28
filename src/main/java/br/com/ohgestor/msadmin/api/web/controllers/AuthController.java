package br.com.ohgestor.msadmin.api.web.controllers;

import br.com.ohgestor.msadmin.api.config.SecurityConfig;
import br.com.ohgestor.msadmin.api.services.AutenticarService;
import br.com.ohgestor.msadmin.api.web.requests.AlterarSenhaRequest;
import br.com.ohgestor.msadmin.api.web.requests.LoginRequest;
import br.com.ohgestor.msadmin.api.web.requests.RecuperarAcessoRequest;
import br.com.ohgestor.msadmin.api.web.responses.LoginResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Autenticação", description = "Responsável pela autenticação de usuário na api")
@RestController
@RequestMapping("v1/auth")
public class AuthController {

    @Autowired
    private AutenticarService autenticarService;

    @PostMapping("/autenticar")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) throws Exception {
        LoginResponse response = autenticarService.autenticar(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/validar-token")
    public ResponseEntity<?> validarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        var isValid = autenticarService.validarToken(token.replace("Bearer ", ""));
        return ResponseEntity.ok(isValid);
    }

    @PostMapping("/alterar-senha")
    public ResponseEntity<?> alterarSenhaAcesso(@RequestBody AlterarSenhaRequest request) throws Exception {
        autenticarService.alterarSenha(request.nova());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/recuperar-acesso")
    public ResponseEntity<?> recuperarAcesso(@RequestBody RecuperarAcessoRequest request) throws Exception {
        autenticarService.recuperarAcesso(request.email());
        return ResponseEntity.noContent().build();
    }
}
