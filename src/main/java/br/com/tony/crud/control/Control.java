package br.com.tony.crud.control;

import br.com.tony.crud.acao.Acao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns = "/entrada")
public class Control implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Chamando controlador");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String paramAcao = req.getParameter("acao");

        String nomeDaClasse = "br.com.caelum.gerenciador.acao." + paramAcao;
        String nome;

        try {
            Class<?> classe = Class.forName(nomeDaClasse);
            Acao acao = (Acao) classe.newInstance();
            nome = acao.executa(req, resp);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServletException(e);
        }


        String[] tipoEEndereco = nome.split(":");
        if (tipoEEndereco[0].equals("forward")) {
            RequestDispatcher rq = req.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
            rq.forward(req, resp);
        } else {
            resp.sendRedirect(tipoEEndereco[1]);
        }
    }
}

