/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO;
import entidade.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author tiago
 */
public class UsuarioDAO implements IDAO<Usuario> {

    @Override
    public String salvar(Usuario o) {
        try {
//            Statement stm = ferrados.Ferrados.conexao.createStatement();
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "INSERT INTO usuario VALUES "
                    + "(default,"
                    + " '" + o.getEmail()+ "',"
                    + " '" + o.getName()+ "',"
                    + " '" + o.getLastname()+ "',"
                    + " md5('" + o.getPassword()+ "'))";

            System.out.println("SQL: " + sql);

            int resultado = stm.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao salvar usuario: " + e);
            return e.toString();
        }
    }
    

    @Override
    public String atualizar(Usuario o) {
        String saida = null;

        try {
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE usuario "
                    + "SET email = '" + o.getEmail()+ "', "
                    + "name = '" + o.getName()+ "', "
                    + "lastname = '" + o.getLastname()+ "', "
                    + "password md5 = ('" + o.getPassword()+ "') "
                    + "where id = " + o.getId();

            System.out.println("SQL: " + sql);
            System.out.println("Cheguei no atualizar cadastro");
            System.out.println(o.getPassword());

            int retorno = stm.executeUpdate(sql);

            if (retorno != 0) {
                saida = null;
            } else {
                saida = "Erro";
            }

        } catch (Exception e) {
            System.out.println("Erro ao atualizar cadastro: " + e);
            saida = e.toString();
        }

        return saida;
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registroUnico(Usuario o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    

    public Object consultarIdUsuario(int id) {
        Usuario usuario = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM "
                    + "usuario "
                    + "WHERE "
                    + "id = " + id;

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                usuario = new Usuario();

                usuario.setId(resultado.getInt("id"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setName(resultado.getString("name"));
                usuario.setLastname(resultado.getString("lastname"));
                usuario.setPassword(resultado.getString("password"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar Usuario por ID: " + e);
        }

        return usuario;
    }
    
    
    
    
    
    

    @Override
    public boolean consultar(Usuario o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
    
    
    public Usuario consultarUsuario(String email, String password) {
        Usuario consultaUsuario = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT * "
                    + "FROM usuario "
                    + "WHERE email = '" + email + "' AND password = md5 ('"+ password + "') ";
            System.out.println("CONSULTA Usuario");
            System.out.println("SQL: " + sql);
            System.out.println(password);

            ResultSet resultadoQ = st.executeQuery(sql);

            if (resultadoQ.next()) {
                consultaUsuario = new Usuario();
                
                
                consultaUsuario.setId(resultadoQ.getInt("id"));
                consultaUsuario.setEmail(resultadoQ.getString("email"));
                consultaUsuario.setName(resultadoQ.getString("name"));
                consultaUsuario.setLastname(resultadoQ.getString("lastname"));
                consultaUsuario.setPassword(resultadoQ.getString("password"));
                
               
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar o Usuario" + e);
        }

        return consultaUsuario;
    }
    
    
    
    
    public byte[] gerarRelatorio() {
        try {
            Connection conn = ConexaoBD.getInstance().getConnection();

            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/Usuários_Cadastrados.jrxml"));

            Map parameters = new HashMap();

            byte[] bytes = JasperRunManager.runReportToPdf(relatorio, parameters, conn);

            return bytes;
        } catch (Exception e) {
            System.out.println("erro ao gerar relatorio dos produtos cadastrados: " + e);
        }
        return null;
    }
    
    
}
