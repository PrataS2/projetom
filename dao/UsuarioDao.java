package dao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Usuario;

/**
 *
 * @author 42labinfo
 */
public class UsuarioDao {
    
    public void create(Usuario u) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try{
            sql = con.prepareStatement(
         "insert into usuario(nome,email,telefone,cpf) values (?,?,?,?)") ;
            sql.setString(1, u.getNome());
            sql.setString(2, u.getEmail());
            sql.setString(3, u.getTelefone());
            sql.setString(4, u.getCpf());
            
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
    
    
    public List<Usuario> read() throws SQLException{
      
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try{
           sql = con.prepareCall("select * from usuario");
           rs = sql.executeQuery();
           
           while (rs.next()){
               Usuario usuario = new Usuario();
               
               usuario.setId(rs.getInt("id")); 
               usuario.setNome(rs.getString("nome"));                          
               usuario.setEmail(rs.getString("email"));
               usuario.setTelefone(rs.getString("telefone"));
               usuario.setCpf(rs.getString("cpf"));
               
               
               usuarios.add(usuario);
           }
           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, 
                    "Erro ao acessar o banco de dados: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql, rs);
        }       
        
        return usuarios;
    }
    
    
    public void update(Usuario u) throws SQLException{
        Connection con =ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try{
            sql = con.prepareStatement(
     "update usuario set nome = ?,email = ?, telefone = ?, cpf = ? where id = ?");
            
            sql.setString(1, u.getNome());
            sql.setString(2, u.getEmail());
            sql.setString(3, u.getTelefone());
            sql.setString(4, u.getCpf());
            sql.setInt(5, u.getId());
            
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
    
    public void delete(Usuario u) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try{
            sql = con.prepareStatement("delete from usuario where id = ?");
            sql.setInt(1,u.getId());
            
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
    
     
    public List<Usuario> readBusca(String busca) throws SQLException{
      
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        ResultSet rs = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try{
           sql = con.prepareStatement(
        "select * from usuario where nome like ?");
           sql.setString(1, "%" + busca + "%");
           rs = sql.executeQuery();
           
           while (rs.next()){
               Usuario usuario = new Usuario();
               
               usuario.setId(rs.getInt("id"));
               usuario.setNome(rs.getString("nome"));
               usuario.setEmail(rs.getString("email"));
               usuario.setTelefone(rs.getString("telefone"));
               usuario.setCpf(rs.getString("cpf"));
               
               usuarios.add(usuario);
           }
           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, 
                    "Erro ao acessar o banco de dados: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql, rs);
        }       
        
        return usuarios;
         
    }

   
    
    
}
