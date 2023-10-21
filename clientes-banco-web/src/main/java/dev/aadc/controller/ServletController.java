package dev.aadc.controller;

import dev.aadc.acoes.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class ServletController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        System.out.println(action);

        if (action.equals("listarclientes")){
            new ListaClientes().executaListaClientes(req, resp);
        } else if (action.equals("adicionaCliente")) {
            new AdicionaCliente().executaAdicionaCliente(req, resp);
        } else if (action.equals("removecliente")) {
            new RemoveCliente().executaRemoveCliente(req, resp);
        } else if (action.equals("selectParaAtualizar")) {
            new SelectParaAtualizar().executaSelectParaAtualizar(req, resp);
        } else if (action.equals("atualizarCliente")) {
            new AtualizarCliente().executaAtualizarCliente(req, resp);
        }


    }

}
