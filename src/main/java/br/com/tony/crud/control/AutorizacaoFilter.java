package br.com.tony.crud.control;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/entrada")
public class AutorizacaoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*
         * Avoids unauthorized users from accessing protected pages and redirects to Login page.
         */
        System.out.println("Chamando autenticador");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String paramAcao = req.getParameter("acao");


        HttpSession sessao = req.getSession();
        boolean usuarioDeslogado = (sessao.getAttribute("usuarioLogado") == null);
        boolean naoProtegica = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
        if ( naoProtegica && usuarioDeslogado){
            resp.sendRedirect("entrada?acao=LoginForm");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
