/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.CadastroUsuarioDAO;
import dao.CategoriaDAO;
import dao.CompraProdutoDAO;
import dao.ComprasRealizadasDAO;
import dao.ProdutoDAO;
import dao.UsuarioDAO;
import entidade.CadastroUsuario;
import entidade.Categoria;
import entidade.CompraProduto;
import entidade.ComprasRealizadas;
import entidade.Produto;
import entidade.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class acaoSmartBuy extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Esse é o título do Servlet ACAO</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>SERVLET do meu coração ACAO " + request.getContextPath() + "</h1>");
            out.println("<h6>Data:" + new Date() + "</h6>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //  processRequest(request, response);
        System.out.println("ESTOU no GET");

        String parametro = request.getParameter("nome");
//        System.out.println("Nome que veio no parâmetro: " + parametro);
//
//        String parametro2 = request.getParameter("id");
//        System.out.println("ID: " + parametro2);
        String param = request.getParameter("param");

        // ================= PESSOA =========================================
        if (param.equals("edPessoa")) {
            String id = request.getParameter("id");
            System.out.println("ID para edição: " + id);
        } else if (param.equals("exPessoa")) {

        }

        // ================= EDITAR PRODUTO ====================================
        if (param.equals("edProduto")) {
            String id = request.getParameter("id");

            Produto prd = (Produto) new ProdutoDAO().consultarIdProduto(Integer.parseInt(id));

            if (prd != null) {

                request.setAttribute("objProduto", prd);

                encaminharPagina("produtoSmartBuy.jsp", request, response);
            } else {
                encaminharPagina("erro.jsp", request, response);
            }

        }

        // ================= EXCLUIR PRODUTO ====================================
        if (param.equals("exProduto")) {
            String id = request.getParameter("id");

            Produto prd = (Produto) new ProdutoDAO().excluirProduto(Integer.parseInt(id));

            if (prd == null) {

                request.setAttribute("objProduto", prd);

                encaminharPagina("listaproduto.jsp", request, response);
            } else {
                encaminharPagina("erro.jsp", request, response);
            }

        }

        // ================= EDITAR CATEGORIA ====================================
        if (param.equals("edCategoria")) {
            String id = request.getParameter("id");

            Categoria categ = (Categoria) new CategoriaDAO().consultarIdCategoria(Integer.parseInt(id));

            if (categ != null) {

                request.setAttribute("objProduto", categ);

                encaminharPagina("categoriaSmartBuy.jsp", request, response);
            } else {
                encaminharPagina("erro.jsp", request, response);
            }

        }

        // ================= EXCLUIR CATEGORIA ====================================
        if (param.equals("exCategoria")) {
            String id = request.getParameter("id");

            Categoria categ = (Categoria) new CategoriaDAO().excluirCategoria(Integer.parseInt(id));

            if (categ == null) {

                request.setAttribute("objProduto", categ);

                encaminharPagina("listacategoria.jsp", request, response);
            } else {
                encaminharPagina("erro.jsp", request, response);
            }

        }

        // ================= COMPRAR PRODUTO ====================================
        if (param.equals("edCompra")) {
            String id = request.getParameter("id");

            Produto prd = (Produto) new ProdutoDAO().consultarIdProduto(Integer.parseInt(id));

            if (prd != null) {

                request.setAttribute("objProduto", prd);

                encaminharPagina("compraSmartBuy.jsp", request, response);
            } else {
                encaminharPagina("erro.jsp", request, response);
            }

        }

        // ================= EXCLUIR COMPRA ====================================
        if (param.equals("exCompra")) {
            String id = request.getParameter("id");

            CompraProduto prd = (CompraProduto) new CompraProdutoDAO().excluirProduto(Integer.parseInt(id));

            if (prd == null) {

                request.setAttribute("objProduto", prd);

                encaminharPagina("listaCompra.jsp", request, response);
            } else {
                encaminharPagina("erro.jsp", request, response);
            }

        }

        // =================== LOGOUT ======================================
        if (param.equals("logout")) {
            System.out.println("LOGOUTTTTTT");
            HttpSession sessao = request.getSession();
            sessao.invalidate();
            response.sendRedirect("loginSmartBuy.jsp");
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        System.out.println("ESTOU no POST");

        String param = request.getParameter("param");

        // ================= PESSOA =========================================
        if (param.equals("salvarPessoa")) {
            String nome = request.getParameter("nomePessoa");
            System.out.println("Nome pessoa: " + nome);

            // inacabado
        }

        // ================= SALVAR CADASTRO USUÁRIO ===========================OK
        if (param.equals("salvaCadastro")) {
            // capturar dados que vieram do REQUEST
            int id = Integer.parseInt(request.getParameter("id"));
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String lastname = request.getParameter("lastname");
            String password = request.getParameter("password");

            // validacoes dos campos - não farei
            // criar OBJ do tipo que será salvo
            Usuario u = new Usuario();
            u.setId(id);
            u.setEmail(email);
            u.setName(name);
            u.setLastname(lastname);
            u.setPassword(password);

            // chamar o salvar e aguardar o retorno
            String retorno = null;
            if (id == 0) {
                retorno = new UsuarioDAO().salvar(u);
            } else {
                retorno = new UsuarioDAO().atualizar(u);
            }

            if (retorno == null) {
                // deu certo
                request.setAttribute("tipoLogin", "Login");
                request.setAttribute("paginaRetorno", "loginSmartBuy.jsp");

                encaminharPagina("sucesso.jsp", request, response);
            } else {
                // deu errado
                request.setAttribute("paginaRetorno", "cadastroSmartBuy.jsp");
                encaminharPagina("erro.jsp", request, response);
            }

        }

        if (param.equals("login")) {
            // ignorando autenticacao = demo

            // redirecionando para menu.jsp
            encaminharPagina("menuSmartBuy.jsp", request, response);
        }

        // ================= CONSULTA USUARIO ==================================OK
        if (param.equals("consultaUsuario")) {
            // capturar dados que vieram do REQUEST
            int id = Integer.parseInt(request.getParameter("id"));
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String lastname = request.getParameter("lastname");
            String password = request.getParameter("password");

            //String email = request.getParameter("email");
            Usuario login = new UsuarioDAO().consultarUsuario(email, password);

            //request.setAttribute("consultaLogin", login);
            //encaminharPagina("sucesso.jsp", request, response);
            if (login != null) {
                System.out.println("PASSEI A VALIDAÇÃO DO LOGIN");

                if (email.equals(login.getEmail())) {
                    System.out.println("CONFERI SE O EMAIL É IGUAL AO INSERIDO");

                    System.out.println("este é o email: " + login.getEmail());

                    // após validar credenciais, adiciona user na Sessão
                    HttpSession sessao = ((HttpServletRequest) request).getSession();

                    sessao.setAttribute("usuarioLogado", login.getName());
                    System.out.println(login.getName());

                    // deu certo
                    request.setAttribute("tipoLogin", "Login");
                    request.setAttribute("paginaRetorno", "paginainicial.jsp");
                    encaminharPagina("paginainicial.jsp", request, response);

                    // redirecionando para menuSmartBuy.jsp
                    encaminharPagina("menuSmartBuy.jsp", request, response);
                } else {
                    request.setAttribute("msgLogin", "erro");
                    encaminharPagina("loginSmartBuy.jsp", request, response);
                }

            } else {
                // deu errado
                //encaminharPagina("erro.jsp", request, response);

                request.setAttribute("msgLogin", "erro");
                encaminharPagina("loginSmartBuy.jsp", request, response);
            }
        }

        // ================= SALVA PRODUTO =====================================OK
        if (param.equals("salvarProduto")) {
            // capturar dados que vieram do REQUEST
            int id = Integer.parseInt(request.getParameter("id"));
            String descricao = request.getParameter("descricao");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            double precoVenda = Double.parseDouble(request.getParameter("precoVenda"));
            System.out.println("precoVenda é: " + precoVenda);
            int estoque = Integer.parseInt(request.getParameter("estoque"));
            String status = request.getParameter("status");
            int categoria = Integer.parseInt(request.getParameter("comboCategoria"));
            //String imagem = request.getParameter("imagem");

            // validacoes dos campos - não farei
            // criar OBJ do tipo que será salvo
            Produto p = new Produto();
            p.setId(id);
            p.setDescricao(descricao);
            p.setQuantidade(quantidade);
            p.setPrecoVenda(precoVenda);
            p.setEstoque(estoque);
            p.setStatus(status.charAt(0));
            p.setCategoria(categoria);
            //p.setImagem(imagem);
            System.out.println(status);

            // chamar o salvar e aguardar o retorno
            String retorno = null;
            if (id == 0) {
                retorno = new ProdutoDAO().salvar(p);
            } else {
                retorno = new ProdutoDAO().atualizar(p);
            }

            if (retorno == null) {
                // deu certo
                request.setAttribute("tipoCadastro", "Categoria");
                request.setAttribute("paginaRetorno", "listaproduto.jsp");

                encaminharPagina("sucesso.jsp", request, response);
            } else {
                // deu errado
                encaminharPagina("erro.jsp", request, response);
            }

        }

        // ================= DELETA PRODUTO ====================================OK
        if (param.equals("deletaProduto")) {
            // capturar dados que vieram do REQUEST
            int id = Integer.parseInt(request.getParameter("id"));
            String descricao = request.getParameter("descricao");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            double precoVenda = Double.parseDouble(request.getParameter("precoVenda"));
            int estoque = Integer.parseInt(request.getParameter("estoque"));
            String status = request.getParameter("status");
            int categoria = Integer.parseInt(request.getParameter("categoria"));

            // validacoes dos campos - não farei
            // criar OBJ do tipo que será salvo
            Produto p = new Produto();
            p.setId(id);
            p.setDescricao(descricao);
            p.setQuantidade(quantidade);
            p.setPrecoVenda(precoVenda);
            p.setEstoque(estoque);
            p.setStatus(status.charAt(0));
            p.setCategoria(categoria);
            System.out.println(status);

            // chamar o deletar e aguardar o retorno
            String retorno = null;
            if (id != 0) {
                retorno = new ProdutoDAO().excluir(p);
            }
            /*else {
                retorno = new ProdutoDAO().atualizar(p);
            }*/

            if (retorno == null) {
                // deu certo
                request.setAttribute("tipoCadastro", "Categoria");
                request.setAttribute("paginaRetorno", "listaproduto.jsp");

                encaminharPagina("sucesso.jsp", request, response);
            } else {
                // deu errado
                encaminharPagina("erro.jsp", request, response);
            }

        }

        // ================= SALVA CATEGORIA =====================================OK
        if (param.equals("salvarCategoria")) {
            // capturar dados que vieram do REQUEST
            int id = Integer.parseInt(request.getParameter("id"));
            String descricao = request.getParameter("descricao");
            String status = request.getParameter("status");
            String data = request.getParameter("data");

            // validacoes dos campos - não farei
            // criar OBJ do tipo que será salvo
            Categoria c = new Categoria();
            c.setId(id);
            c.setDescricao(descricao);
            c.setStatus(status.charAt(0));
            c.setData(data);
            System.out.println("O estatus é: " + status);
            System.out.println("A data é: " + data);

            // chamar o salvar e aguardar o retorno
            String retorno = null;
            if (id == 0) {
                retorno = new CategoriaDAO().salvar(c);
            } else {
                retorno = new CategoriaDAO().atualizar(c);
            }

            if (retorno == null) {
                // deu certo
                request.setAttribute("tipoCadastro", "Categoria");
                request.setAttribute("paginaRetorno", "listacategoria.jsp");

                encaminharPagina("sucesso.jsp", request, response);
            } else {
                // deu errado
                encaminharPagina("erro.jsp", request, response);
            }

        }

        // ================= DELETA CATEGORIA ====================================OK
        if (param.equals("deletaCategoria")) {
            // capturar dados que vieram do REQUEST
            int id = Integer.parseInt(request.getParameter("id"));
            String descricao = request.getParameter("descricao");
            String status = request.getParameter("status");
            String data = request.getParameter("data");

            // validacoes dos campos - não farei
            // criar OBJ do tipo que será salvo
            Categoria c = new Categoria();
            c.setId(id);
            c.setDescricao(descricao);
            c.setStatus(status.charAt(0));
            c.setData(data);
            //System.out.println(status);

            // chamar o deletar e aguardar o retorno
            String retorno = null;
            if (id != 0) {
                retorno = new CategoriaDAO().excluir(c);
            }
            /*else {
                retorno = new ProdutoDAO().atualizar(p);
            }*/

            if (retorno == null) {
                // deu certo
                request.setAttribute("tipoCadastro", "Categoria");
                request.setAttribute("paginaRetorno", "listacategoria.jsp");

                encaminharPagina("sucesso.jsp", request, response);
            } else {
                // deu errado
                encaminharPagina("erro.jsp", request, response);
            }

        }

        // ================= COMPRA PRODUTO =====================================OK
        if (param.equals("compraProduto")) {
            // capturar dados que vieram do REQUEST
            int id = Integer.parseInt(request.getParameter("id"));
            String descricao = request.getParameter("descricao");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            double precoVenda = Double.parseDouble(request.getParameter("precoVenda"));
            double subtotal = Double.parseDouble(request.getParameter("precoVenda"));
            double total = Double.parseDouble(request.getParameter("precoVenda"));
            System.out.println("precoVenda é: " + precoVenda);
            //int estoque = Integer.parseInt(request.getParameter("estoque"));
            //String status = request.getParameter("status");
            //int categoria = Integer.parseInt(request.getParameter("categoria"));
            //String imagem = request.getParameter("imagem");

            // validacoes dos campos - não farei
            // criar OBJ do tipo que será salvo
            CompraProduto p = new CompraProduto();
            p.setId(id);
            p.setDescricao(descricao);
            p.setQuantidade(quantidade);
            p.setPrecoVenda(precoVenda);
            p.setSubtotal(subtotal);
            //p.setTotal(total);
            //p.setEstoque(estoque);
            //p.setStatus(status.charAt(0));
            //p.setCategoria(categoria);
            //p.setImagem(imagem);
            //System.out.println(status);

            System.out.println("O Valor");

            // chamar o salvar e aguardar o retorno
            String retorno = null;
            if (id != 0) {
                retorno = new CompraProdutoDAO().salvar(p);
            }

            if (retorno == null) {
                // deu certo
                request.setAttribute("tipoCadastro", "Categoria");
                request.setAttribute("paginaRetorno", "CarrinhoCompra.jsp");

                encaminharPagina("sucesso.jsp", request, response);
            } else {
                // deu errado
                encaminharPagina("erro.jsp", request, response);
            }

        }

        // ================= FINALIZA COMPRA ====================================OK
        if (param.equals("finalizaCompra")) {
            //capturar dados que vieram do REQUEST
            /*int id = Integer.parseInt(request.getParameter("id"));
            String descricao = request.getParameter("descricao");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            double precoVenda = Double.parseDouble(request.getParameter("precoVenda"));
            double subtotal = Double.parseDouble(request.getParameter("subtotal"));
            double total = Double.parseDouble(request.getParameter("total"));
            //System.out.println("precoVenda é: " + precoVenda);
            System.out.println("Estou no açãoSmartBuy - finalizaCompra");
            System.out.println("descricao: " +descricao);
            System.out.println("quantidade: " +quantidade);
            System.out.println("precoVenda: " +precoVenda);
            System.out.println("subtotal: " +subtotal);
            System.out.println("total: " +total);
            //int estoque = Integer.parseInt(request.getParameter("estoque"));
            //String status = request.getParameter("status");
            //int categoria = Integer.parseInt(request.getParameter("categoria"));
            //String imagem = request.getParameter("imagem");*/

            // validacoes dos campos - não farei
            // criar OBJ do tipo que será salvo*/
            /*ComprasRealizadas p = new ComprasRealizadas();
            p.setId(id);
            p.setDescricao(descricao);
            p.setQuantidade(quantidade);
            p.setPrecoVenda(precoVenda);
            p.setSubtotal(subtotal);
            p.setTotal(total);
            //p.setEstoque(estoque);
            //p.setStatus(status.charAt(0));
            //p.setCategoria(categoria);
            //p.setImagem(imagem);
            //System.out.println(status);*/
            // chamar o deletar e aguardar o retorno 
            
            
            /*String retorno = null;
            //String retorno2 = null;

            System.out.println("Estou no servlet ação - finalizaCompra!");
            //retorno2 = new ComprasRealizadasDAO().salvarCompra(p);
            retorno = new CompraProdutoDAO().finalizaCompra();

            /*else {
                retorno = new ProdutoDAO().atualizar(p);
            }*/
            /*if ((retorno != null)) {
                // deu certo
                request.setAttribute("tipoCadastro", "Categoria");
                request.setAttribute("paginaRetorno", "CarrinhoCompra.jsp");

                encaminharPagina("sucesso.jsp", request, response);
            } else {
                // deu errado
                encaminharPagina("erro.jsp", request, response);
            }
            */
            
            
            
            
            
            
            
            
            
            
            
            
            
            String retorno2 = null;
            ArrayList<CompraProduto> compraProduto = new CompraProdutoDAO().consultarTodos2();
            
            
            
            if (retorno2 == null) {
                for (int i = 0; i < compraProduto.size(); i++) {
                    System.out.println("Entrei no primeiro for do finaliza compra");
                    CompraProduto prod = compraProduto.get(i);
                    prod.getId();
                    prod.getDescricao();
                    prod.getQuantidade();
                    prod.getPrecoVenda();
                    prod.getSubtotal();
                    //prod.getTotal();
                    //prod.getDesCategoria();
                    System.out.println("Cheguei no fim do primeiro for do finaliza compra");
                    //ArrayList<ComprasRealizadas> compraRealizada = new ArrayList<>();
                    new ComprasRealizadasDAO().salvarCompra(prod);
                    
                    
                    
                    /*for (int j = 0; j < compraRealizada.size(); j++) {
                        System.out.println("Entrei no segundo for do finaliza compra");
                        ComprasRealizadas prod2 = compraRealizada.get(j);
                        String SimpleDateFormat = null;

                        prod2.setDataCompra(SimpleDateFormat);
                        System.out.println("Data da compra: " + prod2.getDataCompra());
                        prod2.setIdProduto(prod.getId());
                        System.out.println("Id do Produto: " + prod2.getIdProduto());
                        prod2.setIdUsuario(2);
                        System.out.println("Id do Usuário: " + prod2.getIdUsuario());
                        prod2.setPrecoVenda(prod.getPrecoVenda());
                        System.out.println("Preço de venda: " + prod2.getPrecoVenda());
                        prod2.setQuantidade(prod.getQuantidade());
                        System.out.println("Quantidade: " + prod2.getQuantidade());
                        prod2.setSubtotal(100.00);
                        System.out.println("Subtotal: " + prod2.getSubtotal());
                        prod2.setTotal(2000.00);
                        System.out.println("Total: " + prod2.getTotal());
                        new ComprasRealizadasDAO().salvarCompra(prod2);
                    }*/
                }
            }

            // validacoes dos campos - não farei
            // criar OBJ do tipo que será salvo*/
            /*ComprasRealizadas p = new ComprasRealizadas();
            p.setId(id);
            p.setDescricao(descricao);
            p.setQuantidade(quantidade);
            p.setPrecoVenda(precoVenda);
            p.setSubtotal(subtotal);
            p.setTotal(total);
            //p.setEstoque(estoque);
            //p.setStatus(status.charAt(0));
            //p.setCategoria(categoria);
            //p.setImagem(imagem);
            //System.out.println(status);*/
            // chamar o deletar e aguardar o retorno 
            
            
            //String retorno = null;
            //String retorno2 = null;

            System.out.println("Estou no servlet ação - finalizaCompra!");
            //retorno2 = new ComprasRealizadasDAO().salvarCompra(p);
            retorno2 = new CompraProdutoDAO().finalizaCompra();

            /*else {
                retorno = new ProdutoDAO().atualizar(p);
            }*/
            if ((retorno2 != null)) {
                // deu certo
                request.setAttribute("tipoCadastro", "Categoria");
                request.setAttribute("paginaRetorno", "CarrinhoCompra.jsp");

                encaminharPagina("sucesso.jsp", request, response);
            } else {
                // deu errado
                encaminharPagina("erro.jsp", request, response);
            }

        }
        
        
        
        
        
        
        
        
        
        
        
  

        // ================= SELECIONA PRODUTO =================================
        if (param.equals("selectProduto")) {
            //String descricao = request.getParameter("descricao");
            String combo = request.getParameter("comboCategoria");
            System.out.println("Valor do Select: " + combo);
            //request.setAttribute("paginaRetorno", "listaproduto.jsp");

            Produto p = new Produto();

            p.setDescricao(combo);

            // chamar o salvar e aguardar o retorno
            String retorno = null;
            if (combo.equals(null)) {
                retorno = new ProdutoDAO().salvar(p);
            } else {
                retorno = new ProdutoDAO().atualizar(p);
            }

            encaminharPagina("listaproduto.jsp", request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void encaminharPagina(String pagina, HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(pagina);
            rd.forward(request, response);
        } catch (Exception e) {
            System.out.println("Erro ao encaminhar: " + e);
        }
    }
}
