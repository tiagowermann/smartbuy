package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import apoio.Formatacao;
import java.util.Date;

public final class exemploinicial_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("        ");

            String dataAtual = String.valueOf(new Date());
            int x = 10;
            System.out.println("X = " + x);
        
      out.write("\n");
      out.write("        <p>Data atual</p>\n");
      out.write("        <h2> \n");
      out.write("            ");
      out.print( dataAtual + " e o nº: " + x);
      out.write("\n");
      out.write("            <br>\n");
      out.write("            ");
      out.print( Formatacao.getDataHoraAtual());
      out.write("\n");
      out.write("        </h2>\n");
      out.write("\n");
      out.write("        <p>Data atual - 2</p>\n");
      out.write("        <h2> ");
      out.print( Formatacao.getDataHoraAtual());
      out.write(" </h2>\n");
      out.write("\n");
      out.write("        <p> O valor da nota é: ");
      out.print( x);
      out.write("</p>\n");
      out.write("\n");
      out.write("        <hr>\n");
      out.write("        <form name=\"cadastroX\" id=\"cadastroX\" method=\"post\" action=\"/WebApp2021A/acao?param=salvarPessoa\">\n");
      out.write("            <label>Nome </label>\n");
      out.write("            <input type=\"text\" name=\"nomePessoa\" value=\"\" required>\n");
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Enviar\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <table border='1'>\n");
      out.write("            <tr>\n");
      out.write("                <td>id</td>\n");
      out.write("                <td>nome</td>\n");
      out.write("                <td>endereço</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><a href='/WebApp2021A/acao?param=edPessoa&id=1'>1</a></td>\n");
      out.write("                <td>Juca Bala</td>\n");
      out.write("                <td>Rua da Loucura, 666</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td><a href='/WebApp2021A/acao?param=edPessoa&id=2'>2</a></td>\n");
      out.write("                <td>Juliana da Silva</td>\n");
      out.write("                <td>Rua da Ju, 1000</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("\n");
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
