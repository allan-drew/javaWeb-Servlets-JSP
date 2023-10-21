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
import java.util.List;

public class ListaClientes {

    public void executaListaClientes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection con = ConnectionFactoryWeb.connection();
        ClientesDAO clientesDAO = new ClientesDAO(con);
        List<Clientes> clientesBaseDeDados = clientesDAO.findAll();

        // A lista clientesBaseDeDados foi gerada após a consulta no banco de dados.
        // Essa lista será passada para o /listar-clientes.jsp, para que possamos fazer um forEach nela.
        // Ao fazer o forEach, conseguimos montar a tabela com a lista dos clientes
        req.setAttribute("clientesBaseDeDados", clientesBaseDeDados);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/listar-clientes.jsp");
        requestDispatcher.forward(req, resp);

    }

}
