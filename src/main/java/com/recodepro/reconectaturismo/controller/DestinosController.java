package com.recodepro.reconectaturismo.controller;

import com.recodepro.reconectaturismo.exception.DestinoNotFoundException;
import com.recodepro.reconectaturismo.model.Destinos;
import com.recodepro.reconectaturismo.services.DestinosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity detalhar(@PathVariable Long id){
        try{
            Destinos destino = ds.getDestinoById(id);
            return ResponseEntity.ok(destino);
        }catch (DestinoNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino não encontrado!");
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Destinos updateDestino){
        try{
            Destinos destino = ds.updateDestino(id, updateDestino);
            return ResponseEntity.ok(destino);
        }catch(DestinoNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino não encontrado!");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarDestino(@PathVariable Long id){
        try{
            ds.deleteById(id);
            return ResponseEntity.ok("Destino deletado!");
        }catch(DestinoNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino não encontrado!");
        }
    }
}