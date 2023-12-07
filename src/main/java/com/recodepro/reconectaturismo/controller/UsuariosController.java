package com.recodepro.reconectaturismo.controller;

import com.recodepro.reconectaturismo.model.Destinos;
import com.recodepro.reconectaturismo.model.Passagens;
import com.recodepro.reconectaturismo.model.Usuarios;
import com.recodepro.reconectaturismo.services.DestinosService;
import com.recodepro.reconectaturismo.services.PassagensService;
import com.recodepro.reconectaturismo.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

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
    public ResponseEntity<Usuarios> detalhar(@PathVariable Long id){
        Usuarios usuario = us.getUsuarioById(id);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Usuarios> atualizar(@PathVariable Long id, @RequestBody Usuarios updateUsuario){
        Usuarios usuario = us.getUsuarioById(id);
        usuario.setNome_completo(updateUsuario.getNome_completo());
        usuario.setCPF(updateUsuario.getCPF());
        usuario.setRG(updateUsuario.getRG());
        usuario.setData_nascimento(updateUsuario.getData_nascimento());
        usuario.setEmail(updateUsuario.getEmail());
        usuario.setRua(updateUsuario.getRua());
        usuario.setNumero(updateUsuario.getNumero());
        usuario.setBairro(updateUsuario.getBairro());
        usuario.setCidade(updateUsuario.getCidade());
        usuario.setUF(updateUsuario.getUF());

        us.saveUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarUsuario(@PathVariable Long id){
        us.deleteById(id);
    }

    //Passagem
    @Autowired
    private PassagensService ps;

    @Autowired
    private DestinosService ds;


    @PostMapping("/comprar-passagem/{id_usuario}")
    public Passagens comprarPassagem(@RequestBody Passagens passagem, @PathVariable Long id_usuario, Destinos destino){
        Usuarios usuario = us.getUsuarioById(id_usuario);
        passagem.setUsuario(usuario);

        destino = ds.getDestinoById(destino.getId());
        passagem.setDestino(destino);

        return ps.savePassagem(passagem);
    }

    @GetMapping("/listar-passagens/{id_usuario}")
    public ResponseEntity<List<Object[]>> getPassangensUsuario (@PathVariable Long id_usuario){
        List<Object[]> passagens = us.getAllPassagensUsuario(id_usuario);
        return ResponseEntity.ok(passagens);
    }


}
