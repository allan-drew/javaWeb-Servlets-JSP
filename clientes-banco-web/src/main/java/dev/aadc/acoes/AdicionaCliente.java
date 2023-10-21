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

public class AdicionaCliente {

    public void executaAdicionaCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // strings recebidas do form:
        String nomeClienteForm = req.getParameter("nome");
        String idadeClienteForm = req.getParameter("idade");
        String emailClienteForm = req.getParameter("email");
        String rendaClienteForm = req.getParameter("renda");

        // valores para o objeto:
        String nomeCliente = nomeClienteForm;
        Integer idadeCliente = Integer.parseInt(idadeClienteForm);
        String emailCliente = emailClienteForm;
        Double rendaCliente = Double.parseDouble(rendaClienteForm);

        Clientes novoCliente = new Clientes(nomeCliente, idadeCliente, emailCliente, rendaCliente);

        Connection con = ConnectionFactoryWeb.connection();
        ClientesDAO clientesDAO = new ClientesDAO(con);

        clientesDAO.save(novoCliente); // chamamos o método save que vai executar o SQL de INSERT INTO

        // após salvar da base dados, mostramos uma página informando que foi adicionado com sucesso:
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/cliente-adicionado.jsp");
        requestDispatcher.forward(req, resp);

    }

}
