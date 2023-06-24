/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author 42labinfo
 */
abstract class Pessoa {
    
    /* 
        public - visivel a qualquer classe do seu projeto
        private - só esta visivel aos objetos da própria classe. 
                    não pode ser acessado por outras classes.
        protected (protegida) - visvel a sua propria classe e aos filho(herença) 
    */
    //declar os atributos
    protected int id;
    protected String nome;
    protected String telefone;
    protected String email;
    protected String rg;
    protected String cpf;
    
    //definir os contrutores - ctrl + espaço

    public Pessoa() {
    }

    public Pessoa(int id, String nome, String telefone, String email, String rg, String cpf) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.rg = rg;
        this.cpf = cpf;
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }
    
    
    //getter and setter - alt + insert

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    
}
