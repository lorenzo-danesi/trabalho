package br.ufsm.csi.so.dao;

import br.ufsm.csi.so.model.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDao {
    //declaração das variáveis
    private String sql;
    private Statement statement; //usado para trazer informações do sql
    private ResultSet resultSet;
    private PreparedStatement preparedStatement; //usado para inserir informações no sql
    private String status;

    public ArrayList<Usuario> getUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        try (Connection connection = new ConectaBD().getConexao()){
            this.sql = "SELECT * FROM usuario";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.resultSet = this.preparedStatement.executeQuery();
            while (resultSet.next()){
                Usuario usuario = new Usuario();
                usuario.setId(this.resultSet.getLong("id"));
                usuario.setNome(this.resultSet.getString("nome"));
                usuario.setSenha(this.resultSet.getString("senha"));

                usuarios.add(usuario);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return usuarios;
    }
}