package com.example.spotgridv3.requestsformat;

public class CriarAssinaturaRequest {
    private long codigoCliente;
    private long codigoApp;
    
    // Getters e Setters
    
    public long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public long getCodigoApp() {
        return codigoApp;
    }

    public void setCodigoApp(long codigoApp) {
        this.codigoApp = codigoApp;
    }    
}
