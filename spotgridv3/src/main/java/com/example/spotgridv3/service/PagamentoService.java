package com.example.spotgridv3.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.spotgridv3.formatacoes.ReciboPag;
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

    public ReciboPag registrarPagamento(LocalDate dataPag, Long assinaturaId, Double valorPago, String cupom) {
        // Busca a assinatura pelo ID
        Assinatura assinatura = assinaturaRepository.findById(assinaturaId)
                .orElseThrow(() -> new IllegalArgumentException("Assinatura não encontrada com o ID: " + assinaturaId));

        ReciboPag recibo = new ReciboPag();

        double valorEstorno = valorPago - assinatura.getAplicativo().getCustoMensal();

        // Atualiza a assinatura
        LocalDate dataAtual = LocalDate.now();
        LocalDate fimVigencia;

        if (valorEstorno >= 0) {
            if (cupom!=null && cupom.equalsIgnoreCase("anual40")) {
                valorEstorno+=valorEstorno*0.4;
                fimVigencia = dataPag.plusDays(30);
            } else if(cupom!=null && cupom.equalsIgnoreCase("promo45")) {
                fimVigencia = dataPag.plusDays(45);
            } else {
                fimVigencia = dataPag.plusDays(30);
            }
            assinatura.setInicioVigencia(dataPag);
            assinatura.setFimVigencia(fimVigencia);
            assinatura.setStatus("ativo");
            assinaturaRepository.save(assinatura);

            // Cria um novo pagamento
            Pagamento pagamento = new Pagamento();
            pagamento.setAssinatura(assinatura);
            pagamento.setValorPago(valorPago);
            pagamento.setDataPagamento(dataAtual);
            // Salva o pagamento no banco de dados
            pagamentoRepository.save(pagamento);

            recibo.setData(dataPag);
            recibo.setValorEstorno(valorEstorno);
            recibo.setStatus("PAGAMENTO_OKAY");
        } else {
            recibo.setData(dataPag);
            recibo.setValorEstorno(valorEstorno);
            recibo.setStatus("VALOR_INCORRETO");
        }

        return recibo;
    }
}