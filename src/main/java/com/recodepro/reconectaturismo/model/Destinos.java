package com.recodepro.reconectaturismo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Destinos {
    @Id
    private Long id_destino;
    private double valor;
    private String pais;
    private String cidade;

    public Destinos() {}
    public Destinos(Long id_destino, double valor, String pais, String cidade) {
        this.id_destino = id_destino;
        this.valor = valor;
        this.pais = pais;
        this.cidade = cidade;
    }

    public Long getId_destino() {
        return id_destino;
    }
    public void setId_destino(Long id_destino) {
        this.id_destino = id_destino;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
