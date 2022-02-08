<%-- 
    Document   : pesquisa
    Created on : Mar 22, 2021, 9:35:23 PM
    Author     : pretto
--%>

<%@page import="dao.CategoriaDAO"%>
<%@page import="entidade.Produto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidade.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/paginaInicialStyles.css">
        <title>Smart Buy</title>
    </head>
    <body>
        <%@include file="menuSmartBuy.jsp" %>


        <div id="listaprodutoInicial-container" class="table-responsive">

            <h1>Search</h1>

            <form id="register-form" name='formCategoria' method="post" action="/smartBuy/chupitz?param=pesquisaProdutoECategoria">


                <div class="half-box spacing">  <!-- criando um formulário para o nome -->
                    <label for="campoDeBuscaDescricao">Search Descrition</label>
                    <input type="text" name="campoDeBuscaDescricao" placeholder="Type what you want to search" autofocus>
                </div>


                <div class="half-box spacing">
                    <label for="categoria">Categoria</label>

                    <main class="form-combobox">
                        <form method="post" action="/smartBuy/acao?param=selectProduto">

                            <select name="comboCategoria" class="form-select form-select-lg" aria-label=".form-select-sm example">

                                <option value="0">Selecione</option>

                                <%
                                    ArrayList<Categoria> categoria = new CategoriaDAO().consultarTodos();
                                    Categoria categ = new Categoria();

                                    for (int i = 0; i < categoria.size(); i++) {
                                %>           
                                <option value="<%= categoria.get(i).getId()%>"><%= categoria.get(i).getDescricao()%></option>

                                <%
                                    }
                                %>

                            </select>

                    </main>


                </div>

                <div class="half-box spacing">  <!-- criando um formulário para o nome -->
                    <label for="campoDeBuscaDataInicial">Data Inicial</label>
                    <input type="date" name="campoDeBuscaDataInicial" placeholder="Type what you want to search" autofocus>
                </div>

                <div class="half-box spacing">  <!-- criando um formulário para o nome -->
                    <label for="campoDeBuscaDataFinal">Data Final</label>
                    <input type="date" name="campoDeBuscaDataFinal" placeholder="Type what you want to search" autofocus>
                </div>

                <div class="half-box spacing">  <!-- criando um formulário para o nome -->
                    <input type="submit" value="Search">
                </div>

            </form>


            <%
                ArrayList<Produto> produto = (ArrayList) request.getAttribute("categoriasPesquisa");

                // testar se obj esta nulo.
                // quando viemos do Menu (direto), não há obj em categoriasPesquisa, logo, o cast será NULL
                if (produto != null) {

                    if (produto.size() == 0) {
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
                    <th>Quantidade</th>
                    <th>PrecoVenda</th>
                    <th>Estoque</th>
                    <th>Status</th>
                    <th>Categoria</th>
                    <!-- <th>Imagem</th> -->

                    <%
                        for (int i = 0; i < produto.size(); i++) {
                            Produto prod = produto.get(i);
                    %>
                    <tr>
                        <td><a href='/smartBuy/acao?param=edCompra&id=<%= prod.getId()%>'><img src="img/shopping-cart.png" title="Shopping cart" align="center" alt="icone-Carrinho" width=20px height=20px></a></td>             
                        <td><%= prod.getId()%></td>
                        <td><%= prod.getDescricao()%></td>
                        <td><%= prod.getQuantidade()%></td>
                        <td><%= prod.getPrecoVenda()%></td>
                        <td><%= prod.getEstoque()%></td>
                        <td><%= prod.getStatus()%></td>
                        <td><%= prod.getDesCategoria()%></td>


                    </tr>

                    <%
                        }
                    %>

                </table>
            </div>
            <%
                    }
                }
            %>
        </div>
    </body>
</html>
