package br.com.ohgestor.msadmin.api.web.controllers;

import br.com.ohgestor.msadmin.api.services.ClienteService;
import br.com.ohgestor.msadmin.api.web.requests.VenderRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/vendas")
public class VendaController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @RequestMapping("/registrar-modulo")
    public ResponseEntity<?> vender(@RequestBody @Valid VenderRequest request) throws Exception {
        var response = clienteService.registrarModulo(request);
        return ResponseEntity.ok(null);
    }
}
