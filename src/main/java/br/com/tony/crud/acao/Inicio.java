package br.com.tony.crud.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Inicio implements Acao {


    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return "forward:inicioForm.jsp";
    }
}
