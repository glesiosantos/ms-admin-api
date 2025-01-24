package br.com.ohgestor.msadmin.api.web.controllers;

import br.com.ohgestor.msadmin.api.services.AutenticarService;
import br.com.ohgestor.msadmin.api.web.requests.LoginRequest;
import br.com.ohgestor.msadmin.api.web.responses.LoginResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(request.getHeader("Authorization"));
        return ResponseEntity.ok().build();
    }
}
