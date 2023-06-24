/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import java.awt.Image;import java.awt.Toolkit;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import models.AlugarMangas;

/**
 *
 * @author 42labinfo
 */
public class AlugarMangasDao {
    
    
     public void create(AlugarMangas am) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try{
            sql = con.prepareStatement(
         "insert into alugarmangas(nome,manga,duracao,preco,foto) values (?,?,?,?,?)") ;
            sql.setString(1, am.getNome());
            sql.setString(2, am.getManga());
            sql.setString(3, am.getDuracao());
             sql.setFloat(4, am.getPreco());
            sql.setString(5, am.getFoto());
            
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
    
    
    public List<AlugarMangas> read() throws SQLException{
      
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        ResultSet rm = null;
        
        List<AlugarMangas> alugarmangas = new ArrayList<>();
        
        try{
            sql = con.prepareCall("select * from alugarmangas");
            rm = sql.executeQuery();
            
            while(rm.next()){
                AlugarMangas alugarmanga = new AlugarMangas();
                
                alugarmanga.setId(rm.getInt("id"));
                alugarmanga.setNome(rm.getString("nome"));
                alugarmanga.setManga(rm.getString("manga"));
                alugarmanga.setDuracao(rm.getString("duracao"));
                alugarmanga.setPreco(rm.getFloat("preco"));
               alugarmanga.setFoto(rm.getString("foto"));
                
                alugarmangas.add(alugarmanga);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql, rm);
        }
        
        return alugarmangas;
    }
    
    
    public void update(AlugarMangas am) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try{
            sql = con.prepareStatement("update alugarmangas set nome = ?, manga = ?, duracao = ? , preco = ? , foto = ? where id = ?");
            sql.setString(1, am.getNome());
            sql.setString(2, am.getManga());
             sql.setString(3, am.getDuracao());
             sql.setFloat(4, am.getPreco());
             sql.setString(5, am.getFoto());
            sql.setInt(6, am.getId());
            
            sql.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar!" + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql);
        }
    }
    
    public void delete(AlugarMangas am) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        
        try{
            sql = con.prepareStatement("delete from alugarmangas where id = ?");
            sql.setInt(1, am.getId());
            
            sql.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluído com Sucesso!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Excluir: " + ex);
        }
        finally{
            ConnectionFactory.closeConnection(con, sql);
        }
        
    }
    
     
    public List<AlugarMangas> readBusca(String busca) throws SQLException{
      
       Connection con = ConnectionFactory.getConnection();
        PreparedStatement sql = null;
        ResultSet rm = null;
        
        List<AlugarMangas> alugarmangas = new ArrayList<>();
        
        try{
            sql = con.prepareCall("select * from alugarmangas where nome like ?");
            sql.setString(1, "%" + busca + "%");
            rm = sql.executeQuery();
            
            while(rm.next()){
                AlugarMangas alugarmanga = new AlugarMangas();
                
                alugarmanga.setId(rm.getInt("id"));
                alugarmanga.setNome(rm.getString("nome"));
                alugarmanga.setManga(rm.getString("manga"));
                alugarmanga.setDuracao(rm.getString("duracao"));
                alugarmanga.setPreco(rm.getFloat("preco"));
                
                alugarmanga.setFoto(rm.getString("foto"));                
                
                alugarmangas.add(alugarmanga);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, sql, rm);
        }
        
        return alugarmangas;
       
    }
}
