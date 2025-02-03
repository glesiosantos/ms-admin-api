package br.com.ohgestor.msadmin.api.web.controllers;

import br.com.ohgestor.msadmin.api.services.ClienteService;
import br.com.ohgestor.msadmin.api.web.requests.ClienteRequest;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_VENDE','ROLE_ADMIN')")
    public ResponseEntity<?> cadastroDeClientes(@RequestBody ClienteRequest request) throws BadRequestException {
        var cliente = clienteService.addCliente(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(cliente.getCpfCnpj()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_VENDE','ROLE_ADMIN')")
    public ResponseEntity<?> carregarClientes() {
        return ResponseEntity.ok(clienteService.filtrarClientes());
    }
}
