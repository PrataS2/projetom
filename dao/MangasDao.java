/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import models.Mangas;

/**
 *
 * @author 42labinfo
 */
public class MangasDao {
    
    
     public void create(Mangas m) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try{
            sql = con.prepareStatement(
         "insert into mangas(nome,preco,unidades,foto) values (?,?,?,?)") ;
            sql.setString(1, m.getNome());   
            sql.setFloat(2, m.getPreco());
             sql.setString(3, m.getUnidades());
            sql.setString(4, m.getFoto());
            
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
    
    
    public List<Mangas> read() throws SQLException{
      
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        ResultSet rm = null;
        
        List<Mangas> mangas = new ArrayList<>();
        
        try{
            sql = con.prepareCall("select * from mangas");
            rm = sql.executeQuery();
            
            while(rm.next()){
                Mangas manga = new Mangas();
                
                manga.setId(rm.getInt("id"));
                manga.setNome(rm.getString("nome"));            
                manga.setPreco(rm.getFloat("preco"));
                manga.setUnidades(rm.getString("unidades"));
                manga.setFoto(rm.getString("foto"));
               
                
                mangas.add(manga);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql, rm);
        }
        
        return mangas;
    }
    
    
    public void update(Mangas m) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try{
            sql = con.prepareStatement("update mangas set nome = ?, preco = ?, unidades = ? , foto = ? where id = ?");
             sql.setString(1, m.getNome());
             sql.setFloat(2, m.getPreco());
             sql.setString(3, m.getUnidades());
             sql.setString(4, m.getFoto());
             sql.setInt(5, m.getId());
            
            sql.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar!" + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql);
        }
    }
    
    public void delete(Mangas m) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try{
            sql = con.prepareStatement("delete from mangas where id = ?");
            sql.setInt(1, m.getId());
            
            sql.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com Sucesso!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Excluir: " + ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, sql);
        }
        
    }
    
     
    public List<Mangas> readBusca(String busca) throws SQLException{
      
       Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        ResultSet rm = null;
        
        List<Mangas> mangas = new ArrayList<>();
        
        try{
            sql = con.prepareCall("select * from mangas where nome like ?");
            sql.setString(1, "%" + busca + "%");
            rm = sql.executeQuery();
            
            while(rm.next()){
                Mangas manga = new Mangas();
                
                manga.setId(rm.getInt("id"));
                manga.setNome(rm.getString("nome"));        
                manga.setPreco(rm.getFloat("preco"));
                manga.setUnidades(rm.getString("unidades"));
                manga.setFoto(rm.getString("foto"));
                                
                mangas.add(manga);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql, rm);
        }
        
        return mangas;
       
    }
}
