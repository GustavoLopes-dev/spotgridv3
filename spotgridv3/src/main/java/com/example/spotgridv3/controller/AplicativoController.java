package com.example.spotgridv3.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spotgridv3.model.Aplicativo;
import com.example.spotgridv3.service.AplicativoService;

@RestController
@RequestMapping("/servcad/aplicativos")
public class AplicativoController {

    private final AplicativoService aplicativoService;

    public AplicativoController(AplicativoService aplicativoService) {
        this.aplicativoService = aplicativoService;
    }

    //okay
    @GetMapping("")
    public List<Aplicativo> listarAplicativos() {
        return aplicativoService.listarTodosAplicativos();
    }

    //okay
    @PostMapping("/atualizacusto/{id}")
    public ResponseEntity<Aplicativo> atualizarCusto(@PathVariable Long id, @RequestBody Map<String, Double> body) {
        Double custo = body.get("custo");
        Aplicativo aplicativo = aplicativoService.atualizarAplicativo(id, custo);
        if (aplicativo != null) {
            return ResponseEntity.ok(aplicativo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}