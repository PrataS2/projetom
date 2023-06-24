
package models;


public class Adm {
   private int id;
    private String login;
    private String senha;
    private String nivel;
    
    
    
    
     public Adm() {
        
    }
 
    public Adm(int id, String login,String senha, String nivel_acesso) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.nivel = nivel_acesso;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

     public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel_acesso) {
        this.nivel = nivel_acesso;
    }
        
    
    
    
}
