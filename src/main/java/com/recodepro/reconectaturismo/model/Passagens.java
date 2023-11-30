package com.recodepro.reconectaturismo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Passagens {
    @Id
    private Long id_passagem;

    @ManyToOne
    private Usuarios usuario;

    @ManyToOne
    private Destinos destino;

    private String local_partida;
    private LocalDate data_partida;
    private LocalDate data_retorno;

    public Passagens() {}

    public Passagens(Long id_passagem, Usuarios usuario, Destinos destino, String local_partida, LocalDate data_partida, LocalDate data_retorno) {
        this.id_passagem = id_passagem;
        this.usuario = usuario;
        this.destino = destino;
        this.local_partida = local_partida;
        this.data_partida = data_partida;
        this.data_retorno = data_retorno;
    }

    public Long getId_passagem() {
        return id_passagem;
    }
    public void setId_passagem(Long id_passagem) {
        this.id_passagem = id_passagem;
    }

    public Usuarios getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Destinos getDestino() {
        return destino;
    }
    public void setDestino(Destinos destino) {
        this.destino = destino;
    }

    public String getLocal_partida() {
        return local_partida;
    }
    public void setLocal_partida(String local_partida) {
        this.local_partida = local_partida;
    }

    public LocalDate getData_partida() {
        return data_partida;
    }
    public void setData_partida(LocalDate data_partida) {
        this.data_partida = data_partida;
    }

    public LocalDate getData_retorno() {
        return data_retorno;
    }
    public void setData_retorno(LocalDate data_retorno) {
        this.data_retorno = data_retorno;
    }
}
