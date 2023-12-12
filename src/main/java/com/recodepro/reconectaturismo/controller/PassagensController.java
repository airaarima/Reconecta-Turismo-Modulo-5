package com.recodepro.reconectaturismo.controller;

import com.recodepro.reconectaturismo.exception.PassagemNotFoundException;
import com.recodepro.reconectaturismo.exception.UsuarioNotFoundException;
import com.recodepro.reconectaturismo.services.PassagensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passagem")
public class PassagensController {

    @Autowired
    private PassagensService ps;

    @GetMapping("/listar")
    public List<Object[]> listar(){
        return ps.getAllPassagens();
    }

    @DeleteMapping("/cancelar/{id}")
    public ResponseEntity cancelarPassagem(@PathVariable Long id){
        try{
            ps.deleteById(id);
            return ResponseEntity.ok("Passagem cancelada!");
        }catch (PassagemNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Passagem não encontrada!");
        }

    }
}
