package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

import dataBase.DataBase;

public class Conexao {
	private String usuario;
	private String senha;
	private String caminho;
	private String porta;
    
	public Conexao (String usuario, String senha, String caminho, String porta) {
		this.usuario = usuario;
		this.senha = senha;
		this.caminho = caminho;
		this.porta = porta;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	public String getPorta() {
		return porta;
	}
	public void setPorta(String porta) {
		this.porta = porta;
	}
	
	public Connection ex() {
		try {
			String url = "jdbc:mysql://" + getCaminho() + ":" + getPorta();
			return DriverManager.getConnection(url,getUsuario(),getSenha());
		} catch (Exception e) {
        	System.out.println("Erro: " + e.toString());
        	e.printStackTrace();
            return null;
        }
	}
	
	public Connection conectar(DataBase db) {
    	try {
    		//Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + getCaminho() + ":" + getPorta() + "/" + db.getSchema();
            return DriverManager.getConnection(url,getUsuario(),getSenha());
        } catch (Exception e) {
        	System.out.println("Erro: " + e.toString());
        	e.printStackTrace();
            return null;
        }
    }
}
