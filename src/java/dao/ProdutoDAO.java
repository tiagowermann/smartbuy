/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO;
import entidade.Categoria;
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
public class ProdutoDAO implements IDAO<Produto>{

    
    
    @Override
    public String salvar(Produto o) {
        try {
//            Statement stm = ferrados.Ferrados.conexao.createStatement();
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO produto VALUES "
                    + "(default,"
                    + " '" + o.getDescricao() + "',"
                    + " '" + o.getQuantidade()+ "',"
                    + " '" + o.getPrecoVenda()+ "',"
                    + " '" + o.getEstoque()+ "',"
                    + " '" + o.getStatus()+ "',"
                    + " '" + o.getCategoria()+ "')";

            System.out.println("SQL: " + sql);
            System.out.println("Estou no Salvar Produto!");
            int resultado = stm.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao salvar produto: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Produto o) {
        String saida = null;

        try {
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE produto "
                    + "SET descricao = '" + o.getDescricao() + "', "
                    + "quantidade = '" + o.getQuantidade()+ "', "
                    + "precoVenda = '" + o.getPrecoVenda()+ "', "
                    + "estoque = '" + o.getEstoque()+ "', "
                    + "status = '" + o.getStatus()+ "', "
                    + "categoria_id = '" + o.getCategoria()+ "' "
                    + "WHERE id = " + o.getId();

            System.out.println("SQL: " + sql);

            int retorno = stm.executeUpdate(sql);

            if (retorno != 0) {
                saida = null;
            } else {
                saida = "Erro";
            }

        } catch (Exception e) {
            System.out.println("Erro ao atualizar produto: " + e);
            saida = e.toString();
        }

        return saida;
    }

    public String excluir(Produto id) {
        String saida = null;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM produto "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            if (retorno != 0) {
                saida = null;
            } else {
                saida = "Erro";
            }

        } catch (Exception e) {
            System.out.println("Erro ao excluir produto: " + e);
            saida = e.toString();
        }

