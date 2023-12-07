package com.recodepro.reconectaturismo.services;

import com.recodepro.reconectaturismo.model.Passagens;
import com.recodepro.reconectaturismo.model.Usuarios;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

public interface UsuariosService {
    List<Usuarios> getAllUsuarios();
    Usuarios getUsuarioById(Long id);
    Usuarios saveUsuario(Usuarios usuario);
    Usuarios updateUsuario(Long id, Usuarios updateUsuario);
    void deleteById(Long id);

    List<Object[]> getAllPassagensUsuario(Long id_usuario);
    void comprarPassagem(Long id_usuario, Long id_destino, String local_partida, LocalDate data_partida,
                         LocalDate data_retorno);
}
