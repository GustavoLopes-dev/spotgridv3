package com.example.spotgridv3.formatacoes;

import java.time.LocalDate;

public class pagRegFile {
    private LocalDate dataPag;
    private Long assinaturaId;
    private double valorPago;
    private String cupom;

    // Construtor padrão
    public pagRegFile() {}

    public pagRegFile(LocalDate dataPag, Long assinaturaId, double valorPago) {
        this.dataPag = dataPag;
        this.assinaturaId = assinaturaId;
        this.valorPago = valorPago;
    }

    public pagRegFile(LocalDate dataPag, Long assinaturaId, double valorPago, String cupom) {
        this.dataPag = dataPag;
        this.assinaturaId = assinaturaId;
        this.valorPago = valorPago;
        this.cupom = cupom;
    }

    public LocalDate getDataPag() {
        return dataPag;
    }

    public void setDataPag(LocalDate dataPag) {
        this.dataPag = dataPag;
    }

    public Long getAssinaturaId() {
        return assinaturaId;
    }

    public void setAssinaturaId(Long assinaturaId) {
        this.assinaturaId = assinaturaId;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public String getCupom() {
        return cupom;
    }

    public void setCupom(String cupom) {
        this.cupom = cupom;
    }
}