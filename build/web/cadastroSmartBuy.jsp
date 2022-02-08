<%-- 
    Document   : cadastroSmartBuy
    Created on : 5 de abr. de 2021, 20:37:33
    Author     : tiago
--%>

<%@page import="entidade.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Smart Buy - Cadastro</title>
        <link rel="stylesheet" href="css/cadastroStyles.css">
    </head>
    <body>

        <div id="main-container">   <!-- criando um container para o formulario -->

            <p class="text-center"><img src="img/EscritaEcomerce2.png" align="center" alt="logo-ecommerce2" width=270px height=50px></p>


            <%
                Usuario user = (Usuario) request.getAttribute("salvaCadastro");

                if (user == null) {
                    user = new Usuario();

                    user.setId(0);
                    user.setEmail("");
                    user.setName("");
                    user.setLastname("");
                    user.setPassword("");
                }
            %>


            <h1>Register to access the system</h1>


            <form id="register-form" name='formCategoria' method='post' action='/smartBuy/acao?param=salvaCadastro'> <!-- criando o formulário -->
                <input type="hidden" name="id" value="<%= user.getId()%>">
                <div class="full-box"> <!-- criando um formulário para o email -->
                    <label for="email">E-mail</label>
                    <input type="email" name="email" id="email" placeholder="Enter your email" value="<%= user.getEmail() %>" data-min-length="3" date-required>   <!-- o nome do imput deve ser igual ao for da label -->
                </div>

                <div class="half-box spacing">  <!-- criando um formulário para o nome -->
                    <label for="name">Name</label>
                    <input type="text" name="name" id="name" placeholder="Enter your name" value="<%= user.getName() %>" data-max-length="16">   <!-- o nome do imput deve ser igual ao for da label -->
                </div>

                <div class="half-box">  <!-- criando um formulário para o sobrenome -->
                    <label for="lastname">Lastname</label>
                    <input type="text" name="lastname" id="lastname" placeholder="Enter your lastname" value="<%= user.getLastname() %>" data-max-length="50">   <!-- o nome do imput deve ser igual ao for da label -->
                </div>

                <div class="full-box">  <!-- criando um formulário para o password -->
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" placeholder="Enter your password" value="<%= user.getPassword() %>" data-max-length="50">   <!-- o nome do imput deve ser igual ao for da label -->
                </div>

                <!-- <div class="half-box">  <!-- criando um formulário para o password confirmation -->
                <!-- <label for="passwordconfirmation">Password</label>
                 <input type="password" name="passwordconfirmation" id="passwordconfirmation" placeholder="Confirm your password">   <!-- o nome do imput deve ser igual ao for da label -->
                <!-- </div> -->

                <!--<div class="full-box"> <!-- criando um formulário para checkbox -->
                <!--<input type="checkbox" name="agreement" id="agreement">   <!-- o nome do imput deve ser igual ao for da label -->
                <!--<label for="agreement" id="agreement-label">I have read and accept the <a href="#">terms of use.</a></label>
            </div> -->

                <div class="full-box"> <!-- criando um botão para enviar o formulário para o servidor -->
                    <input type="submit" id="btn-submit" value="Register">
                </div>

            </form>

        </div>
        <p class="error-validation template"></p>   <!-- serve para informar o erro abaixo dos dados cadastrais -->
        <script src="js/scripts.js"></script>
    </body>
</html>
