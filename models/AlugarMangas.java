/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author 42labinfo
 */
public class AlugarMangas {

    
    
     private int id;
     private String nome;
     private String manga;
     private String duracao;
     private Float preco;
    private String foto;

    public AlugarMangas() {
        
    }

    public AlugarMangas(int id, String nome, String manga, String duracao,Float preco, String foto) {
        this.id = id;
        this.nome = nome;
        this.manga = manga;
        this.duracao = duracao;
        this.preco = preco;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   
     public String getManga() {
        return manga;
    }

    public void setManga(String manga) {
        this.manga = manga;
    }
    

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
    
    
     public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }
    
    
     public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


         
      
    
    
}

