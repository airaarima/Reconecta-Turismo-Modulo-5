package com.recodepro.reconectaturismo.servicesimpl;

import com.recodepro.reconectaturismo.model.Passagens;
import com.recodepro.reconectaturismo.model.Usuarios;
import com.recodepro.reconectaturismo.repository.PassagensRepository;
import com.recodepro.reconectaturismo.repository.UsuariosRepository;
import com.recodepro.reconectaturismo.services.PassagensService;
import com.recodepro.reconectaturismo.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassagensServiceImpl implements PassagensService {
    @Autowired
    private PassagensRepository pr;

    @Autowired
    private UsuariosService us;

    @Override
    public List<Passagens> getAllPassagens() {
        return pr.findAll();
    }

    @Override
    public Passagens getByIdPassagem(Long id) {
        return pr.findById(id).orElseThrow(() -> new RuntimeException("ID: "+id+"Not Found"));
    }

    @Override
    public Passagens savePassagem(Passagens passagem) {
        return pr.save(passagem);
    }

    @Override
    public Passagens updatePassagem(Long id, Passagens updatePassagem) {
        Passagens passagemExists=pr.findById(id).orElseThrow();
        passagemExists.setUsuario(updatePassagem.getUsuario());
        passagemExists.setDestino(updatePassagem.getDestino());
        passagemExists.setLocal_partida(updatePassagem.getLocal_partida());
        passagemExists.setData_partida(updatePassagem.getData_partida());
        passagemExists.setData_retorno(updatePassagem.getData_retorno());

        return pr.save(passagemExists);
    }

    @Override
    public void deleteById(Long id) {
        pr.deleteById(id);
    }

}
