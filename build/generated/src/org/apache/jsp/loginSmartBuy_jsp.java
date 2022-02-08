package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entidade.Usuario;

public final class loginSmartBuy_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewrport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Smart Buy - Login</title>\n");
      out.write("\n");
      out.write("        <!-- link para buscar os icones -->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\"> \n");
      out.write("        <!-- link para os estilos da página -->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/loginStyles.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div id=\"login-container\"> <!-- cria um container com usuário, senha, midia social e um link para caso o usuário esqueça a senha -->\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");

                Usuario user = (Usuario) request.getAttribute("consultaUsuario");

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
      out.write("            <img src=\"img/EscritaEcomerce2.png\" align=\"center\" alt=\"logo-ecommerce\" width=270px height=50px>    \n");
      out.write("            <h1>Login</h1>\n");
      out.write("\n");
      out.write("            <main class=\"form-signin\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                <form method=\"post\" action=\"/smartBuy/acao?param=consultaUsuario\"> <!-- cria um formulário com os inputs para o usuário colocar o email e senha -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <input type=\"hidden\" name=\"id\" value=\"");
      out.print( user.getId());
      out.write("\">\n");
      out.write("                    <label for=\"email\">E-mail</label>\n");
      out.write("                    <input type=\"email\" name=\"email\" id=\"email\" placeholder=\"Enter your e-mail\" autocomplete=\"on\" value=\"");
      out.print( user.getEmail());
      out.write("\" required autofocus>\n");
      out.write("                    <label for=\"password\">Password</label>\n");
      out.write("                    <input type=\"password\" name=\"password\" id=\"password\" placeholder=\"Enter your password\" value=\"");
      out.print( user.getPassword());
      out.write("\"  required autofocus>\n");
      out.write("                    <!-- link para caso o usuário esqueça a senha -->\n");
      out.write("                    <!--<a href=\"#\" id=\"forgot-password\">Forgot your password or email?</a> -->\n");
      out.write("                    <!-- o input serve para levar as informações do formulário/usuário para o servidor -->\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");

                        String msg = String.valueOf(request.getAttribute("msgLogin"));

                        if (msg.equals("erro")) {
                    
      out.write("\n");
      out.write("                    <p id=\"msgErroLogin\">Incorrect username or password!</p>\n");
      out.write("                    ");

                    } else {
                    
      out.write("\n");
      out.write("                    <p id=\"msgErroLogin\"></p>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <input type=\"submit\" value=\"Login\">\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("                <!-- cria o container social -->\n");
      out.write("                <!-- <div id=\"social-container\">\n");
      out.write("                    <p>Or sign in via your social networks</p>\n");
      out.write("                    <i class=\"fa fa-facebook-f\"></i> <!-- cria o ícone do facebook -->\n");
      out.write("                <!--<i class=\"fa fa-linkedin\"></i> <!-- cria o ícone do linkedin -->\n");
      out.write("                <!--</div> -->\n");
      out.write("\n");
      out.write("                <!-- cria o container para se registrar -->\n");
      out.write("                <div id=\"register-container\">\n");
      out.write("                    <p>Not have an account yet?</p>\n");
      out.write("                    <a href=\"cadastroSmartBuy.jsp\">Register</a>\n");
      out.write("                </div>\n");
      out.write("            </main>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
