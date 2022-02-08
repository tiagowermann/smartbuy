<%-- 
    Document   : cadastroProdutoSmartBuy
    Created on : 8 de abr de 2021, 21:53:29
    Author     : tiago
--%>

<%@page import="apoio.Formatacao"%>
<%@page import="dao.CategoriaDAO"%>
<%@page import="entidade.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidade.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/categoriaSmartBuy.css">
        <title>Cadastro de Produto</title>
    </head>
    <body>
        <%@include file="menuSmartBuy.jsp" %>

        <div id="main-container" class="table-responsive">



            <%
                Produto produto = (Produto) request.getAttribute("objProduto");

                if (produto == null) {
                    produto = new Produto();

                    produto.setId(0);
                    produto.setDescricao("");
                    produto.setQuantidade(0);
                    produto.setPrecoVenda(0);
                    produto.setEstoque(0);
                    produto.setStatus(' ');
                    produto.setCategoria(0);
                    //produto.setImagem("");
                }
            %>

            <h1>Register Products</h1>

            <main class="main-container">

                <!-- ADICIONAR PRODUTO -->
                <form name='formCategoria' method='post' action='/smartBuy/acao?param=salvarProduto'>
                    <input type="hidden" name="id"  value="<%=produto.getId()%>">

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



                    <div class="half-box spacing">
                        <label for="estoque">Estoque</label>
                        <input type="number" name="estoque" value="<%=produto.getEstoque()%>" readonly="">
                    </div>


                    <div class="half-box spacing">
                        <label for="status">Status</label>
                        <input type="text" data-ls-module="charCounter" maxlength="1" name="status" placeholder="Enter the status" value="<%=produto.getStatus()%>">
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



                    <!--
    <div class="half-box spacing">
        <label for="categoria">Categoria</label>
        <input type="text" name="categoria" value="<%=produto.getCategoria()%>">
    </div>
                    -->

                    <br>
                    <!--  <br>
                      <br>
                      
                      Foto
                      <input name="myFile" type="file" value=""> -->

                    <div class="full-box">
                        <input type="submit" id="btn-submit" value='Save'>
                    </div>


                </form>
            </main>
        </div>
    </body>
</html>
