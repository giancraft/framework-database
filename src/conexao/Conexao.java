package conexao;

import java.sql.Connection;
import interfaces.*;
import java.sql.DriverManager;

import dataBase.DataBase;

public class Conexao implements IConnection{
	private static String usuario = "root";
	private static String senha = "";
	private static String caminho = "localhost";
	private static int porta = 3306;
	private static Conexao conn;
	
	private Conexao() {
		
	}
	
	public static Conexao getInstance() {
		if (conn == null)
			conn = new Conexao();
		return conn;
	}
	
	public Conexao usuario(String user) {
		Conexao.usuario = user;
		return conn;
	}
	
	public Conexao senha(String senha) {
		Conexao.senha = senha;
		return conn;
	}
	
	public Conexao caminho(String caminho) {
		Conexao.caminho = caminho;
		return conn;
	}
	
	public Conexao porta(int porta) {
		Conexao.porta = porta;
		return conn;
	}
	
	public static String getUsuario() {
		return usuario;
	}
	public static void setUsuario(String usuario) {
		Conexao.usuario = usuario;
	}
	public static String getSenha() {
		return senha;
	}
	public static void setSenha(String senha) {
		Conexao.senha = senha;
	}
	public static String getCaminho() {
		return caminho;
	}
	public static void setCaminho(String caminho) {
		Conexao.caminho = caminho;
	}
	public static int getPorta() {
		return porta;
	}
	public static void setPorta(int porta) {
		Conexao.porta = porta;
	}
	public static Conexao getConn() {
		return conn;
	}
	public static void setConn(Conexao conn) {
		Conexao.conn = conn;
	}

	public static Connection conectarSemSchema() {
		try {
			String url = "jdbc:mysql://" + getCaminho() + ":" + getPorta();
			return DriverManager.getConnection(url,getUsuario(),getSenha());
		} catch (Exception e) {
        	System.out.println("Erro: " + e.toString());
            return null;
        }
	}
	
	public static Connection conectar() {
    	try {
    		//Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + getCaminho() + ":" + getPorta() + "/" + DataBase.getNome();
            return DriverManager.getConnection(url,getUsuario(),getSenha());
        } catch (Exception e) {
        	System.out.println("Erro: " + e.toString());
            return null;
        }
    }
}
