package dev.aadc.acoes;

import dev.aadc.conexao.ConnectionFactoryWeb;
import dev.aadc.dao.ClientesDAO;
import dev.aadc.model.Clientes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

public class SelectParaAtualizar {

    public void executaSelectParaAtualizar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idRecebido = req.getParameter("id");

        Connection con = ConnectionFactoryWeb.connection();
        ClientesDAO clientesDAO = new ClientesDAO(con);
        Optional<Clientes> clienteEncontrado = clientesDAO.findById(Integer.valueOf(idRecebido));

        // Setar atributo para o formulário de atualização no atualizar-cliente.jsp
        req.setAttribute("clienteEncontrado", clienteEncontrado);

        //
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/atualizar-cliente.jsp");
        requestDispatcher.forward(req, resp);

    }


}
