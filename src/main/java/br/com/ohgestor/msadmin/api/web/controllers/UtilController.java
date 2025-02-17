package br.com.ohgestor.msadmin.api.web.controllers;

import br.com.ohgestor.msadmin.api.config.SecurityConfig;
import br.com.ohgestor.msadmin.api.enuns.EstabelecimentoComercial;
import br.com.ohgestor.msadmin.api.enuns.Modulo;
import br.com.ohgestor.msadmin.api.enuns.UnidadeFederacao;
import br.com.ohgestor.msadmin.api.enuns.Vencimento;
import br.com.ohgestor.msadmin.api.web.responses.EstadoResponse;
import br.com.ohgestor.msadmin.api.web.responses.ModuloResponse;
import br.com.ohgestor.msadmin.api.web.responses.TipoComerciaisResponse;
import br.com.ohgestor.msadmin.api.web.responses.VencimentoResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Tag(name = "Utilitários")
@RestController
@RequestMapping("v1/utils")
@SecurityRequirement(name = SecurityConfig.SECURITY)
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

    @GetMapping("/vencimentos")
    public ResponseEntity<?> carregarVencimentos() {
        List<VencimentoResponse> vencimentos = new ArrayList<>();
        for (Vencimento vencimento : Vencimento.values()){
            vencimentos.add(new VencimentoResponse(vencimento.name(), vencimento.getDia()));
        }
        return ResponseEntity.ok(vencimentos);
    }

    @GetMapping("/modulos")
    public ResponseEntity<?> carregarModulos() {
        List<ModuloResponse> modulos = new ArrayList<>();
        for (Modulo modulo : Modulo.values()){
            modulos.add(new ModuloResponse(modulo.name(), modulo.getNome()));
        }
        return ResponseEntity.ok(modulos);
    }
}
