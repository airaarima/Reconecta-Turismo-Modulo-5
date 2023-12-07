package com.recodepro.reconectaturismo.services;

import com.recodepro.reconectaturismo.model.Passagens;
import com.recodepro.reconectaturismo.model.Usuarios;

import java.util.List;

public interface PassagensService {
    List<Passagens> getAllPassagens();
    Passagens getByIdPassagem(Long id);
    Passagens savePassagem(Passagens passagem);
    Passagens updatePassagem(Long id, Passagens updatePassagem);
    void deleteById(Long id);
}
