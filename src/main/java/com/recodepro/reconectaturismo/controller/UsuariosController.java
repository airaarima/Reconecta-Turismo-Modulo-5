package com.recodepro.reconectaturismo.controller;

import com.recodepro.reconectaturismo.exception.DestinoNotFoundException;
import com.recodepro.reconectaturismo.exception.UsuarioNotFoundException;
import com.recodepro.reconectaturismo.model.Usuarios;
import com.recodepro.reconectaturismo.model.UsuariosPassagensDTO;
import com.recodepro.reconectaturismo.services.DestinosService;
import com.recodepro.reconectaturismo.services.PassagensService;
import com.recodepro.reconectaturismo.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    //Usuarios
    @Autowired
    private UsuariosService us;

    @GetMapping("/listar")
    public List<Usuarios> listar(){
        return us.getAllUsuarios();
    }

    @PostMapping("/criar")
    public Usuarios criar(@RequestBody Usuarios usuario){
        return us.saveUsuario(usuario);
    }

    @GetMapping("/detalhar/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        try{
            Usuarios usuario = us.getUsuarioById(id);
            return ResponseEntity.ok(usuario);
        }catch (UsuarioNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Usuarios updateUsuario){
        try{
            Usuarios usuario = us.updateUsuario(id, updateUsuario);
            return ResponseEntity.ok(usuario);
        }catch (UsuarioNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarUsuario(@PathVariable Long id){
        try{
            us.deleteById(id);
            return ResponseEntity.ok("Usuário deletado!");
        }catch (UsuarioNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
    }

    //Passagem
    @Autowired
    private PassagensService ps;

    @Autowired
    private DestinosService ds;

    @PostMapping("/comprar-passagem")
    public ResponseEntity comprarPassagem (@RequestBody UsuariosPassagensDTO upDTO){
        try {
            us.comprarPassagem(upDTO.getId_usuario(),upDTO.getId_destino(), upDTO.getLocal_partida(),
                    upDTO.getData_partida(),upDTO.getData_retorno());

            return ResponseEntity.ok("Passagem comprada!");
        } catch (UsuarioNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        } catch (DestinoNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino não encontrado!");
        }
    }

    @GetMapping("/listar-passagens/{id_usuario}")
    public ResponseEntity getPassangensUsuario (@PathVariable Long id_usuario){
        String listaVazia = "Usuário ainda não realizou a compra de passagens!";
        try{
            List<Object[]> passagens = us.getAllPassagensUsuario(id_usuario);

            if(passagens.isEmpty()){
                return ResponseEntity.ok(listaVazia);
            }else{
                return ResponseEntity.ok(passagens);
            }

        }catch (UsuarioNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
    }
}
