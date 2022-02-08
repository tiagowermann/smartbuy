<%-- 
    Document   : pesquisa
    Created on : Mar 22, 2021, 9:35:23 PM
    Author     : pretto
--%>

<%@page import="entidade.Produto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidade.Categoria"%>
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

            <h1>Category Search</h1>

            <form method="post" action="/smartBuy/chupitz?param=pesquisaCategorias">


                <div class="full-box">
                    <label for="campoDeBusca">Descrição</label>
                    <input type="text" name="campoDeBusca" placeholder="Type what you want to search" autofocus>
                </div>
                
                
                <input type="submit" value="Search">

            </form>

            <%
                ArrayList<Categoria> categoria = (ArrayList) request.getAttribute("categoriasPesquisa");

                // testar se obj esta nulo.
                // quando viemos do Menu (direto), não há obj em categoriasPesquisa, logo, o cast será NULL
                if (categoria != null) {

                    if (categoria.size() == 0) {
            %>  
            <p>Nenhum resultado encontrado.</p>

            <%
            } else {
            %>

            <br>
            <h2>Results</h2>

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
                        <td><a href='/smartBuy/acao?param=edCategoria&id=<%= categ.getId()%>'><img src="img/edit--v1.png" title="Edit" align="center" alt="icone-editar" width=20px height=20px></a>&nbsp;&nbsp;<a href='/smartBuy/acao?param=exCategoria&id=<%= categ.getId()%>'  onclick="return confirm('Are you sure you want to delete this item?');" ><img src="img/delete.png" title="Delet" align="center" alt="icone-excluir" width=20px height=20px></a></td>
                        <td><%= categ.getId()%></td>                                          
                        <td><%= categ.getDescricao()%></td>
                        <td><%= categ.getStatus()%></td>
                    </tr>

                    <%
                        }
                    %>

                </table>
            </div>
        </div>
        <%
                }
            }
        %>

    </body>
</html>
