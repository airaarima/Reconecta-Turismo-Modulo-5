package com.recodepro.reconectaturismo.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Destinos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private double valor;

    @Column(nullable=false)
    private String pais;

    @Column(nullable=false)
    private String cidade;

    @OneToMany(mappedBy = "destino", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Passagens> passagem = new HashSet<>();

    public Destinos() {}
    public Destinos(Long id, double valor, String pais, String cidade) {
        this.id = id;
        this.valor = valor;
        this.pais = pais;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
