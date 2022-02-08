<%-- 
    Document   : select
    Created on : Mar 22, 2021, 9:15:40 PM
    Author     : pretto
--%>

<%@page import="dao.ProdutoDAO"%>
<%@page import="entidade.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.CategoriaDAO"%>
<%@page import="entidade.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menuSmartBuy.jsp" %>

        <h1>Select Categoria</h1>

        <form method="post" action="/smartBuy/chupitz?param=selectProduto">

            <select name="comboCategoria" class="form-select form-select-lg" aria-label=".form-select-sm example">

                <option value="0">Selecione</option>

                <%
                    ArrayList<Produto> produto = new ProdutoDAO().consultarTodos();

                    for (int i = 0; i < produto.size(); i++) {
                %>           
                <option value="<%= produto.get(i).getId()%>"><%= produto.get(i).getDescricao()%></option>
                <%
                    }
                %>
            </select>
            
            <input type="submit" class="btn btn-secondary" value="Enviar...">

        </form>
    </body>
</html>
