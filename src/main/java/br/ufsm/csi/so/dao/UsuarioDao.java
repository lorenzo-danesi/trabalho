package br.ufsm.csi.so.dao;

import br.ufsm.csi.so.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioDao() {
        usuarios.add(new Usuario(1, "João", "****"));
        usuarios.add(new Usuario(2, "Maria", "****"));
        usuarios.add(new Usuario(3, "Pedro", "****"));
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}