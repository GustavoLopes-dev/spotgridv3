package com.example.spotgridv3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spotgridv3.model.Pagamento;
import com.example.spotgridv3.service.PagamentoService;

@RestController
@RequestMapping("/servcad/pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<Pagamento> registrarPagamento(
            @RequestParam Long assinaturaId,
            @RequestParam double valorPago,
            @RequestParam String promocao
    ) {
        Pagamento pagamento = pagamentoService.registrarPagamento(assinaturaId, valorPago, promocao);
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamento);
    }
}