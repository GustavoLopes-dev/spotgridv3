package com.example.spotgridv3.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spotgridv3.formatacoes.ReciboPag;
import com.example.spotgridv3.formatacoes.pagRegFile;
import com.example.spotgridv3.service.PagamentoService;

@RestController
@RequestMapping("/registrarpagamento")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    //okay
    @PostMapping
    public ReciboPag registrarPagamento(@RequestBody pagRegFile pagamentoFile) {         
        return pagamentoService.registrarPagamento(pagamentoFile.getDataPag(), 
                                                   pagamentoFile.getAssinaturaId(), 
                                                   pagamentoFile.getValorPago(),
                                                   pagamentoFile.getCupom());
    }
}