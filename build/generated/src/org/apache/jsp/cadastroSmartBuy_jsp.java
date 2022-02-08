package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entidade.Usuario;

public final class cadastroSmartBuy_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Smart Buy - Cadastro</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/cadastroStyles.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div id=\"main-container\">   <!-- criando um container para o formulario -->\n");
      out.write("\n");
      out.write("            <p class=\"text-center\"><img src=\"img/EscritaEcomerce2.png\" align=\"center\" alt=\"logo-ecommerce2\" width=270px height=50px></p>\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");

                Usuario user = (Usuario) request.getAttribute("salvaCadastro");

                if (user == null) {
                    user = new Usuario();

                    user.setId(0);
                    user.setEmail("");
                    user.setName("");
                    user.setLastname("");
                    user.setPassword("");
                }
            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <h1>Register to access the system</h1>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <form id=\"register-form\" name='formCategoria' method='post' action='/smartBuy/acao?param=salvaCadastro'> <!-- criando o formulário -->\n");
      out.write("                <input type=\"hidden\" name=\"id\" value=\"");
      out.print( user.getId());
      out.write("\">\n");
      out.write("                <div class=\"full-box\"> <!-- criando um formulário para o email -->\n");
      out.write("                    <label for=\"email\">E-mail</label>\n");
      out.write("                    <input type=\"email\" name=\"email\" id=\"email\" placeholder=\"Enter your email\" value=\"");
      out.print( user.getEmail() );
      out.write("\" data-min-length=\"3\" date-required>   <!-- o nome do imput deve ser igual ao for da label -->\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"half-box spacing\">  <!-- criando um formulário para o nome -->\n");
      out.write("                    <label for=\"name\">Name</label>\n");
      out.write("                    <input type=\"text\" name=\"name\" id=\"name\" placeholder=\"Enter your name\" value=\"");
      out.print( user.getName() );
      out.write("\" data-max-length=\"16\">   <!-- o nome do imput deve ser igual ao for da label -->\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"half-box\">  <!-- criando um formulário para o sobrenome -->\n");
      out.write("                    <label for=\"lastname\">Lastname</label>\n");
      out.write("                    <input type=\"text\" name=\"lastname\" id=\"lastname\" placeholder=\"Enter your lastname\" value=\"");
      out.print( user.getLastname() );
      out.write("\" data-max-length=\"50\">   <!-- o nome do imput deve ser igual ao for da label -->\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"full-box\">  <!-- criando um formulário para o password -->\n");
      out.write("                    <label for=\"password\">Password</label>\n");
      out.write("                    <input type=\"password\" name=\"password\" id=\"password\" placeholder=\"Enter your password\" value=\"");
      out.print( user.getPassword() );
      out.write("\" data-max-length=\"50\">   <!-- o nome do imput deve ser igual ao for da label -->\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!-- <div class=\"half-box\">  <!-- criando um formulário para o password confirmation -->\n");
      out.write("                <!-- <label for=\"passwordconfirmation\">Password</label>\n");
      out.write("                 <input type=\"password\" name=\"passwordconfirmation\" id=\"passwordconfirmation\" placeholder=\"Confirm your password\">   <!-- o nome do imput deve ser igual ao for da label -->\n");
      out.write("                <!-- </div> -->\n");
      out.write("\n");
      out.write("                <!--<div class=\"full-box\"> <!-- criando um formulário para checkbox -->\n");
      out.write("                <!--<input type=\"checkbox\" name=\"agreement\" id=\"agreement\">   <!-- o nome do imput deve ser igual ao for da label -->\n");
      out.write("                <!--<label for=\"agreement\" id=\"agreement-label\">I have read and accept the <a href=\"#\">terms of use.</a></label>\n");
      out.write("            </div> -->\n");
      out.write("\n");
      out.write("                <div class=\"full-box\"> <!-- criando um botão para enviar o formulário para o servidor -->\n");
      out.write("                    <input type=\"submit\" id=\"btn-submit\" value=\"Register\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <p class=\"error-validation template\"></p>   <!-- serve para informar o erro abaixo dos dados cadastrais -->\n");
      out.write("        <script src=\"js/scripts.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
