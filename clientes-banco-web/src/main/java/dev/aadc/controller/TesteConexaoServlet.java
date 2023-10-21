package dev.aadc.controller;

import dev.aadc.conexao.ConnectionFactoryWeb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(urlPatterns = {"/testeconexao"})
public class TesteConexaoServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection con = ConnectionFactoryWeb.connection();
        System.out.println(con);

        if (con != null) {
            req.setAttribute("con", con);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/conexao-estabelecida.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/erro-conexao.jsp");
            requestDispatcher.forward(req, resp);
        }

    }
}


