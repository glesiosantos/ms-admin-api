package br.com.ohgestor.msadmin.api.web.controllers;

import br.com.ohgestor.msadmin.api.web.requests.VenderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @PostMapping
    public ResponseEntity<?> vender(@RequestBody VenderRequest request) {

        return ResponseEntity.created(null);
    }
}
