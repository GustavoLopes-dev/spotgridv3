package com.example.spotgridv3.model;

import java.time.LocalDate;
import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "codigo_aplicativo")
    private Aplicativo aplicativo;

    @ManyToOne
    @JoinColumn(name = "codigo_cliente")
    private Cliente cliente;
 
    @Column(name = "status_atual")
    private String statusAtual;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;

    // Construtores, Getters e Setters
    public Assinatura() {
    }

    public Assinatura(Cliente cliente, Aplicativo aplicativo) {
        this.cliente = cliente;
        this.aplicativo = aplicativo;
        this.inicioVigencia = LocalDate.now();
        this.fimVigencia = this.inicioVigencia.plusDays(7); // Dias de teste gratis
    }

    public Assinatura(Optional<Cliente> cliente, Optional<Aplicativo> aplicativo) {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Aplicativo getAplicativo() {
        return aplicativo;
    }

    public void setAplicativo(Aplicativo aplicativo) {
        this.aplicativo = aplicativo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getStatus() {
        return statusAtual;
    }

    public void setStatus(String status) {
        this.statusAtual = status;
    }

    public LocalDate getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(LocalDate inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public LocalDate getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(LocalDate fimVigencia) {
        this.fimVigencia = fimVigencia;
    }
}