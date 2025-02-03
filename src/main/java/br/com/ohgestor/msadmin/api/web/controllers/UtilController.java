package br.com.ohgestor.msadmin.api.web.controllers;

import br.com.ohgestor.msadmin.api.enuns.EstabelecimentoComercial;
import br.com.ohgestor.msadmin.api.enuns.UnidadeFederacao;
import br.com.ohgestor.msadmin.api.web.responses.EstadoResponse;
import br.com.ohgestor.msadmin.api.web.responses.TipoComerciaisResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/utils")
public class UtilController {

    @GetMapping("/estabelecimentos")
    public ResponseEntity<?> carregarTipoComercial() {
        List<TipoComerciaisResponse> response = new ArrayList<>();
        for (EstabelecimentoComercial tipo : EstabelecimentoComercial.values()) {
            response.add(new TipoComerciaisResponse(tipo.name(), tipo.getNome()));
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/estados")
    public ResponseEntity<?> carregarUnidadesFederativa() {
        List<EstadoResponse> estados = new ArrayList<>();
        for (UnidadeFederacao federacao : UnidadeFederacao.values()) {
            estados.add(new EstadoResponse(federacao.name(), federacao.getNome()));
        }
        return ResponseEntity.ok(estados);
    }
}
