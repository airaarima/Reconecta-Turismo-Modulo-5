package com.recodepro.reconectaturismo.model;

import java.time.LocalDate;

public class UsuariosPassagensDTO {
    private Long id_usuario;
    private Long id_destino;
    private String local_partida;
    private LocalDate data_partida;
    private LocalDate data_retorno;

    public UsuariosPassagensDTO() {
    }

    public UsuariosPassagensDTO(Long id_usuario, Long id_destino, String local_partida, LocalDate data_partida, LocalDate data_retorno) {
        this.id_usuario = id_usuario;
        this.id_destino = id_destino;
        this.local_partida = local_partida;
        this.data_partida = data_partida;
        this.data_retorno = data_retorno;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getId_destino() {
        return id_destino;
    }

    public void setId_destino(Long id_destino) {
        this.id_destino = id_destino;
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
