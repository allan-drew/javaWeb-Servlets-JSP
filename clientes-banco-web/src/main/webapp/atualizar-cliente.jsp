
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <title> Atualizar o cliente! </title>

        <link rel="stylesheet" href="styles.css">
    </head>


    <body>

      <h1> ATUALIZE O(A) CLIENTE SELECIONADO: </h1>
      <h1> Cliente Encontrado:  </h1>

        <form id="clientes-banco-form" action="controller?action=atualizarCliente" method="post">

          <div class="form-div">
            <label for="id-cliente"> ID (não é possível alterar) </label>
            <input class="color-box-id" id="id-cliente" type="text" name="idCliente" readonly value="${clienteEncontrado.get().getId()}" >
          </div>

          <br>

          <div class="form-div">
            <label for="nome-cliente"> NOME ATUALIZADO </label>
            <input class="color-box" id="nome-cliente" type="text" name="nomeAtualizado" value="${clienteEncontrado.get().getNome()}" >
          </div>

          <br>

          <div class="form-div">
            <label for="idade-cliente"> IDADE ATUALIZADA </label>
            <input class="color-box" id="idade-cliente" type="text" name="idadeAtualizada" value="${clienteEncontrado.get().getIdade()}" >
          </div>

          <br>

          <div class="form-div">
            <label for="email-cliente"> EMAIL ATUALIZADO </label>
            <input class="color-box" id="email-cliente" type="text" name="emailAtualizado" value="${clienteEncontrado.get().getEmail()}" >
          </div>

          <br>

          <div class="form-div">
            <label for="renda-cliente"> RENDA ATUALIZADA </label>
            <input class="color-box" id="renda-cliente" type="text" name="rendaAtualizada" value="${clienteEncontrado.get().getRenda()}" >
          </div>

          <button id="submit" type="submit"> ATUALIZAR CLIENTE </button>

          <a href="controller?action=listarclientes" class="botao-voltar"> VOLTAR </a>

        </form>

    </body>


</html>

