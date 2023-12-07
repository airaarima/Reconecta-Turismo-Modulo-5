package com.recodepro.reconectaturismo.model;

public class UsuariosPassagensDTO {
    private String usuario;
    private String destino;

    public UsuariosPassagensDTO() {
    }

    public UsuariosPassagensDTO(String usuario, String destino) {
        this.usuario = usuario;
        this.destino = destino;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
