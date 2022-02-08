/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO;
import entidade.Categoria;
import java.util.ArrayList;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author pretto
 */
public class CategoriaDAO implements IDAO<Categoria> {

    ResultSet resultadoQ;

    public boolean salvarInicial(Categoria categoria) {
        try {
//            Statement stm = ferrados.Ferrados.conexao.createStatement();
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "Insert into categoria values "
                    + "(default,"
                    + " '" + categoria.getDescricao() + "',"
                    + " '" + categoria.getStatus()+ "' ,"
                    + " ' NOW() )";

            System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao salvar categoria: " + e);
            return false;
        }
    }

    @Override
    public String salvar(Categoria o) {
        try {
//            Statement stm = ferrados.Ferrados.conexao.createStatement();
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO categoria VALUES "
                    + "(default,"
                    + " '" + o.getDescricao() + "',"
                    + " '" + o.getStatus() + "' ,"
                    + " '" + o.getData() + "' )";

            System.out.println("SQL: " + sql);
            System.out.println("A data é: "+o.getData());
            
            int resultado = stm.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao salvar categoria: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Categoria o) {
        String saida = null;

        try {
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE categoria "
                    + "SET descricao = '" + o.getDescricao() + "', "
                    + "status = '" + o.getStatus() + "' ,"
                    + "data = '" +o.getData() + "' "
                    + "where id = " + o.getId();

            System.out.println("SQL: " + sql);

            int retorno = stm.executeUpdate(sql);

            if (retorno != 0) {
                saida = null;
            } else {
                saida = "Erro";
            }

        } catch (Exception e) {
            System.out.println("Erro ao atualizar Categoria: " + e);
            saida = e.toString();
        }

        return saida;
    }
    
    public String excluir(Categoria id) {
        String saida = null;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM categoria "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            if (retorno != 0) {
                saida = null;
            } else {
                saida = "Erro";
            }

        } catch (Exception e) {
            System.out.println("Erro ao excluir categoria: " + e);
            saida = e.toString();
        }

        return saida;
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Categoria> consultarTodos() {

        ArrayList<Categoria> categorias = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM "
                    + "categoria "
                    + "ORDER BY descricao";

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                Categoria c = new Categoria();

                c.setId(resultado.getInt("id"));
                c.setDescricao(resultado.getString("descricao"));
                c.setStatus(resultado.getString("status").charAt(0));
                c.setData("data");

                categorias.add(c);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar categorias: " + e);
        }

        return categorias;
    }

    public ArrayList<Categoria> consultarEspecial(String criterio, String data) {
        ArrayList<Categoria> categorias = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM "
                    + "categoria "
                    + "WHERE "
                    + "descricao ILIKE '%" + criterio + "%' AND data >= '"+ data + "'"
                    + "ORDER BY descricao";

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                Categoria c = new Categoria();

                c.setId(resultado.getInt("id"));
                c.setDescricao(resultado.getString("descricao"));
                c.setStatus(resultado.getString("status").charAt(0));
                c.setData("data");

                categorias.add(c);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar categorias: " + e);
        }

        return categorias;
    }
    
    
    public Object consultarIdCategoria(int id) {
        Categoria categ = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM "
                    + "categoria "
                    + "WHERE "
                    + "id = " + id;

            ResultSet resultado = st.executeQuery(sql);

            System.out.println(id);
            while (resultado.next()) {
                categ = new Categoria();

                categ.setId(resultado.getInt("id"));
                categ.setDescricao(resultado.getString("descricao"));
                categ.setStatus(resultado.getString("status").charAt(0));
                categ.setData("data");
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar categoria por ID: " + e);
        }

        return categ;
    }
    
    

    public Categoria consultarId(int id) {
        Categoria c = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "select * "
                    + "from "
                    + "categoria "
                    + "where "
                    + "id = " + id;

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                c = new Categoria();

                c.setId(resultado.getInt("id"));
                c.setDescricao(resultado.getString("descricao"));
                c.setStatus(resultado.getString("situacao").charAt(0));
                c.setData("data");
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar Categoria por ID: " + e);
        }

        return c;
    }

    @Override
    public boolean registroUnico(Categoria o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean consultar(Categoria o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object consultarLogin(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Object excluirCategoria(int id){
        Categoria categ = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM categoria "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                categ = new Categoria();

                categ.setId(resultado.getInt("id"));
                categ.setDescricao(resultado.getString("descricao"));
                categ.setStatus(resultado.getString("situacao").charAt(0));
                categ.setData("data");
            }

        } catch (Exception e) {
            System.out.println("Erro ao excluir categoria : " + e);
        }

        return categ;
    }
    
    
    
    public byte[] gerarRelatorio() {
        try {
            Connection conn = ConexaoBD.getInstance().getConnection();

            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/Categorias_Cadastradas.jrxml"));

            Map parameters = new HashMap();

            byte[] bytes = JasperRunManager.runReportToPdf(relatorio, parameters, conn);

            return bytes;
        } catch (Exception e) {
            System.out.println("erro ao gerar relatorio das categorias cadastradas: " + e);
        }
        return null;
    }

    
    
    
    
    @Override
    public ArrayList<Categoria> consultar(String criterio) {
        ArrayList<Categoria> categorias = new ArrayList();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM "
                    + "categoria "
                    + "WHERE "
                    + "descricao ILIKE '%" + criterio + "%'"
                    + "ORDER BY descricao";
            System.out.println("CONSULTA CATEGORIA");
            System.out.println("SQL: " + sql);

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                Categoria c = new Categoria();

                c.setId(resultado.getInt("id"));
                c.setDescricao(resultado.getString("descricao"));
                c.setStatus(resultado.getString("status").charAt(0));
                c.setData("data");

                categorias.add(c);
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar categorias: " + e);
        }

        return categorias;
    }
    
    
    
}
