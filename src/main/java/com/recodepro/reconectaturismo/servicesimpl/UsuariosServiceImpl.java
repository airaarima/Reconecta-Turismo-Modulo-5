package com.recodepro.reconectaturismo.servicesimpl;

import com.recodepro.reconectaturismo.model.Destinos;
import com.recodepro.reconectaturismo.model.Passagens;
import com.recodepro.reconectaturismo.model.Usuarios;
import com.recodepro.reconectaturismo.repository.DestinosRepository;
import com.recodepro.reconectaturismo.repository.PassagensRepository;
import com.recodepro.reconectaturismo.repository.UsuariosRepository;
import com.recodepro.reconectaturismo.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuariosServiceImpl implements UsuariosService {
    @Autowired
    private UsuariosRepository ur;

    @Autowired
    private DestinosRepository dr;

    @Autowired
    private PassagensRepository pr;

    @Override
    public List<Usuarios> getAllUsuarios() {
        return ur.findAll();
    }

    @Override
    public Usuarios getUsuarioById(Long id) {
        return ur.findById(id).orElseThrow(() -> new RuntimeException("ID: " + id + "Not Found"));

    }

    @Override
    public Usuarios saveUsuario(Usuarios usuario) {
        return ur.save(usuario);
    }

    @Override
    public Usuarios updateUsuario(Long id, Usuarios updateUsuario) {
        Usuarios usuarioExists = ur.findById(id).orElseThrow();
        usuarioExists.setNome_completo(updateUsuario.getNome_completo());
        usuarioExists.setCPF(updateUsuario.getCPF());
        usuarioExists.setRG(updateUsuario.getRG());
        usuarioExists.setData_nascimento(updateUsuario.getData_nascimento());
        usuarioExists.setEmail(updateUsuario.getEmail());
        usuarioExists.setRua(updateUsuario.getRua());
        usuarioExists.setNumero(updateUsuario.getNumero());
        usuarioExists.setBairro(updateUsuario.getBairro());
        usuarioExists.setCidade(updateUsuario.getCidade());
        usuarioExists.setUF(updateUsuario.getUF());

        return ur.save(usuarioExists);
    }

    @Override
    public void deleteById(Long id) {
        ur.deleteById(id);
    }

    @Override
    public void comprarPassagem(Long id_usuario, Long id_destino, String local_partida, LocalDate data_partida,
                                LocalDate data_retorno) {
        Usuarios usuario =
                ur.findById(id_usuario).orElseThrow(() -> new RuntimeException("ID: " + id_usuario + "Not Found"));
        Destinos destino = dr.findById(id_destino).orElseThrow(() -> new RuntimeException("ID: " + id_destino + "Not Found"));

        Passagens passagem = new Passagens();
        passagem.setUsuario(usuario);
        passagem.setDestino(destino);
        passagem.setLocal_partida(local_partida);
        passagem.setData_partida(data_partida);
        passagem.setData_retorno(data_retorno);

        pr.save(passagem);

    }

    @Override
    public List<Object[]> getAllPassagensUsuario(Long id_usuario) {
        List<Object[]> passagens = ur.getAllPassagensUsuario(id_usuario);

        return passagens;
    }
}
