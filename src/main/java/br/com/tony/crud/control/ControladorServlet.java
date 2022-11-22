package br.com.tony.crud.control;

import br.com.tony.crud.acao.Acao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/entrada")
public class ControladorServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Chamando controlador");

        String paramAcao = req.getParameter("acao");
        String nomeDaClasse = "br.com.tony.crud.acao." + paramAcao;
        String nome;

        try {
            Class<?> classe = Class.forName(nomeDaClasse);
            Acao acao = (Acao) classe.newInstance();
            nome = acao.executa(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }

        String [] tipoEEndereco = nome.split(":");
        if (tipoEEndereco[0].equals("forward")){
            RequestDispatcher rq = req.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
            rq.forward(req, resp);
        } else {
            resp.sendRedirect( tipoEEndereco[1]);
        }

    }
}
