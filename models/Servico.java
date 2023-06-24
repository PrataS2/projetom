/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Brunin
 */
public class Servico {
    private int id;
    private String Usuario;
    private String Email;
    private String Manga;
    private Float Preco;
    
      public Servico() {
        
    }
 
    public Servico(int id, String usuario,String email, String manga, Float preco) {
        this.id = id;
        this.Usuario = usuario;
    this.Email = email;
    this.Manga = manga;
    this.Preco = preco;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getManga() {
        return Manga;
    }

    public void setManga(String Manga) {
        this.Manga = Manga;
    }
    
     public Float getPreco() {
        return Preco;
    }

    public void setPreco(Float Preco) {
        this.Preco = Preco;
    }
    
}
