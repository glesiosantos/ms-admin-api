package br.com.ohgestor.msadmin.api.web.controllers;

import br.com.ohgestor.msadmin.api.config.SecurityConfig;
import br.com.ohgestor.msadmin.api.services.AutenticarService;
import br.com.ohgestor.msadmin.api.web.requests.LoginRequest;
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
//    @ApiResponse(responseCode = "200", description = "Usuário autenticado com sucesso")
//    @ApiResponse(responseCode = "400", description = "Usuário não encontrado")
//    @ApiResponse(responseCode = "500", description = "Ocorreu error no servidor")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) throws Exception {
        LoginResponse response = autenticarService.autenticar(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/validar-token")
//    @ApiResponse(responseCode = "200", description = "Token validado com sucesso")
//    @ApiResponse(responseCode = "400", description = "Usuário não encontrado")
//    @ApiResponse(responseCode = "500", description = "Ocorreu error no servidor")
    public ResponseEntity<?> validarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        var isValid = autenticarService.validarToken(token.replace("Bearer ", ""));
        return ResponseEntity.ok(isValid);
    }
}
