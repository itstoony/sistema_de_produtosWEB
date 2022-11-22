package br.com.tony.crud.control;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        long antes = System.currentTimeMillis();

        filterChain.doFilter(servletRequest, servletResponse);

        long depois = System.currentTimeMillis();
        long total = depois - antes;
        System.out.println("Tempo de execução: " +  total);


    }
}
