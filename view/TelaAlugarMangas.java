/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.sun.jdi.connect.spi.Connection;
import dao.AlugarMangasDao;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.AlugarMangas;
/**
 *
 * @author 42labinfo
 */
public class TelaAlugarMangas extends javax.swing.JFrame {
     
    private Connection con;
    private PreparedStatement pst;
    private  String imagePath;
    private String nomeImagem;
    private String foto;
    
    
   
    
    //inteanciar objeto para o fluxo de  bytes 
    private FileInputStream fis;
    
    //variável global para amazenar o tamanho da imagem(bytes)
    private int tamanho;
    

    /**
     * Creates new form TelaMangas
     */
    public TelaAlugarMangas() throws SQLException {
        initComponents();
         readJTable();
       //setIcon();
    }
    
     private void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../imagens/cut.png")));
    }
    public void readJTable() throws SQLException{
        
        DefaultTableModel modelo = (DefaultTableModel) tblMangas.getModel();       
        tblMangas.setRowSorter(new TableRowSorter(modelo));
        modelo.setNumRows(0);//utilizado para não duplicar as linhas
        
        AlugarMangasDao alugarmangasDao = new AlugarMangasDao();
        
        for (AlugarMangas alugarmangas: alugarmangasDao.read()){
            modelo.addRow(new Object[]{
               alugarmangas.getId(),
               alugarmangas.getNome(),
               alugarmangas.getManga(), 
               alugarmangas.getDuracao(),
               "R$ " + alugarmangas.getPreco(),
               alugarmangas.getFoto(), 
               
            });
        }
    }

         public void readJTableBusca(String busca) throws SQLException{
        
        DefaultTableModel modelo = (DefaultTableModel) tblMangas.getModel();       
        tblMangas.setRowSorter(new TableRowSorter(modelo));
        modelo.setNumRows(0);//utilizado para não duplicar as linhas
        
        AlugarMangasDao alugarmangasDao = new AlugarMangasDao();
        
        for (AlugarMangas alugarmangas: alugarmangasDao.readBusca(busca)){
            modelo.addRow(new Object[]{
                  alugarmangas.getId(),
                  alugarmangas.getNome(),
                  alugarmangas.getManga(),    
                  alugarmangas.getDuracao(),
                 "R$ " +  alugarmangas.getPreco(),
                  alugarmangas.getFoto(),
             
                                      
            });
        }
         
       
        
    }
     public void limpar(){
        
        //limpar os campos
       
        txtNome.setText("");
        txtManga.setText("");
        txtDuracao.setText("");
        txtPreco.setText("");
        lblFoto.setText("");
        txtBusca.setText("");
     
        
        btnAdicionar.setEnabled(true);
        txtBusca.setEnabled(true);
        btnBusca.setEnabled(true);
        
        btnExcluir.setEnabled(false);
        btnAtualizar.setEnabled(false);
        
        try {
            readJTable();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(TelaAlugarMangas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblFoto = new javax.swing.JLabel();
        btnCarregar = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMangas = new javax.swing.JTable();
        btnLimpar = new javax.swing.JButton();
        txtDuracao = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        txtManga = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnTabela = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        btnBusca = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        btnAtualizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens manga/Otakus (200 × 200 px).png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 190, 130));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mangá");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cliente");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        txtNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 280, 30));

        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens manga/f45851c2e013d2d4a8df3b1b47eb87d6.png"))); // NOI18N
        lblFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 190, 220));

        btnCarregar.setText("Carregar Foto");
        btnCarregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCarregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 100, 30));

        btnAdicionar.setFont(new java.awt.Font("Segoe UI Black", 1, 13)); // NOI18N
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens manga/add.png"))); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 110, 30));

        tblMangas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblMangas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Mangá", "Duração", "Preço", "Foto"
            }
        ));
        tblMangas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMangasMouseClicked(evt);
            }
        });
        tblMangas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblMangasKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblMangas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 660, 140));

        btnLimpar.setFont(new java.awt.Font("Segoe UI Black", 1, 13)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens manga/limpar.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, 110, 30));

        txtDuracao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtDuracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuracaoActionPerformed(evt);
            }
        });
        jPanel1.add(txtDuracao, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 280, 30));

        btnExcluir.setFont(new java.awt.Font("Segoe UI Black", 1, 13)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens manga/delete.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 110, 30));

        txtManga.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtManga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMangaActionPerformed(evt);
            }
        });
        jPanel1.add(txtManga, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 280, 30));

        txtPreco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoActionPerformed(evt);
            }
        });
        jPanel1.add(txtPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 280, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Preço");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 70, -1));

        btnTabela.setFont(new java.awt.Font("Segoe UI Black", 1, 13)); // NOI18N
        btnTabela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagensView/Design sem nome (3).png"))); // NOI18N
        btnTabela.setText("Tabela");
        btnTabela.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTabelaActionPerformed(evt);
            }
        });
        jPanel1.add(btnTabela, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 110, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Duração");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 70, -1));

        btnSair.setFont(new java.awt.Font("Segoe UI Black", 1, 13)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens manga/house_go.png"))); // NOI18N
        btnSair.setText("Voltar");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 550, 100, 30));

        btnBusca.setFont(new java.awt.Font("Segoe UI Black", 1, 13)); // NOI18N
        btnBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens manga/zoom.png"))); // NOI18N
        btnBusca.setText("Buscar");
        btnBusca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });
        jPanel1.add(btnBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 110, 30));

        txtBusca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaActionPerformed(evt);
            }
        });
        jPanel1.add(txtBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 220, 30));

        btnAtualizar.setFont(new java.awt.Font("Segoe UI Black", 1, 13)); // NOI18N
        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens manga/pencil.png"))); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 110, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens manga/roxinho.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarregarActionPerformed

                  carregarFoto();
    }//GEN-LAST:event_btnCarregarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        if(!txtNome.getText().isEmpty() && !txtManga.getText().isEmpty() && !txtDuracao.getText().isEmpty()){ 
            
            //cria os objetos   
            AlugarMangas alugarmanga = new AlugarMangas();
            AlugarMangasDao amdao = new AlugarMangasDao();
           
            //setar os campos ; e de acordo com o pc que estiver ultilizando tem q mudar o caminho;         
            String destinationFolder = "C:/Users/Pichau/Documents/NetbeansProjects/MangaOtakus/src/mangas/";
            foto = "C:/Users/Pichau/Documents/NetBeansProjects/MangaOtakus/src/mangas/" + nomeImagem;
            
            String imageFileName = null;
           
          
            
            try {
                // Realizar o upload da imagem
                imageFileName = uploadImage(imagePath, destinationFolder);
                 System.out.println("Imagem enviada com sucesso");
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(TelaAlugarMangas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            
            alugarmanga.setNome(txtNome.getText());
            alugarmanga.setManga(txtManga.getText());
            alugarmanga.setDuracao(txtDuracao.getText());
            alugarmanga.setFoto(foto);
            
             //incluir no banco de dados
            try {
                amdao.create(alugarmanga);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(TelaAlugarMangas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
                      
                      
            limpar();
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Informe corretamente suas informações");
            txtNome.grabFocus();
        }
                 
        
    }//GEN-LAST:event_btnAdicionarActionPerformed

     private static String uploadImage(String caminho, String destinationFolder) throws IOException {
        File source = new File(caminho);        
        File destination = new File(destinationFolder, source.getName());
         System.out.println(source);
         System.out.println(destination);
        Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
        return destination.getAbsolutePath();
    }
    
    
    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
       limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
         if(tblMangas.getSelectedRow() != -1){
            
            int resp = JOptionPane.showConfirmDialog(null, "Confirma a Exclusão do Registro", "Exclusão de Registro", OK_CANCEL_OPTION);
            if(resp == 0){
                AlugarMangas alugarmangas = new AlugarMangas();
                AlugarMangasDao dao = new AlugarMangasDao();
                
                alugarmangas.setId((int) tblMangas.getValueAt(tblMangas.getSelectedRow(), 0));
                
                try {
                    dao.delete(alugarmangas);
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(TelaAlugarMangas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                
                limpar();
            }
        }
         else{
            JOptionPane.showMessageDialog(null, "Selecione uma coluna na tabela abaixo!");
        }
                              
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        if(tblMangas.getSelectedRow() != -1){
            
           AlugarMangas alugarmangas  = new  AlugarMangas ();
            AlugarMangasDao amdao = new  AlugarMangasDao();
            
             alugarmangas.setNome(txtNome.getText());
             alugarmangas.setManga(txtManga.getText());
             alugarmangas.setDuracao(txtDuracao.getText());
             alugarmangas.setPreco(Float .parseFloat(txtPreco.getText()));
             alugarmangas.setFoto(foto);
         
            alugarmangas.setId((int) tblMangas.getValueAt(tblMangas.getSelectedRow(), 0));
            
          
            try {
                amdao.update(alugarmangas);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(TelaAlugarMangas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            
            
            limpar();
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione uma coluna na tabela abaixo!");
        } 
                                               

   
            
           
            
            
    
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void tblMangasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblMangasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblMangasKeyReleased

    private void tblMangasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMangasMouseClicked
       
         if(tblMangas.getSelectedRow() != -1){
               
               txtNome.setText(tblMangas.getValueAt(tblMangas.getSelectedRow(), 1).toString());
               txtManga.setText(tblMangas.getValueAt(tblMangas.getSelectedRow(), 2).toString());
               txtDuracao.setText(tblMangas.getValueAt(tblMangas.getSelectedRow(), 3).toString());
               txtPreco.setText(tblMangas.getValueAt(tblMangas.getSelectedRow(), 4).toString());
               foto = tblMangas.getValueAt(tblMangas.getSelectedRow(), 5).toString();
               ImageIcon icon = new ImageIcon(foto);
                lblFoto.setIcon(icon);
         
                txtBusca.setEnabled(false);
                btnBusca.setEnabled(false);
                btnAdicionar.setEnabled(false);
            
                btnExcluir.setEnabled(true);
                btnAtualizar.setEnabled(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione uma coluna na tabela abaixo!");
        }
        
        
    }//GEN-LAST:event_tblMangasMouseClicked

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
         try {
            readJTableBusca(txtBusca.getText());
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(TelaAlugarMangas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         
       
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void txtBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed

        TelaCadastroServico telacadastroservico = null;
        telacadastroservico = new TelaCadastroServico();
        telacadastroservico.setVisible(true);

        TelaAlugarMangas.this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void txtDuracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuracaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuracaoActionPerformed

    private void txtMangaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMangaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMangaActionPerformed

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoActionPerformed

    private void btnTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTabelaActionPerformed
         TelaTabelaInfos telatabelainfos = null;
         telatabelainfos = new TelaTabelaInfos();
        telatabelainfos.setVisible(true);
       
    }//GEN-LAST:event_btnTabelaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
        
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAlugarMangas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAlugarMangas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAlugarMangas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAlugarMangas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaAlugarMangas().setVisible(true);
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(TelaAlugarMangas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
     private void adicionar(){
                        
                        }
    
    //manga
     public void carregarFoto(){
        JFileChooser jfc =  new  JFileChooser();
        jfc.setDialogTitle("Selecionar arquivo");
        jfc.setFileFilter(new FileNameExtensionFilter("Arqivo de imagens (*.PNG,*.JPG,*JPEG)","png","jpg","jpeg"));    
        
        int resultado = jfc.showOpenDialog(this);
        
                       
        if (resultado == JFileChooser.APPROVE_OPTION) {
                            try{
                                fis = new FileInputStream(jfc.getSelectedFile());
                                tamanho = (int) jfc.getSelectedFile().length();
                                Image foto = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(lblFoto.getWidth(),lblFoto.getHeight(),Image.SCALE_SMOOTH);
                                imagePath = jfc.getSelectedFile().getAbsolutePath();
                                nomeImagem = jfc.getSelectedFile().getName();
                                
                                lblFoto.setIcon(new ImageIcon(foto));
                                lblFoto.updateUI();
                                
                            }catch (Exception e){
                                System.out.println(e);
                            }
                        }
            
  
     }
     
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnCarregar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTabela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JTable tblMangas;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtDuracao;
    private javax.swing.JTextField txtManga;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables

    

   
}
