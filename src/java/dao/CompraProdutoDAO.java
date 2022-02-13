/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO;
import entidade.Categoria;
import entidade.CompraProduto;
import entidade.Produto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author tiago
 */
public class CompraProdutoDAO implements IDAO<Produto> {

    public String salvar(CompraProduto o) {
        try {
//            Statement stm = ferrados.Ferrados.conexao.createStatement();
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO compraproduto VALUES "
                    + "(default,"
                    + " '" + o.getDescricao() + "',"
                    + " '" + o.getQuantidade() + "',"
                    + " '" + o.getPrecoVenda() + "',"
                    + " '" + o.getSubtotal() + "')";

            System.out.println("SQL: " + sql);
            System.out.println("Entrei no salvar compra produto!");
            int resultado = stm.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao salvar a compra do produto: " + e);
            return e.toString();
        }
    }

    public String atualizarCompra(CompraProduto o) {
        String saida = null;

        try {
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE compraproduto "
                    + "SET descricao = '" + o.getDescricao() + "', "
                    + "quantidade = '" + o.getQuantidade() + "', "
                    + "precoVenda = '" + o.getPrecoVenda() + "', "
                    + "subtotal = '" + o.getSubtotal() + "'"
                    + "WHERE id = " + o.getId();

            System.out.println("SQL: " + sql);

            int retorno = stm.executeUpdate(sql);

            if (retorno != 0) {
                saida = null;
            } else {
                saida = "Erro";
            }

        } catch (Exception e) {
            System.out.println("Erro ao atualizar a compra do produto: " + e);
            saida = e.toString();
        }

        return saida;
    }

