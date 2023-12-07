package com.recodepro.reconectaturismo.controller;

import com.recodepro.reconectaturismo.model.Destinos;
import com.recodepro.reconectaturismo.services.DestinosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinos")
public class DestinosController {

    @Autowired
    private DestinosService ds;

    @GetMapping("/listar")
    public List<Destinos> listar(){
        return ds.getAllDestinos();
    }

    @PostMapping("/criar")
    public Destinos criar(@RequestBody Destinos destino){
        return ds.saveDestino(destino);
    }

    @GetMapping("/detalhar/{id}")
    public ResponseEntity<Destinos> detalhar(@PathVariable Long id){
        Destinos destino = ds.getDestinoById(id);
        return ResponseEntity.ok(destino);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Destinos> atualizar(@PathVariable Long id, @RequestBody Destinos updateDestino){
        Destinos destino = ds.getDestinoById(id);
        destino.setValor(updateDestino.getValor());
        destino.setPais(updateDestino.getPais());
        destino.setCidade(updateDestino.getCidade());

        ds.saveDestino(destino);
        return ResponseEntity.ok(destino);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarDestino(@PathVariable Long id){
        ds.deleteById(id);
    }
}