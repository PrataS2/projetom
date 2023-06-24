/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import models.Adm;
import conexao.ConnectionFactory;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Adm;
import view.TelaAdm;
import view.TelaLogin;
import view.TelaFuncionario;



/**
 *
 * @author 42labinfo
 */
public class AdmDao {

   
   
    
    private final TelaLogin telaLogin;
    
     public AdmDao(view.TelaLogin telaLogin) {
        this.telaLogin = telaLogin;
    }

  
    
    public void create(Adm a) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try{
            sql = con.prepareStatement(
         "insert into adm(login, senha, nivel_acesso) values (?,?,?)") ;
            sql.setString(1, a.getLogin());
            sql.setString(2, a.getSenha());
           sql.setString(3, a.getNivel());
            
            sql.executeUpdate();
            
            JOptionPane.showMessageDialog(
                    null, "Cadastrado com sucesso!");
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(
                   null, "Erro ao Cadastrar: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql);
        }
        
    }
    
    
    public List<Adm> read() throws SQLException{
      
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        ResultSet rs = null;
        
        List<Adm> adm = new ArrayList<>();
        
        try{
           sql = con.prepareCall("select * from adm");
           rs = sql.executeQuery();
           
           while (rs.next()){
               Adm adms = new Adm();
               
               adms.setId(rs.getInt("id"));
               adms.setLogin(rs.getString("login"));
               adms.setSenha(rs.getString("senha"));
               adms.setNivel(rs.getString("nivel_acesso"));
               
               adm.add(adms);
           }
           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, 
                    "Erro ao acessar o banco de dados: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql, rs);
        }       
        
        return adm;
    }
    
    
    public void update(Adm a) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try{
            sql = con.prepareStatement(
     "update adm set senha = ? ,login = ? ,nivel_acesso = ? where id = ?");          
            sql.setString(1, a.getSenha());
            sql.setString(2, a.getLogin());
            sql.setString(3, a.getNivel());
             sql.setInt(4, a.getId());
            
            sql.executeUpdate();
            
            JOptionPane.showMessageDialog(null, 
                    "Dados Atualizados com Sucesso!");            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, 
                    "Erro ao Atualizar!" + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql);
        }
    }
    
    public void delete(Adm a) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try{
            sql = con.prepareStatement("delete from adm where id = ?");
            sql.setInt(1,a.getId());
            
            sql.executeUpdate();
            JOptionPane.showMessageDialog(null, 
                    "Excluido com Sucesso!");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, 
                    "Erro ao Excluir: " + ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, sql);
        }
        
    }
    
     
    public List<Adm> readBusca(String busca) throws SQLException{
      
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        ResultSet rs = null;
        
        List<Adm> adm = new ArrayList<>();
        
        try{
           sql = con.prepareStatement(
        "select * from adm where login like ?");
           sql.setString(1, "%" + busca + "%");
           rs = sql.executeQuery();
           
           while (rs.next()){
               Adm adms = new Adm();
               
               adms.setId(rs.getInt("id"));
               adms.setLogin(rs.getString("login"));
               adms.setSenha(rs.getString("senha"));
               adms.setNivel(rs.getString("nivel_acesso"));
               
               adm.add(adms);
           }
           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, 
                    "Erro ao acessar o banco de dados: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql, rs);
        }       
        
        return adm;
         
    }
    
            
      public void loginSistema(String login, String senha) throws SQLException {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement sql = null;
    ResultSet rs = null;
    int achei = 0;
    try {
        sql = con.prepareStatement("SELECT * FROM adm");
        rs = sql.executeQuery();
        while (rs.next()) {
            String user = rs.getString("login");
            String password = rs.getString("senha");
            String nivelAcesso = rs.getString("nivel_acesso");

            if (login.equals(user) && senha.equals(password)) {
                if (nivelAcesso.equals("adm")) {
                     JOptionPane.showMessageDialog(null, 
                    "SEJA BEM-VINDO, ADMINISTRADOR ");
                    new TelaAdm().setVisible(true);
                    this.telaLogin.dispose();
                } else if (nivelAcesso.equals("fun")) {
                    JOptionPane.showMessageDialog(null, 
                    "SEJA BEM-VINDO, FUNCIONÁRO " +login );
                    new TelaFuncionario().setVisible(true);
                    this.telaLogin.dispose();
                }

                achei = 1;
                break;
            }
        }
        if (achei == 0) {
            JOptionPane.showMessageDialog(null, "Usuário ou Senha incorretos");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao acessar o Banco de Dados: " + ex);
    } finally {
        ConnectionFactory.closeConnection(con, sql);
    }
    }
    
    
    
    

    
}
