<%-- 
    Document   : paginainicial
    Created on : 9 de abr de 2021, 23:43:45
    Author     : tiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/paginaInicialStyles.css">
        <title>Smart Buy - Home</title>

    </head>
    <body>

        <%@include file="listaCompra.jsp" %>

        <div id="listaprodutoInicial-container" class="table-responsive">
            <form method="post" action="/smartBuy/acao?param=finalizaCompra">

                

                <input type="submit" value="Buy">

            </form>

            <!--
        <section>
            <div class="centro">
                Primeiro valor:
                <input class="num1" type="text"><br>
                Segundo valor:
                <input class="num2" type="number"><br>
                <button onclick="clicar()">Resultado</button>
                <p class="resultado"></p>
            </div>
        </section>
            -->
        </div>
    </body>
</html>
