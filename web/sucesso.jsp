<%-- 
    Document   : sucesso
    Created on : Mar 15, 2021, 9:47:15 PM
    Author     : pretto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Smart Buy</title>
    </head>
    <body>
        <%--@include file="menuSmartBuy.jsp" --%> 

        <%
            String tipoCadastro = String.valueOf(request.getAttribute("tipoLogin"));
            String paginaRetorno = String.valueOf(request.getAttribute("paginaRetorno"));
        %>

        <h1>Sucesso!</h1>
        
        <h4>Ação realizada com sucesso em: <%= tipoCadastro%>.</h4>

        <p><a href='<%= paginaRetorno%>' >Avançar</a></p>
    </body>
</html>
