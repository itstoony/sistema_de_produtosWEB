package br.com.tony.crud;

import br.com.tony.crud.model.Usuario;
import br.com.tony.crud.model.persistencia.dao.UsuarioDAO;

public class testes {
    public static void main(String[] args) {
//        ProdutoDAO dao = new ProdutoDAO();
////
////        System.out.println(dao.getProdutoById(1));
//
//        Produto produto1 = new Produto("Televisão", "Televisão 42' Smart");
//        Produto produto2 = new Produto("Televisão", "Televisão 42' Smart");
////        produto1.cadastraProduto();
//        Produto produto6 = new Produto("Smartphone", "iPhone 14 Pro Max");
//        produto6.cadastraProduto();
//        Produto produto3 = new Produto("Televisão", "Televisão 42' Smart");
//
//        Produto produto4 = dao.getProdutoById(163);
//
//        System.out.println(produto1.getNome().hashCode() + produto1.getDescricao().hashCode());
//        System.out.println(produto2.getNome().hashCode() + produto2.getDescricao().hashCode());
//        System.out.println(produto4.getNome().hashCode() + produto4.getDescricao().hashCode());

        Usuario u1 = new Usuario();
        u1.setNome("isabella");
        u1.setSenha("54321");
        UsuarioDAO dao = new UsuarioDAO();
//        dao.cadastraUsuario(u1);
        System.out.println(dao.getUsuario("isabella"));



//        System.out.println(dao.getProdutos());
    }
}
