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

public class AtualizarCliente {

    public void executaAtualizarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idClienteForm = req.getParameter("idCliente");
        String nomeClienteForm = req.getParameter("nomeAtualizado");
        String idadeClienteForm = req.getParameter("idadeAtualizada");
        String emailClienteForm = req.getParameter("emailAtualizado");
        String rendaClienteForm = req.getParameter("rendaAtualizada");

        // valores para o objeto:
        Integer idCliente = Integer.valueOf(idClienteForm);
        String nomeCliente = nomeClienteForm;
        Integer idadeCliente = Integer.parseInt(idadeClienteForm);
        String emailCliente = emailClienteForm;
        Double rendaCliente = Double.parseDouble(rendaClienteForm);

        Clientes clienteAtualizado = new Clientes(idCliente, nomeCliente, idadeCliente, emailCliente, rendaCliente);

        Connection con = ConnectionFactoryWeb.connection();
        System.out.println(con);

        ClientesDAO clientesDAO = new ClientesDAO(con);
        clientesDAO.update(clienteAtualizado);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/cliente-atualizado.jsp");
        requestDispatcher.forward(req, resp);

    }

}
