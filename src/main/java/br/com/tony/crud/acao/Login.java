package br.com.tony.crud.acao;


import br.com.tony.crud.model.Usuario;
import br.com.tony.crud.model.persistencia.dao.UsuarioDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login implements Acao {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usu = dao.getUsuario(login);
        System.out.println(usu);

        if (usu == null){
            return "redirect:entrada?acao=LoginForm";
        } else if (usu.getNome().equals(login) && usu.getSenha().equals(senha)) {
            return "redirect:entrada?acao=Inicio";
        } else {
            return "redirect:entrada?acao=LoginForm";
        }


    }
}
