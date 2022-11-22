package br.com.tony.crud.model.persistencia.dao;

import br.com.tony.crud.model.Produto;
import br.com.tony.crud.model.persistencia.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rset = null;


    public void cadastraProduto(Produto produto) {

        String sql = "INSERT INTO produtos (produto_nome, dataDeCadastro, produto_descricao) values (?, ?, ?)";

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, produto.getNome());
            pstm.setDate(2, new Date(produto.getDataDeCadastro().getTime()));
            pstm.setString(3, produto.getDescricao());
            pstm.execute();
            System.out.println("Produto cadastrado com sucesso!");
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

    public Produto getProdutoById(int id) {
        String sql = "SELECT * FROM produtos WHERE produto_id = ?";
        Produto produto = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rset = pstm.executeQuery();
            while (rset.next()) {
                produto = new Produto(rset.getString("produto_nome"), rset.getString("produto_descricao"));
                produto.setId(rset.getInt("produto_id"));
                produto.setDataDeCadastro(rset.getDate("dataDeCadastro"));
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
                if (rset != null) {
                    rset.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (produto == null){
            System.out.println("Código de produto inválido");
        }
        return produto;
    }


    public List<Produto> getProdutos(){
        String sql = "SELECT * FROM produtos";
        List<Produto> produtos = new ArrayList<>();
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            while (rset.next()) {
                Produto produto = new Produto(rset.getString("produto_nome"), rset.getString("produto_descricao"));
                produto.setId(rset.getInt("produto_id"));
                produto.setDataDeCadastro(rset.getDate("dataDeCadastro"));
                produtos.add(produto);

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
                if (rset != null) {
                    rset.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return produtos;
    }

    public boolean duplicata(Produto produto){

        /*
         * uses sum of hashcode from name and description fields to avoid saving duplicate product in database
         */

        boolean duplicado = false;
        int hashValidador = produto.getNome().hashCode() + produto.getDescricao().hashCode();
        String sql = "SELECT * FROM produtos";

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            while (rset.next()) {
                Produto p = new Produto(rset.getString("produto_nome"), rset.getString("produto_descricao"));
                p.setId(rset.getInt("produto_id"));
                p.setDataDeCadastro(rset.getDate("dataDeCadastro"));
                int resultado = p.getNome().hashCode() + p.getDescricao().hashCode();
                if (hashValidador == resultado){
                    duplicado = true;
                    break;
                }
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
                if (rset != null) {
                    rset.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return duplicado;

    }


}
