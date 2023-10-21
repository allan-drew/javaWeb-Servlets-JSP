<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<%@ page import= "java.sql.Connection"%>
<%@ page import= "dev.aadc.conexao.ConnectionFactoryWeb"%>

<%@ page import= "dev.aadc.dao.ClientesDAO"%>
<%@ page import= "dev.aadc.model.Clientes"%>
<%@ page import= "java.util.List"%>
<%@ page import= "java.util.ArrayList"%>


<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="UTF-8">
        <title> LISTA DE CLIENTES DO BANCO </title>

        <link rel="stylesheet" href="styles.css">
    </head>


    <body>

        <h1> Olá usuário do sistema! </h1>
        <h1> LISTA DOS CLIENTES: </h1>


        <table>
            <tr>
                <th> ID </th>
                <th> NOME </th>
                <th> IDADE </th>
                <th> EMAIL </th>
                <th> RENDA </th>
            </tr>

            <c:forEach var="c" items="${clientesBaseDeDados}">
            <tr>
                <td> ${c.getId()} </td>
                <td> ${c.getNome()} </td>
                <td> ${c.getIdade()} </td>
                <td> ${c.getEmail()} </td>
                <td> ${c.getRenda()} </td>

                <td> <a href="javascript: confirmarExclusao(${c.getId()})" class="remover-cliente"> Remover </a> </td>

                <td> <a href="controller?action=selectParaAtualizar&id=${c.getId()}" class="atualizar-cliente"> Atualizar </a> </td>
            </tr>
            </c:forEach>
        </table>

        <br>
        <br>

        <div> <a href="adicionar-cliente.html" class="botoes-iniciais"> ADICIONAR CLIENTE </a> </div>
        <div> <a href="index.html" class="botao-voltar"> VOLTAR </a> </div>

        <br>
        <br>
        <br>
        <br>

        <script src="scripts/confirmar-remocao.js"> </script>

    </body>

</html>