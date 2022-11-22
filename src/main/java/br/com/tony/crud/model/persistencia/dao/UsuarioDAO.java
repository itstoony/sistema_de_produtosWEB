package br.com.tony.crud.model.persistencia.dao;

import br.com.tony.crud.model.Usuario;
import br.com.tony.crud.model.persistencia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rset = null;

    public void cadastraUsuario(Usuario usuario){

        String sql = "INSERT INTO usuarios (usuario_nome, usuario_senha) values (?, ?)";

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getSenha());
            pstm.execute();
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public Usuario getUsuario(String nome){

        Usuario usuario = null;
        String sql = "SELECT * FROM usuarios WHERE usuario_nome = ?";

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, nome);
            rset = pstm.executeQuery();
            while(rset.next()){
                usuario = new Usuario();
                usuario.setId(rset.getInt("usuario_id"));
                usuario.setNome(nome);
                usuario.setSenha(rset.getString("usuario_senha"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }


}
