package br.com.ohgestor.msadmin.api.web.controllers;

import br.com.ohgestor.msadmin.api.enuns.*;
import br.com.ohgestor.msadmin.api.web.responses.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Utilitários")
@RestController
@RequestMapping("v1/utils")
public class UtilController {

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
        List<ModuloResponse> modulos = Arrays.stream(Modulo.values()).map(modulo -> {
            return new ModuloResponse(modulo.name(), modulo.getNome());
        }).collect(Collectors.toList());
        return ResponseEntity.ok(modulos);
    }

    @GetMapping("/planos")
    public ResponseEntity<?> carregarPlanos() {
        List<PlanoResponse> planos = Arrays.stream(Plano.values()).map(plano -> {
            String descricao = String.format("%s - R$ %.2f", plano.getDescricao(), plano.getValor()) ;
            return new PlanoResponse(descricao, plano.name(), plano.getValor(), plano.getTotalUsuario());
        }).collect(Collectors.toList());
        return ResponseEntity.ok(planos);
    }

    @GetMapping("/perfis")
    public ResponseEntity<?> carregarPerfis() {
        List<PerfilResponse> perfis = Arrays.stream(Perfil.values()).map(perfil -> {
            return new PerfilResponse(perfil.getNome(), perfil.name());
        }).collect(Collectors.toList());
        return ResponseEntity.ok(perfis);
    }
}