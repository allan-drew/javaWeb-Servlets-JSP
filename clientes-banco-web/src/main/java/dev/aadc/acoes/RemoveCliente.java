package dev.aadc.acoes;

import dev.aadc.conexao.ConnectionFactoryWeb;
import dev.aadc.dao.ClientesDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class RemoveCliente {

    public void executaRemoveCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idClicado = req.getParameter("id");

        Connection con = ConnectionFactoryWeb.connection();
        ClientesDAO c = new ClientesDAO(con);
        c.delete(Integer.valueOf(idClicado)); // executa a remocao

        // ---------
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/controller?action=listarclientes");
//        requestDispatcher.forward(req, resp);

        resp.sendRedirect("controller?action=listarclientes");

    }

}
