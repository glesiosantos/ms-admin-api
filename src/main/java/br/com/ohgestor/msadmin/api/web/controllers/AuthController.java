package br.com.ohgestor.msadmin.api.web.controllers;

import br.com.ohgestor.msadmin.api.services.AutenticarService;
import br.com.ohgestor.msadmin.api.web.requests.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class AuthController {

    @Autowired
    private AutenticarService autenticarService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) throws Exception {
        String token = autenticarService.autenticar(request);
        return ResponseEntity.ok(token);
    }
}
