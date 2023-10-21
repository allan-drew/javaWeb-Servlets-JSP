<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>

<html lang="en">

    <head>
        <meta charset="UTF-8">
        <title> Conexão estabelecida! </title>

        <link rel="stylesheet" href="styles.css">
    </head>

    <body>

          <div> <h1> CONEXÃO ESTABELECIDA COM SUCESSO! </h1> </div>

          <c:set var="stringConexao" value="${con}" />
          <p> Conexão: <span style="color: blue; font-weight: bold;"> ${stringConexao} </span>  </p>

          <a href="index.html" class="botao-voltar"> VOLTAR </a>

    </body>

</html>