packages/servlet/filtroSmartBuy



@WebFilter("/*")
public class filtroSmartBuy extends HttpServlet implements Filter {

    List<String> urls = new ArrayList<>();

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
            out.println("<title>Servlet filtro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet filtro at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        urls.add("/smartBuy/");
        urls.add("/smartBuy/acao");
        urls.add("/smartBuy/index.jsp");
        urls.add("/smartBuy/loginSmartBuy.jsp");
        urls.add("/smartBuy/css/bootstrap.min.css");
        urls.add("/smartBuy/css/signin.css");
        urls.add("/smartBuy/css/navbar.css");
        urls.add("/smartBuy/js/bootstrap.bundle.min.js");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        System.out.println("getReqURI: " + req.getRequestURI());

        if (urls.contains(req.getRequestURI())) {
            request.setAttribute("parametro", "login");
            chain.doFilter(request, response);
        } else {
            HttpSession sessao = ((HttpServletRequest) request).getSession();

            // caso não pertença a lista, verifica se há usuário na sessão
            // se não houver, encaminha para o Login
            if (sessao.getAttribute("usuarioLogado") == null) {
                ((HttpServletResponse) response).sendRedirect("loginSmartBuy.jsp");
            } else {
                // se usuário estiver logado, apenas abra a página solicitada
                System.out.println("Destino: " + req.getRequestURI());
                chain.doFilter(request, response);
            }
        }

    }
}