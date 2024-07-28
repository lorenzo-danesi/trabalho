package br.ufsm.csi.so.controller;

import br.ufsm.csi.so.dao.UsuarioDao;
import br.ufsm.csi.so.model.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @GetMapping("/listar")
    public List<Usuario> getUsuarios() {
        return new UsuarioDao().getUsuarios();
    }
}
