/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import models.Servico;
import conexao.ConnectionFactory;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Servico;
import view.TelaCadastroServico;
import view.TelaLogin;
import view.TelaCadastroServico;
import view.TelaFuncionario;



/**
 *
 * @author 42labinfo
 */
public class ServicoDao {

   
   
   
   
    
    public void create(Servico a) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try{
            sql = con.prepareStatement(
         "insert into servico(usuario, email, manga, preco) values (?,?,?,?)") ;
            sql.setString(1, a.getUsuario());
            sql.setString(2, a.getEmail());
           sql.setString(3, a.getManga());
           sql.setFloat(4, a.getPreco()); 
           
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
    
    
    public List<Servico> read() throws SQLException{
      
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        ResultSet rs = null;
        
        List<Servico> servico = new ArrayList<>();
        
        try{
           sql = con.prepareCall("select * from servico");
           rs = sql.executeQuery();
           
           while (rs.next()){
               Servico servicos = new Servico();
               
               servicos.setId(rs.getInt("id"));
               servicos.setUsuario(rs.getString("usuario"));
               servicos.setEmail(rs.getString("email"));
               servicos.setManga(rs.getString("manga"));
               servicos.setPreco(rs.getFloat("preco"));
               
               servico.add(servicos);
           }
           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, 
                    "Erro ao acessar o banco de dados: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql, rs);
        }       
        
        return servico;
    }
    
    
    public void update(Servico a) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try{
            sql = con.prepareStatement(
     "update servico set usuario = ? , email = ? , manga = ? , preco = ? where id = ?");          
            sql.setString(1, a.getUsuario());
            sql.setString(2, a.getEmail());
             sql.setString(3, a.getManga());
             sql.setFloat(4, a.getPreco());
             sql.setInt(5, a.getId());
            
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
    
    public void delete(Servico a) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try{
            sql = con.prepareStatement("delete from servico where id = ?");
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
    
     
    public List<Servico> readBusca(String busca) throws SQLException{
      
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        ResultSet rs = null;
        
        List<Servico> servico = new ArrayList<>();
        
        try{
           sql = con.prepareStatement(
        "select * from servico where usuario like ?");
           sql.setString(1, "%" + busca + "%");
           rs = sql.executeQuery();
           
           while (rs.next()){
               Servico servicos = new Servico();
               
               servicos.setId(rs.getInt("id"));
               servicos.setUsuario(rs.getString("usuario"));
               servicos.setEmail(rs.getString("email"));
               servicos.setManga(rs.getString("manga"));
               servicos.setPreco(rs.getFloat("preco"));
               
               servico.add(servicos);
           }
           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, 
                    "Erro ao acessar o banco de dados: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql, rs);
        }       
        
        return servico;
         
    }
    
   
    
    
    

    
}
