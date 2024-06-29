package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

import dataBase.DataBase;

public class Conexao {
	private String usuario = "root";
	private String senha = "";
	private String caminho = "localhost";
	private int porta = 3306;
	private static Conexao conn;
    
	private Conexao() {
		
	}
	
	public static Conexao getInstance() {
		if (conn == null)
			conn = new Conexao();
		return conn;
	}
	
	public Conexao usuario(String user) {
		this.usuario = user;
		return this;
	}
	public Conexao senha(String senha) {
		this.senha = senha;
		return this;
	}
	public Conexao caminho(String caminho) {
		this.caminho = caminho;
		return this;
	}
	public Conexao porta (int porta) {
		this.porta = porta;
		return this;
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
	public int getPorta() {
		return porta;
	}
	public void setPorta(int porta) {
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
