<%-- 
    Document   : categoria
    Created on : Mar 15, 2021, 9:16:04 PM
    Author     : pretto
--%>

<%@page import="dao.ComprasRealizadasDAO"%>
<%@page import="apoio.Formatacao"%>
<%@page import="dao.CompraProdutoDAO"%>
<%@page import="entidade.CompraProduto"%>
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
            <h1>Shopping list</h1>

            <%
                ArrayList<CompraProduto> produto = new CompraProdutoDAO().consultarTodasCompras();
            %>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <th>Ação</th>
                    <th>Id</th>
                    <th>Descrição</th>
                    <th>Quantidade</th>
                    <th>Preco Venda</th>
                    <th>Sub Total</th>
                    <!--<th>Estoque</th>
                    <th>Status</th>
                    <th>Categoria</th>
                     <th>Imagem</th> -->

                    <%
                        for (int i = 0; i < produto.size(); i++) {
                            CompraProduto prod = produto.get(i);
                            double total = prod.getSubtotal();
                            prod.setTotal(total);
                            System.out.println("Total do primeiro for: "+total);
                            
                    %>
                    <tr>
                        <td><a href='/smartBuy/acao?param=exCompra&id=<%= prod.getId()%>'  onclick="return confirm('Are you sure you want to delete this item?');" ><img src="img/delete.png" title="Delet" align="center" alt="icone-excluir" width=20px height=20px></a></td>
                        <td><%= prod.getId()%></td>
                        <td><%= prod.getDescricao()%></td>
                        <td><%= prod.getQuantidade()%></td>
                        <td><%= prod.getPrecoVenda()%></td>
                        <td><%= prod.getSubtotal()%></td>
                        <%
                            System.out.println("O Valor do SubTotal é: " + prod.getSubtotal());
                            System.out.println("O valor total é: " + total);
                            prod.getTotal();
                            
                        %>

                    </tr>


                    <%
                        }
                    %>

                </table>


                <br>
                <br>



                <h5>Total: 

                    <%
                        
                        double total = 0;
                        double soma = 0;
                        CompraProduto compProd = new CompraProduto();
                        for (int i = 0; i < produto.size(); i++) {
                            System.out.println("Estou dentro do for");
                            CompraProduto prod = produto.get(i);
                            soma += prod.getTotal();
                            total = soma;
                            prod.setTotal(total);
                            System.out.println("Valor do Total dentro do for: "+total);
                            /*prod.getId();
                            prod.getDescricao();
                            prod.getQuantidade();
                            prod.getPrecoVenda();
                            prod.getSubtotal();
                            prod.getTotal();*/
                            //new ComprasRealizadasDAO().salvarTotal(prod);
                        }/*
                        System.out.println("Estou fora do for");*/
                        total = soma;
                        /*compProd.setTotal(total);
                        compProd.getId();
                        compProd.getDescricao();
                        compProd.getQuantidade();
                        compProd.getPrecoVenda();
                        compProd.getSubtotal();
                        compProd.getTotal();
                        new ComprasRealizadasDAO().salvarTotal(compProd); */
                        //compProd.setTotal(total);
                        System.out.println("Total 1: " + total);
                    %>
                    <%= Formatacao.formatarDecimal(total)%>
                </h5>


            </div>
        </div>
        <br>
        <br>
        <!--<a href='index.jsp'>Voltar</a>-->



    </body>
</html>
