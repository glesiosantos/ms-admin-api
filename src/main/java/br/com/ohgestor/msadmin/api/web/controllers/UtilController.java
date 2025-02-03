package br.com.ohgestor.msadmin.api.web.controllers;

import br.com.ohgestor.msadmin.api.enuns.TipoComercio;
import br.com.ohgestor.msadmin.api.enuns.UnidadeFederacao;
import br.com.ohgestor.msadmin.api.web.responses.TipoComerciaisResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("v1/utils")
public class UtilController {

    @GetMapping("/tipos-comerciais")
    public ResponseEntity<?> carregarTipoComercial() {
        List<TipoComerciaisResponse> response = new ArrayList<>();
        for (TipoComercio tipo : TipoComercio.values()) {
            response.add(new TipoComerciaisResponse(tipo.name(), tipo.getNome()));
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/estados")
    public ResponseEntity<UnidadeFederacao[]> carregarUnidadesFederativa() {
        return ResponseEntity.ok(UnidadeFederacao.values());
    }
}
