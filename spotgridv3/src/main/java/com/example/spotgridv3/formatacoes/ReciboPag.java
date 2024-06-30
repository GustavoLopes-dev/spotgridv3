package com.example.spotgridv3.formatacoes;

import java.time.LocalDate;

public class ReciboPag {
    private String status;
    private LocalDate data;
    private double valorEstorno;

    public ReciboPag(String status, LocalDate data, double valorEstorno) {
        this.status = status;
        this.data = data;
        this.valorEstorno = valorEstorno;
    }
    public ReciboPag() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValorEstorno() {
        return valorEstorno;
    }

    public void setValorEstorno(double valorEstorno) {
        this.valorEstorno = valorEstorno;
    }

    
}
