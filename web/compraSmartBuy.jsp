<%-- 
    Document   : cadastroProdutoSmartBuy
    Created on : 8 de abr de 2021, 21:53:29
    Author     : tiago
--%>

<%@page import="apoio.Formatacao"%>
<%@page import="entidade.CompraProduto"%>
<%@page import="dao.CategoriaDAO"%>
<%@page import="entidade.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidade.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/cadastroStyles.css">
    </head>
    <body>
        <%@include file="menuSmartBuy.jsp" %>

        <div id="main-container">   <!-- criando um container para o formulario -->

            <title>Add product to cart</title>

            <%
                Produto produto = (Produto) request.getAttribute("objProduto");

                if (produto == null) {
                    produto = new Produto();

                    produto.setId(0);
                    produto.setDescricao("");
                    produto.setQuantidade(0);
                    produto.setPrecoVenda(0);
                    //produto.setEstoque(0);
                    //produto.setStatus(' ');
                    //produto.setCategoria(0);
                    //produto.setImagem("");
                }

            %>

            <h1>Add product to cart</h1>

            <!-- ADICIONAR PRODUTO -->
            <form name='formCategoria' method='post' action='/smartBuy/acao?param=compraProduto'>
                <input type="hidden" name="id" value="<%=produto.getId()%>">

                <div class="full-box">
                    <label for="descricao">Descrição</label>
                    <input type="text" name="descricao" placeholder="Enter description" autocomplete="on" value="<%=produto.getDescricao()%>">
                </div>

                <div class="half-box spacing">
                    <label for="quantidade">Quantidade</label>
                    <input type="number" name="quantidade" placeholder="Enter the quantity" value="<%=produto.getQuantidade()%>">
                </div>

                <div class="half-box spacing">
                    <label for="precoVenda">Preço de Venda</label>
                    <input type="text" name="precoVenda" readonly="on" value="<%=produto.getPrecoVenda()%>" >
                </div>

                <h5>Click Add to add item to cart</h5>

                


                <!--  <br>
                  <br>
                  
                  Foto
                  <input name="myFile" type="file" value=""> -->

                <table>
                    <tr>
                        <td>
                            <div>
                                <input type='submit' value='Add'>
                            </div>
                        </td>
                        <td>
                            <div>
                                <!--<input type='submit' value='Cancel'> -->
                            </div>
                        </td>
                    </tr>
                </table>
            </form>
        </div>



        <!-- <h4>List Products</h4> -->
        <%--@include file="listaproduto.jsp" --%>

        <!--
        <ul>
        <!-- <li><a href='menuSmartBuy.jsp'>Menu</a></li>
        <th>Ação</th>
        <th>Id</th>
        <th>Descrição</th>
        <th>Quantidade</th>
        <th>PrecoVenda</th>
        <th>Estoque</th>
        <th>Status</th>
    </ul> 
        -->

    </body>
</html>
