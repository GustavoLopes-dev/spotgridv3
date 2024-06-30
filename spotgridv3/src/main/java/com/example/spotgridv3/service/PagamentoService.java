package com.example.spotgridv3.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spotgridv3.model.Assinatura;
import com.example.spotgridv3.model.Pagamento;
import com.example.spotgridv3.repository.AssinaturaRepository;
import com.example.spotgridv3.repository.PagamentoRepository;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final AssinaturaRepository assinaturaRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository, AssinaturaRepository assinaturaRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.assinaturaRepository = assinaturaRepository;
    }

    @Transactional
    public Pagamento registrarPagamento(Long assinaturaId, Double valorPago, String promocao) {
        // Busca a assinatura pelo ID
        Assinatura assinatura = assinaturaRepository.findById(assinaturaId)
                .orElseThrow(() -> new IllegalArgumentException("Assinatura não encontrada com o ID: " + assinaturaId));

        // Cria um novo pagamento
        Pagamento pagamento = new Pagamento();
        pagamento.setAssinatura(assinatura);
        pagamento.setValorPago(valorPago);
        pagamento.setDataPagamento(LocalDate.now());
        pagamento.setPromocao(promocao);

        // Salva o pagamento no banco de dados
        return pagamentoRepository.save(pagamento);
    }
}