package com.recodepro.reconectaturismo.services;

import com.recodepro.reconectaturismo.model.Passagens;
import com.recodepro.reconectaturismo.model.Usuarios;

import java.util.List;

public interface PassagensService {
    List<Object[]> getAllPassagens();
    void deleteById(Long id);
}