        return saida;
    }

    @Override
    public ArrayList<Produto> consultarTodos() {
        
        ArrayList<Produto> produto = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT p.id, p.descricao AS produto, p.quantidade, p.precovenda, p.estoque, p.status, c.descricao AS categoria "
                    + "FROM produto p "
                    + "LEFT JOIN categoria c ON (p.categoria_id = c.id) "
                    + "ORDER BY p.descricao ASC";

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                Produto p = new Produto();

                p.setId(resultado.getInt("id"));
                p.setDescricao(resultado.getString("produto"));
                p.setQuantidade(resultado.getInt("quantidade"));
                p.setPrecoVenda(resultado.getDouble("precoVenda"));
                p.setEstoque(resultado.getInt("estoque"));
                p.setStatus(resultado.getString("status").charAt(0));
                p.setDesCategoria(resultado.getString("categoria"));

                produto.add(p);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar produto: " + e);
        }

        return produto;
    }

    @Override
    public boolean registroUnico(Produto o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Produto> consultar(String criterio) {
        ArrayList<Produto> produto = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT p.id, p.descricao AS produto, p.quantidade, p.precovenda, p.estoque, p.status, c.descricao AS categoria "
                    + "FROM produto p "
                    + "LEFT JOIN categoria c ON (p.categoria_id = c.id) "
                    + "WHERE p.descricao ilike '%" + criterio + "%' "
                    + "ORDER BY p.descricao ASC";

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                Produto p = new Produto();

                p.setId(resultado.getInt("id"));
                p.setDescricao(resultado.getString("produto"));
                p.setQuantidade(resultado.getInt("quantidade"));
                p.setPrecoVenda(resultado.getDouble("precoVenda"));
                p.setEstoque(resultado.getInt("estoque"));
                p.setStatus(resultado.getString("status").charAt(0));
                p.setDesCategoria(resultado.getString("categoria"));
                //p.setImagem(resultado.getString("imagem"));

                produto.add(p);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar produto: " + e);
        }

        return produto;
    }
    
    
    
    
    
    
    
    //--------------------novo
    public ArrayList<Produto> consultarP(String criterio) {
        ArrayList<Produto> produto = new ArrayList();
        String sql = "";
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            
            if (criterio == "vazio"){
                sql = "SELECT p.id, p.descricao AS produto, p.quantidade, p.precovenda, p.estoque, p.status, c.descricao AS categoria "
                    + "FROM produto p "
                    + "LEFT JOIN categoria c ON (p.categoria_id = c.id) "
                    + "ORDER BY p.descricao ASC";
            } else{
            sql = "SELECT p.id, p.descricao AS produto, p.quantidade, p.precovenda, p.estoque, p.status, c.descricao AS categoria "
                    + "FROM produto p "
                    + "LEFT JOIN categoria c ON (p.categoria_id = c.id) "
                    + "WHERE " + criterio
                    + "ORDER BY p.descricao ASC";
            }

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                Produto p = new Produto();

                p.setId(resultado.getInt("id"));
                p.setDescricao(resultado.getString("produto"));
                p.setQuantidade(resultado.getInt("quantidade"));
                p.setPrecoVenda(resultado.getDouble("precoVenda"));
                p.setEstoque(resultado.getInt("estoque"));
                p.setStatus(resultado.getString("status").charAt(0));
                p.setDesCategoria(resultado.getString("categoria"));
                //p.setImagem(resultado.getString("imagem"));

                produto.add(p);
            }
            System.out.println(sql);
        } catch (Exception e) {
            System.out.println("Erro ao consultar produto: " + e);
        }

        return produto;
    }
    
    
    
    
    
    
    
    
    
    
    public ArrayList<Produto> consultarProdutoEcategoria(String criterio, String criterio2 ) {
        ArrayList<Produto> produto = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM produto p LEFT JOIN categoria c ON (c.\"id\" = p.\"id\")"
                    + "WHERE "
                    + "descricao ilike '%" + criterio + "%' AND categoria = " +criterio2+ " "
                    + "ORDER BY descricao";

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                Produto p = new Produto();

                p.setId(resultado.getInt("id"));
                p.setDescricao(resultado.getString("descricao"));
                p.setQuantidade(resultado.getInt("quantidade"));
                p.setPrecoVenda(resultado.getDouble("precoVenda"));
                p.setEstoque(resultado.getInt("estoque"));
                p.setStatus(resultado.getString("status").charAt(0));
                p.setCategoria(resultado.getInt("categoria"));
                //p.setImagem(resultado.getString("imagem"));

                produto.add(p);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar produto e categoria: " + e);
        }

        return produto;
    }
    
    
    
    
    
    
    

    @Override
    public boolean consultar(Produto o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public Object consultarIdProduto(int id) {
        Produto prod = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT p.id, p.descricao AS produto, p.quantidade, p.precovenda, p.estoque, p.status, c.descricao AS categoria "
                    + "FROM produto p "
                    + "LEFT JOIN categoria c ON (p.categoria_id = c.id) "
                    + "WHERE "
                    + "p.id = " + id;

            ResultSet resultado = st.executeQuery(sql);
            System.out.println(sql);
            
            while (resultado.next()) {
                prod = new Produto();

                prod.setId(resultado.getInt("id"));
                prod.setDescricao(resultado.getString("produto"));
                prod.setQuantidade(resultado.getInt("quantidade"));
                prod.setPrecoVenda(resultado.getDouble("precoVenda"));
                prod.setEstoque(resultado.getInt("estoque"));
                prod.setStatus(resultado.getString("status").charAt(0));
                prod.setDesCategoria(resultado.getString("categoria"));
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
    
    
    
    
    
    
    public Object excluirProduto(int id){
        Produto prod = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM produto "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                prod = new Produto();

                prod.setId(resultado.getInt("id"));
                prod.setDescricao(resultado.getString("descricao"));
                prod.setQuantidade(Integer.parseInt(resultado.getString("quantidade")));
                prod.setPrecoVenda(Double.parseDouble(resultado.getString("precoVenda")));
                prod.setEstoque(Integer.parseInt(resultado.getString("estoque")));
                prod.setStatus(resultado.getString("situacao").charAt(0));
                prod.setCategoria(resultado.getInt("categoria"));
                //prod.setImagem(resultado.getString("imagem"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao excluir produto por ID: " + e);
        }

        return prod;
    }
    
    
    public byte[] gerarRelatorio() {
        try {
            Connection conn = ConexaoBD.getInstance().getConnection();

            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/Produtos_Cadastrados.jrxml"));

            Map parameters = new HashMap();

            byte[] bytes = JasperRunManager.runReportToPdf(relatorio, parameters, conn);

            return bytes;
        } catch (Exception e) {
            System.out.println("erro ao gerar relatorio dos produtos cadastrados: " + e);
        }
        return null;
    }
    
    
    
}