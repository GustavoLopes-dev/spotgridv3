package com.example.spotgridv3.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @GetMapping("/{id}")
    public ResponseEntity<Aplicativo> buscarAplicativoPorId(@PathVariable("id") Long id) {
        Optional<Aplicativo> aplicativo = aplicativoService.buscarAplicativoPorId(id);
        return aplicativo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/send")
    public ResponseEntity<Aplicativo> criarAplicativo(@RequestBody Aplicativo aplicativo) {
        Aplicativo novoAplicativo = aplicativoService.criarAplicativo(aplicativo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAplicativo);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAplicativo(@PathVariable("id") Long id) {
        boolean sucesso = aplicativoService.deletarAplicativo(id);
        if (sucesso) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}