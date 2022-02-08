/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAO;
import entidade.CadastroUsuario;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class CadastroUsuarioDAO implements IDAO<CadastroUsuario>{

    @Override
    public String salvar(CadastroUsuario o) {
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
            System.out.println("Cheguei no salvar cadastro");
            System.out.println(o.getPassword());

            int resultado = stm.executeUpdate(sql);

            return null;
        } catch (Exception e) {
            System.out.println("Erro ao salvar cadastro: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(CadastroUsuario o) {
        String saida = null;

        try {
            Statement stm = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "UPDATE usuario "
                    + "SET email = '" + o.getEmail()+ "', "
                    + "name = '" + o.getName()+ "', "
                    + "lastname = '" + o.getLastname()+ "', "
                    + "password md5 = ('" + o.getPassword()+ "') "
                    + "WHERE id = " + o.getId();

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
    public ArrayList<CadastroUsuario> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean registroUnico(CadastroUsuario o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CadastroUsuario> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object consultarLogin(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean consultar(CadastroUsuario o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
