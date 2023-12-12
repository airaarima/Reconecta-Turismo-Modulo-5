package com.recodepro.reconectaturismo.services;

import com.recodepro.reconectaturismo.model.Passagens;
import com.recodepro.reconectaturismo.model.Usuarios;

import java.time.LocalDate;
import java.util.List;

public interface UsuariosService {
    List<Usuarios> getAllUsuarios();
    Usuarios getUsuarioById(Long id);
    Usuarios saveUsuario(Usuarios usuario);
    Usuarios updateUsuario(Long id, Usuarios updateUsuario);
    Usuarios deleteById(Long id);

    List<Object[]> getAllPassagensUsuario(Long id_usuario);
    Passagens comprarPassagem(Long id_usuario, Long id_destino, String local_partida, LocalDate data_partida,
                              LocalDate data_retorno);
}
