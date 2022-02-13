package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import apoio.Formatacao;
import dao.CategoriaDAO;
import entidade.Categoria;
import java.util.ArrayList;
import entidade.Produto;
import entidade.Usuario;

public final class produtoSmartBuy_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/menuSmartBuy.jsp");
  }

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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/categoriaSmartBuy.css\">\n");
      out.write("        <title>Cadastro de Produto</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Smart Buy</title>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            /*.bd-placeholder-img {\n");
      out.write("                font-size: 1.125rem;\n");
      out.write("                text-anchor: middle;\n");
      out.write("                -webkit-user-select: none;\n");
      out.write("                -moz-user-select: none;\n");
      out.write("                user-select: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            @media (min-width: 768px) {\n");
      out.write("                .bd-placeholder-img-lg {\n");
      out.write("                    font-size: 3.5rem;\n");
      out.write("                }\n");
      out.write("            }*/\n");
      out.write("\n");
      out.write("            .container-fluid {\n");
      out.write("                background: -webkit-gradient(linear, left top, right top, from(#0003aa), to(#000000)) no-repeat;\n");
      out.write("                background: -moz-linear-gradient(left, #0003aa, #000000);\n");
      out.write("                filter:progid:DXImageTransform.Microsoft.Gradient(GradientType=1, StartColorStr='#0003aa', EndColorStr='#000000');\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <link href=\"css/navbar.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <link href=\"css/menuStyles.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-expand-md navbar-dark bg-dark\" aria-label=\"Fourth navbar example\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"paginainicial.jsp\"><img src=\"img/EscritaEcomerce3.png\" align=\"center\" alt=\"logo-ecommerce\" width=270px height=50px></a>\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarsExample04\" aria-controls=\"navbarsExample04\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                </button>\n");
      out.write("\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbarsExample04\">\n");
      out.write("                    <ul class=\"navbar-nav me-auto mb-2 mb-md-0\">\n");
      out.write("\n");
      out.write("                        <!-- navegaçao INÍCIO -->\n");
      out.write("                        <!-- <li class=\"nav-item\">\n");
      out.write("                           <a class=\"nav-link active\" aria-current=\"page\" href=\"#\">Início</a> \n");
      out.write("                        </li>-->\n");
      out.write("\n");
      out.write("                        <!-- navegação MENU -->\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <!--a class=\"nav-link\" href=\"#\">Menu</a-->\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <!--a class=\"nav-link disabled\" href=\"#\" tabindex=\"-1\" aria-disabled=\"true\">Desabilitado</a-->\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        <!--\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link active\" aria-current=\"page\" href=\"paginainicial.jsp\">Home</a> \n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link active\" aria-current=\"page\" href=\"produtoSmartBuy.jsp\">Register Products</a> \n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link active\" aria-current=\"page\" href=\"listaproduto.jsp\">Product List</a> \n");
      out.write("                        </li>                        \n");
      out.write("\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link active\" aria-current=\"page\" href=\"selectProduto.jsp\">Select</a> \n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link active\" aria-current=\"page\" href=\"pesquisaProdutos.jsp\">Search</a> \n");
      out.write("                        </li>  -->\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item dropdown\">\n");
      out.write("                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"dropdown03\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">Produts</a>\n");
      out.write("                            <ul class=\"dropdown-menu\" aria-labelledby=\"dropdown03\">\n");
      out.write("                                <li><a class=\"dropdown-item\" href=\"produtoSmartBuy.jsp\">Product registration</a></li>\n");
      out.write("                                <li><a class=\"dropdown-item\" href=\"listaproduto.jsp\">Product list</a></li>\n");
      out.write("                                <li><a class=\"dropdown-item\" href=\"pesquisaProdutos.jsp\">Product search</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item dropdown\">\n");
      out.write("                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"dropdown03\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">Category</a>\n");
      out.write("                            <ul class=\"dropdown-menu\" aria-labelledby=\"dropdown03\">\n");
      out.write("                                <li><a class=\"dropdown-item\" href=\"categoriaSmartBuy.jsp\">Category registration</a></li>\n");
      out.write("                                <li><a class=\"dropdown-item\" href=\"listacategoria.jsp\">Category List</a></li>\n");
      out.write("                                <li><a class=\"dropdown-item\" href=\"pesquisaCategorias.jsp\">Category Search</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item dropdown\">\n");
      out.write("                            <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"dropdown04\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">Relatórios</a>\n");
      out.write("                            <ul class=\"dropdown-menu\" aria-labelledby=\"dropdown04\">\n");
      out.write("                                <li><a class=\"dropdown-item\" href=\"relatorioProdutosCadastrado.jsp\" target=\"_blank\">Registered products</a></li>\n");
      out.write("                                <li><a class=\"dropdown-item\" href=\"relatorioCategoriasCadastradas.jsp\" target=\"_blank\">Registered categories</a></li>\n");
      out.write("                                <li><a class=\"dropdown-item\" href=\"relatorioComprasCarrinho.jsp\" target=\"_blank\">Shopping list</a></li>\n");
      out.write("                                <li><a class=\"dropdown-item\" href=\"relatorioUsuariosCadastrados.jsp\" target=\"_blank\">Registered users</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link active\" aria-current=\"page\" href=\"pesquisaProdutoInicial.jsp\">Search</a> \n");
      out.write("                        </li>\n");
      out.write("                        \n");
      out.write("                    </ul>\n");
      out.write("                    <!--\n");
      out.write("                    <form method=\"post\" action=\"/smartBuy/chupitz?param=pesquisa\">\n");
      out.write("                        <div class=\"input-group\">\n");
      out.write("                            <input class=\"form-control\" type=\"text\" placeholder=\"Search here...\" aria-label=\"Search\">\n");
      out.write("                            <span class=\"input-group-btn\">\n");
      out.write("                    <!--<button class=\"btn btn-default\" href=\"/smartBuy/chupitz?param=pesquisa\" type=\"button\">Search</button> \n");
      out.write("                    <!--<input type=\"submit\" value=\"Search\"> \n");
      out.write("                </span>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("                    -->\n");
      out.write("                    <ul>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"navbar-brand\" href=\"CarrinhoCompra.jsp\"><img src=\"img/shopping-cart.png\" title=\"Carrinho de Compras\" align=\"center\" alt=\"icone-carrinho\" width=30px height=30px></a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                    <ul>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"/smartBuy/acao?param=logout\" ><img src=\"img/login-rounded-right.png\" title=\"Logout of your accont\" align=\"center\" alt=\"icone-carrinho\" width=30px height=30px></a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <script src=\"js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"main-container\" class=\"table-responsive\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");

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
            
      out.write("\n");
      out.write("\n");
      out.write("            <h1>Register Products</h1>\n");
      out.write("\n");
      out.write("            <main class=\"main-container\">\n");
      out.write("\n");
      out.write("                <!-- ADICIONAR PRODUTO -->\n");
      out.write("                <form name='formCategoria' method='post' action='/smartBuy/acao?param=salvarProduto'>\n");
      out.write("                    <input type=\"hidden\" name=\"id\"  value=\"");
      out.print(produto.getId());
      out.write("\">\n");
      out.write("\n");
      out.write("                    <div class=\"full-box\">\n");
      out.write("                        <label for=\"descricao\">Description</label>\n");
      out.write("                        <input type=\"text\" name=\"descricao\" placeholder=\"Enter description\" autocomplete=\"on\" value=\"");
      out.print(produto.getDescricao());
      out.write("\">\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"half-box spacing\">\n");
      out.write("                        <label for=\"quantidade\">Quantity</label>\n");
      out.write("                        <input type=\"number\" name=\"quantidade\" placeholder=\"Enter the quantity\" value=\"");
      out.print(produto.getQuantidade());
      out.write("\">\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"half-box spacing\">\n");
      out.write("                        <label for=\"precoVenda\">Sale price</label>\n");
      out.write("                        <input type=\"text\" name=\"precoVenda\" readonly=\"on\" value=\"");
      out.print(produto.getPrecoVenda());
      out.write("\" >\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"half-box spacing\">\n");
      out.write("                        <label for=\"estoque\">Stock</label>\n");
      out.write("                        <input type=\"number\" name=\"estoque\" value=\"");
      out.print(produto.getEstoque());
      out.write("\" readonly=\"\">\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"half-box spacing\">\n");
      out.write("                        <label for=\"status\">Status</label>\n");
      out.write("                        <input type=\"text\" data-ls-module=\"charCounter\" maxlength=\"1\" name=\"status\" placeholder=\"Enter the status\" value=\"");
      out.print(produto.getStatus());
      out.write("\">\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"half-box spacing\">\n");
      out.write("                        <label for=\"categoria\">Category</label>\n");
      out.write("\n");
      out.write("                        <main class=\"form-combobox\">\n");
      out.write("                            <form method=\"post\" action=\"/smartBuy/acao?param=selectProduto\">\n");
      out.write("\n");
      out.write("                                <select name=\"comboCategoria\" class=\"form-select form-select-lg\" aria-label=\".form-select-sm example\">\n");
      out.write("\n");
      out.write("                                    <option value=\"0\">Selecione</option>\n");
      out.write("\n");
      out.write("                                    ");

                                        ArrayList<Categoria> categoria = new CategoriaDAO().consultarTodos();
                                        Categoria categ = new Categoria();

                                        for (int i = 0; i < categoria.size(); i++) {
                                    
      out.write("           \n");
      out.write("                                    <option value=\"");
      out.print( categoria.get(i).getId());
      out.write('"');
      out.write('>');
      out.print( categoria.get(i).getDescricao());
      out.write("</option>\n");
      out.write("\n");
      out.write("                                    ");

                                        }
                                    
      out.write("\n");
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </form>\n");
      out.write("                        </main>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <!--\n");
      out.write("    <div class=\"half-box spacing\">\n");
      out.write("        <label for=\"categoria\">Categoria</label>\n");
      out.write("        <input type=\"text\" name=\"categoria\" value=\"");
      out.print(produto.getCategoria());
      out.write("\">\n");
      out.write("    </div>\n");
      out.write("                    -->\n");
      out.write("\n");
      out.write("<!--                    <br>-->\n");
      out.write("                    <!--  <br>\n");
      out.write("                      <br>\n");
      out.write("                      \n");
      out.write("                      Foto\n");
      out.write("                      <input name=\"myFile\" type=\"file\" value=\"\"> -->\n");
      out.write("\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    <div class=\"full-box\">\n");
      out.write("                        <label for=\"Image\">Product image</label>\n");
      out.write("                        <img src=\"file\" alt=\"Image\" height=\"42\" width=\"42\"/>\n");
      out.write("                        <input type=\"file\" accept=\"image/jpg, image/png\" />\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    <div class=\"full-box\">\n");
      out.write("                        <input type=\"submit\" id=\"btn-submit\" value='Save'>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("            </main>\n");
      out.write("        </div>\n");
      out.write("    \n");
      out.write("    \n");
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
