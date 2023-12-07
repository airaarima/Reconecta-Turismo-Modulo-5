package com.recodepro.reconectaturismo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Passagens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "destino")
    private Destinos destino;

    @Column(nullable=false)
    private String local_partida;

    @Column(nullable=false)
    private LocalDate data_partida;

    @Column(nullable=false)
    private LocalDate data_retorno;

    public Passagens() {}

    public Passagens(Long id, Usuarios usuario, Destinos destino, String local_partida, LocalDate data_partida, LocalDate data_retorno) {
        this.id = id;
        this.usuario = usuario;
        this.destino = destino;
        this.local_partida = local_partida;
        this.data_partida = data_partida;
        this.data_retorno = data_retorno;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
