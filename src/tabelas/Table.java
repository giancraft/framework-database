package tabelas;

import conexao.Conexao;
import dataBase.DataBase;
import interfaces.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Table implements ITable{
	private String nomeTabela;
	private DataBase db;
	
	public Table(String nomeTabela, DataBase db) {
		this.nomeTabela = nomeTabela;
		this.db = db;
	}
	
	public String getNomeTabela() {
		return nomeTabela;
	}
	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}
	public DataBase getDb() {
		return db;
	}
	public void setDb(DataBase db) {
		this.db = db;
	}

	public boolean criarTabela(Conexao conexao, Atributo attr) {
		try {
			Connection conn = conexao.conectar(db);  
			if (conn.isClosed()) {
				System.out.println("n conectou");
			}
			String sql = "CREATE TABLE IF NOT EXISTS " + getNomeTabela() + " (" + attr.getNomeAttr() + " " + attr.getTipoAttr()
			+ " " + attr.getTipoKey() + ");";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
            ps.close();
            System.out.println(sql + "\n");
			return true;
		} catch (Exception e) {
            e.printStackTrace();
            return false;
		}
	}
	
	public boolean addColuna(Conexao conexao, Atributo attr) {
		try {
			Connection conn = conexao.conectar(db);
			String sql = "ALTER TABLE " + getNomeTabela() + " ADD COLUMN IF NOT EXISTS " + attr.getNomeAttr() + " " 
			+ attr.getTipoAttr() + " " + attr.getTipoKey();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
            ps.close();
            System.out.println(sql + "\n");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addFK(Conexao conexao, Atributo attr, ForeignKey fk) {
		try {
			Connection conn = conexao.conectar(db);
			String sql = "ALTER TABLE " + fk.getTabela() + " ADD CONSTRAINT " + fk.getNome() + " FOREIGN KEY (" + fk.getNomeReferencia() + ") REFERENCES " + fk.getTabelaReferencia() + "(";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
            ps.close();
            System.out.println(sql + "\n");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
