package com.recodepro.reconectaturismo.controller;

import com.recodepro.reconectaturismo.model.Passagens;
import com.recodepro.reconectaturismo.services.PassagensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passagem")
public class PassagensController {

    @Autowired
    private PassagensService ps;

    @GetMapping("/listar")
    public List<Passagens> listar(){
        return ps.getAllPassagens();
    }

    @GetMapping("/detalhar/{id}")
    public ResponseEntity<Passagens> detalhar(@PathVariable Long id){
        Passagens passagem = ps.getByIdPassagem(id);
        return ResponseEntity.ok(passagem);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Passagens> atualizar(@PathVariable Long id, @RequestBody Passagens updatePassagem){
        Passagens passagem = ps.getByIdPassagem(id);
        passagem.setLocal_partida(updatePassagem.getLocal_partida());
        passagem.setData_partida(updatePassagem.getData_partida());
        passagem.setData_retorno(updatePassagem.getData_retorno());

        ps.savePassagem(passagem);
        return ResponseEntity.ok(passagem);
    }

    @DeleteMapping("/cancelar/{id}")
    public void cancelarPassagem(@PathVariable Long id){
        ps.deleteById(id);
    }

}
