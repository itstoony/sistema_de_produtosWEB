package br.com.tony.crud.control;

import br.com.tony.crud.acao.Acao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/inicio")
public class ControladorFilter extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Chamando controlador");
        String paramAcao = req.getParameter("acao");
        String nomeDaClasse = "br.com.tony.crud.acao." + paramAcao;
        String nome;

        try {
            Class<?> classe = Class.forName(nomeDaClasse);
            Acao acao = (Acao) classe.newInstance();

        } catch (Exception e) {
            throw new ServletException(e);
        }

    }
}
