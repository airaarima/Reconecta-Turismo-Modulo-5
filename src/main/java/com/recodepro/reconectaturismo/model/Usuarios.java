package com.recodepro.reconectaturismo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String nome_completo;

    @Column(nullable=false)
    private String CPF;

    @Column(nullable=false)
    private String RG;

    @Column(nullable=false)
    private LocalDate data_nascimento;

    @Column(nullable=false)
    private String email;

    @Column(nullable=false)
    private String rua;

    @Column(nullable=false)
    private String numero;

    @Column(nullable=false)
    private String bairro;

    @Column(nullable=false)
    private String cidade;

    @Column(nullable=false)
    private String UF;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Passagens> passagem = new HashSet<>();

    public Usuarios() {
    }

    public Usuarios(Long id, String nome_completo, String CPF, String RG, LocalDate data_nascimento, String email, String rua, String numero, String bairro, String cidade, String UF) {
        this.id = id;
        this.nome_completo = nome_completo;
        this.CPF = CPF;
        this.RG = RG;
        this.data_nascimento = data_nascimento;
        this.email = email;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.UF = UF;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_completo() {
        return nome_completo;
    }
    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }
    public void setRG(String RG) {
        this.RG = RG;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }
    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return UF;
    }
    public void setUF(String UF) {
        this.UF = UF;
    }

    public Set<Passagens> getPassagem() {
        return passagem;
    }
    public void setPassagem(Set<Passagens> passagem) {
        this.passagem = passagem;
    }
}
