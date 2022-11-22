package br.com.tony.crud.acao;

import br.com.tony.crud.model.Usuario;
import br.com.tony.crud.model.persistencia.dao.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Cadastro implements Acao {


    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Cadastrando");
        String nome = req.getParameter("login");
        String senha = req.getParameter("senha");
        System.out.println("Login: " + nome + ", Senha: " + senha );
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usu = new Usuario();
        usu.setSenha(senha);
        usu.setNome(nome);
        dao.cadastraUsuario(usu);
        System.out.println("Usuário cadastrado");

//            return "redirect:entrada?acao=Cadastro";

        return "redirect:entrada?acao=LoginForm";
    }
}
