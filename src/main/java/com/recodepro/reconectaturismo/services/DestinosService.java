package com.recodepro.reconectaturismo.services;

import com.recodepro.reconectaturismo.model.Destinos;

import java.util.List;

public interface DestinosService {
    List<Destinos> getAllDestinos();
    Destinos getDestinoById(Long id);
    Destinos saveDestino(Destinos destino);
    Destinos updateDestino(Long id, Destinos updateDestino);
    Destinos deleteById(Long id);
}
