package com.recodepro.reconectaturismo.services;

import com.recodepro.reconectaturismo.model.Usuarios;

import java.util.List;

public interface UsuariosService {
    List<Usuarios> getAllUsuarios();
    Usuarios getUsuarioById(Long id);
    Usuarios saveUsuario(Usuarios usuario);
    Usuarios updateUsuario(Long id, Usuarios updateUsuario);
    void deleteById(Long id);
    List<Object[]> getAllPassagensUsuario(Long id_usuario);
}
