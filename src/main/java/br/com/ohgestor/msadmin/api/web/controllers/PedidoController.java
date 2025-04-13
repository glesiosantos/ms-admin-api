package br.com.ohgestor.msadmin.api.web.controllers;

import br.com.ohgestor.msadmin.api.services.PedidoService;
import br.com.ohgestor.msadmin.api.services.filtros.PedidoFiltro;
import br.com.ohgestor.msadmin.api.web.requests.PedidoRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<?> registrarVendaModulo(@RequestBody @Valid PedidoRequest request) throws Exception {
        var pedido = pedidoService.registrarPedido(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(pedido.idPedido()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{pedidoId}")
    public ResponseEntity<?> buscarPedidoRealizado(@PathVariable String pedidoId) throws Exception {
        var pedido = pedidoService.buscarPedidoPeloId(pedidoId);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping
    public ResponseEntity<?> carregarPedidos(@RequestParam(required = false) String dataInicial,
                                             @RequestParam(required = false) String dataFinal,
                                             @RequestParam(required = false) String situacao) {
        var filtro = new PedidoFiltro(dataInicial, dataFinal, situacao);
        var pedidos = pedidoService.buscarPedidos(filtro);
        return ResponseEntity.ok(pedidos);
    }
}
