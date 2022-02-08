<%-- 
    Document   : categoria
    Created on : Mar 15, 2021, 9:16:04 PM
    Author     : pretto
--%>

<%@page import="dao.ProdutoDAO"%>
<%@page import="entidade.Produto"%>
<%@page import="entidade.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.CategoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/paginaInicialStyles.css">
        <title>Smart Buy</title>
    </head>
    <body>
        <%@include file="menuSmartBuy.jsp" %>


        <div id="listaprodutoInicial-container" class="table-responsive">
            <h1>Category List</h1>

            <%
                ArrayList<Categoria> categoria = new CategoriaDAO().consultarTodos();
            %>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <th>Ação</th>
                    <th>Id</th>
                    <th>Descrição</th>
                    <th>Status</th>

                    <%
                        for (int i = 0; i < categoria.size(); i++) {
                            Categoria categ = categoria.get(i);
                    %>
                    <tr>
                        <td><a href='/smartBuy/acao?param=edCategoria&id=<%= categ.getId()%>'><img src="img/edit--v1.png" title="Edit" align="center" alt="icone-editar" width=20px height=20px></a>&nbsp;&nbsp;<a href='/smartBuy/acao?param=exCategoria&id=<%= categ.getId()%>'  onclick="return confirm('Are you sure you want to delete this item?');" ><img src="img/delete.png" title="Delet" align="center" alt="icone-editar" width=20px height=20px></a></td>             
                        <td><%= categ.getId()%></td>
                        <td><%= categ.getDescricao()%></td>
                        <td><%= categ.getStatus()%></td>


                    </tr>

                    <%
                        }
                    %>

                </table>
            </div>
            <br>
            <br>
            <!--<a href='index.jsp'>Voltar</a>-->

        </div>

    </body>
</html>
