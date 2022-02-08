<%-- 
    Document   : categoria
    Created on : Mar 15, 2021, 9:32:26 PM
    Author     : pretto
--%>

<%@page import="entidade.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/categoriaSmartBuy.css">
        <title>Cadastro de Categoria</title>
    </head>
    <body>
        <%@include file="menuSmartBuy.jsp" %>

        <div id="main-container" class="table-responsive">

            <%
                Categoria categoria = (Categoria) request.getAttribute("objProduto");

                if (categoria == null) {
                    categoria = new Categoria();

                    categoria.setId(0);
                    categoria.setDescricao("");
                    categoria.setStatus(' ');
                    categoria.setData("");
                }
            %>

            <h1>Register Category</h1>


            <main class="main-container">
                <!-- ADICIONAR CATEGORIA -->
                <form name='formCategoria' method='post' action='/smartBuy/acao?param=salvarCategoria'>
                    <!--ID-->
                    <input type="hidden" name="id" value="<%=categoria.getId()%>">


                    <input type="hidden" name="data" value="<%=categoria.getData()%>">



                    <div class="full-box">
                        <label for="descricao">Descrição</label>
                        <input type="text" name="descricao" placeholder="Enter description" autocomplete="on" value="<%=categoria.getDescricao()%>">
                    </div>


                    <div class="full-box">
                        <label for="status">Status</label>
                        <input type="text" name="status" placeholder="Enter the status" value="<%=categoria.getStatus()%>">
                    </div>



                    
                    <input type='submit' id="btn-submit" value='Save'>


                </form>



                <!-- <h4>Listagem de Produtos</h4>
                <%--@include file="listaproduto.jsp" --%>
        
                <ul>
                    <li><a href='menuSmartBuy.jsp'>Menu</a></li>
                    <li>Pessoas</li>
                    <li>Item</li>
                </ul> -->
            </main>
        </div>
    </body>
</html>
