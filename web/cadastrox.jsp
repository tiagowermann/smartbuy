<%-- 
    Document   : cadastrox
    Created on : Mar 8, 2021, 10:24:57 PM
    Author     : pretto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Smart Buy - Cadastro</title>
    <link rel="stylesheet" href="../tela-cadastro/css/style.css">
</head>
<body>
    
    <div id="main-container">   <!-- criando um container para o formulario -->
        
        <p class="text-center"><img src="../tela-cadastro/img/EscritaEcomerce.png" align="center" alt="logo-ecommerce2" width=270px height=50px></p>
        <h1>Register to access the system</h1>
        
        <form id="register-form"> <!-- criando o formulário -->
            
            <div class="full-box"> <!-- criando um formulário para o email -->
                <label for="email">E-mail</label>
                <input type="email" name="email" id="email" placeholder="Enter your email" data-min-length="3" date-required>   <!-- o nome do imput deve ser igual ao for da label -->
            </div>

            <div class="half-box spacing">  <!-- criando um formulário para o nome -->
                <label for="name">Name</label>
                <input type="text" name="name" id="name" placeholder="Enter your name" data-max-length="16 ">   <!-- o nome do imput deve ser igual ao for da label -->
            </div>

            <div class="half-box">  <!-- criando um formulário para o sobrenome -->
                <label for="lastname">Lastname</label>
                <input type="text" name="lastname" id="lastname" placeholder="Enter your lastname">   <!-- o nome do imput deve ser igual ao for da label -->
            </div>

            <div class="half-box spacing">  <!-- criando um formulário para o password -->
                <label for="password">Password</label>
                <input type="password" name="password" id="password" placeholder="Enter your password">   <!-- o nome do imput deve ser igual ao for da label -->
            </div>

            <div class="half-box">  <!-- criando um formulário para o password confirmation -->
                <label for="passwordconfirmation">Password</label>
                <input type="password" name="passwordconfirmation" id="passwordconfirmation" placeholder="Confirm your password">   <!-- o nome do imput deve ser igual ao for da label -->
            </div>

            <div class="full-box"> <!-- criando um formulário para checkbox -->
                <input type="checkbox" name="agreement" id="agreement">   <!-- o nome do imput deve ser igual ao for da label -->
                <label for="agreement" id="agreement-label">I have read and accept the <a href="#">terms of use.</a></label>
            </div>

            <div class="full-box"> <!-- criando um botão para enviar o formulário para o servidor -->
                <input type="submit" id="btn-submit" value="Register">
            </div>

        </form>

    </div>
    <p class="error-validation template"></p>   <!-- serve para informar o erro abaixo dos dados cadastrais -->
    <script src="js/scripts.js"></script>
</body>
</html>
