package br.com.tony.crud.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout implements Acao {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Logout...");
        HttpSession sessao = req.getSession();
        sessao.invalidate();
        return "Redirect:entrada?acao=LoginForm";
    }
}