    public String excluir(CompraProduto id) {
        String saida = null;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM compraproduto "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            if (retorno != 0) {
                saida = null;
            } else {
                saida = "Erro";
            }

        } catch (Exception e) {
            System.out.println("Erro ao excluir compra do produto: " + e);
            saida = e.toString();
        }

        return saida;
    }

    public ArrayList<CompraProduto> consultarTodasCompras() {

        ArrayList<CompraProduto> compraProduto = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM "
                    + "compraproduto "
                    + "order by descricao";

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                CompraProduto p = new CompraProduto();

                p.setId(resultado.getInt("id"));
                p.setDescricao(resultado.getString("descricao"));
                p.setQuantidade(resultado.getInt("quantidade"));
                p.setPrecoVenda(resultado.getDouble("precoVenda"));
                p.setSubtotal(resultado.getDouble("subtotal"));
                //p.setCategoria(resultado.getString("categoria_id").charAt(0));

                compraProduto.add(p);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar produto: " + e);
        }

        return compraProduto;
    }

    @Override
    public boolean registroUnico(Produto o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<CompraProduto> consultarCompra(String criterio) {
        ArrayList<CompraProduto> produto = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM "
                    + "compraproduto "
                    + "WHERE "
                    + "descricao ilike '%" + criterio + "%' "
                    + "ORDER BY descricao";

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                CompraProduto p = new CompraProduto();

                p.setId(resultado.getInt("id"));
                p.setDescricao(resultado.getString("descricao"));
                p.setQuantidade(resultado.getInt("quantidade"));
                p.setPrecoVenda(resultado.getDouble("precoVenda"));
                p.setSubtotal(resultado.getDouble("subtotal"));
                //p.setEstoque(resultado.getInt("estoque"));
                //p.setStatus(resultado.getString("status").charAt(0));
                //p.setCategoria(resultado.getString("categoria").charAt(0));
                //p.setImagem(resultado.getString("imagem"));

                produto.add(p);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar produto: " + e);
        }

        return produto;
    }

    @Override
    public boolean consultar(Produto o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object consultarIdProduto(int id) {
        CompraProduto prod = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM "
                    + "consultaproduto "
                    + "WHERE "
                    + "id = " + id;

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                prod = new CompraProduto();

                prod.setId(resultado.getInt("id"));
                prod.setDescricao(resultado.getString("descricao"));
                prod.setQuantidade(Integer.parseInt(resultado.getString("quantidade")));
                prod.setPrecoVenda(Double.parseDouble(resultado.getString("precoVenda")));
                prod.setSubtotal(Double.parseDouble(resultado.getString("subtotal")));
                //prod.setEstoque(Integer.parseInt(resultado.getString("estoque")));
                //prod.setStatus(resultado.getString("status").charAt(0));
                //prod.setCategoria(resultado.getString("categoria_id").charAt(0));
                //prod.setImagem(resultado.getString("imagem"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar produto por ID: " + e);
        }

        return prod;
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object excluirProduto(int id) {
        CompraProduto prod = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM compraproduto "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                prod = new CompraProduto();

                prod.setId(resultado.getInt("id"));
                prod.setDescricao(resultado.getString("descricao"));
                prod.setQuantidade(Integer.parseInt(resultado.getString("quantidade")));
                prod.setPrecoVenda(Double.parseDouble(resultado.getString("precoVenda")));
                prod.setSubtotal(Double.parseDouble(resultado.getString("subtotal")));
                //prod.setEstoque(Integer.parseInt(resultado.getString("estoque")));
                //prod.setStatus(resultado.getString("situacao").charAt(0));
                //prod.setCategoria(resultado.getString("categoria").charAt(0));
                //prod.setImagem(resultado.getString("imagem"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao excluir produto por ID: " + e);
        }

        return prod;
    }

    @Override
    public String salvar(Produto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Produto> consultarTodos() {

        ArrayList<Produto> produto = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM compraproduto "
                    + "ORDER BY descricao ASC";

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                Produto p = new Produto();

                p.setId(resultado.getInt("id"));
                p.setDescricao(resultado.getString("descricao"));
                p.setQuantidade(resultado.getInt("quantidade"));
                p.setPrecoVenda(resultado.getDouble("precoVenda"));
                p.setEstoque(resultado.getInt("subtotal"));
                //p.setStatus(resultado.getString("status").charAt(0));
                //p.setDesCategoria(resultado.getString("categoria"));

                produto.add(p);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar produto comprado: " + e);
        }

        return produto;
    }

    public ArrayList<CompraProduto> consultarTodos2() {

        ArrayList<CompraProduto> produto = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM compraproduto "
                    + "ORDER BY descricao ASC";

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                CompraProduto p = new CompraProduto();

                p.setId(resultado.getInt("id"));
                p.setDescricao(resultado.getString("descricao"));
                p.setQuantidade(resultado.getInt("quantidade"));
                p.setPrecoVenda(resultado.getDouble("precoVenda"));
                p.setSubtotal(resultado.getInt("subtotal"));
                //p.setTotal(resultado.getInt("total"));
                //p.setStatus(resultado.getString("status").charAt(0));
                //p.setDesCategoria(resultado.getString("categoria"));

                produto.add(p);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar produto comprado: " + e);
        }

        return produto;
    }

    public String finalizaCompra() {
       String saida = null;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "TRUNCATE TABLE compraproduto ";
                   
                    
            

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);
            
            System.out.println("Retorno: " + retorno);
            
            if (retorno != 0) {
                saida = null;
                System.out.println("saida: " + saida);
            } else {
                saida = "Erro";
                System.out.println("saida: " + saida);
            }

        } catch (Exception e) {
            System.out.println("Erro ao excluir compra do produto: " + e);
            saida = e.toString();
        }
        System.out.println("Saida excluir compra do produto do Finaliza compra: " + saida);
        return saida;
    }

    public String salvarCompra(CompraProduto o) {
        try {
//            Statement stm = ferrados.Ferrados.conexao.createStatement();
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO comprasrealizadas VALUES "
                    + "(default,"
                    + " '" + o.getDescricao() + "',"
                    + " '" + o.getQuantidade() + "',"
                    + " '" + o.getPrecoVenda() + "',"
                    + " '" + o.getSubtotal() + "')";

            System.out.println("SQL: " + sql);
            System.out.println("Entrei no salvar compra produto!");
            int resultado = stm.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao salvar a compra do produto: " + e);
            return e.toString();
        }
    }

    public String salvarTotal(CompraProduto o) {
        try {
//            Statement stm = ferrados.Ferrados.conexao.createStatement();
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO comprasrealizadas VALUES "
                    + "(default,"
                    + " default, "
                    + " '" + o.getDescricao() + "',"
                    + " '" + o.getQuantidade() + "',"
                    + " '" + o.getPrecoVenda() + "',"
                    + " '" + o.getSubtotal() + "',"
                    + " '" + o.getTotal() + "')";

            System.out.println("SQL: " + sql);
            System.out.println("Entrei no salvarTotal do ComprasRealizadasDAO");
            int resultado = stm.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao salvarTotal no ComprasRealizadasDAO: " + e);
            return e.toString();
        }
    }

    public byte[] gerarRelatorio() {
        try {
            Connection conn = ConexaoBD.getInstance().getConnection();

            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/Compras_Carrinho.jrxml"));

            Map parameters = new HashMap();

            byte[] bytes = JasperRunManager.runReportToPdf(relatorio, parameters, conn);

            return bytes;
        } catch (Exception e) {
            System.out.println("erro ao gerar relatorio das categorias cadastradas: " + e);
        }
        return null;
    }

    @Override
    public String atualizar(Produto o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Produto> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
