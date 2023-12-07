package com.recodepro.reconectaturismo.controller;

import com.recodepro.reconectaturismo.services.PassagensService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void cancelarPassagem(@PathVariable Long id){
        ps.deleteById(id);
    }
}
