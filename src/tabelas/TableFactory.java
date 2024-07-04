package tabelas;

import conexao.Conexao;
import interfaces.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import atributo.*;
import java.util.List;

public class TableFactory implements ITableFactory{
	
	public Table criarTabela(String nomeTabela, String nomeAttr, TipoAtributo tipoAttr) {
		try {
			Connection conn = Conexao.conectar();  
			if (conn.isClosed()) {
				System.out.println("n conectou");
			}
			String sql = "CREATE TABLE IF NOT EXISTS " + nomeTabela + " (" + nomeAttr + " " + tipoAttr.getTipoAtributo() 
			+ ");";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
            ps.close();
            System.out.println(sql + "\n");
			return new Table(nomeTabela);
		} catch (Exception e) {
			System.out.println("Erro: " + e.toString());
            return null;
		}
	}
	
	public Atributo criarColuna(String nomeTabela, String nomeAttr, TipoAtributo tipoAttr) {
		try {
			Connection conn = Conexao.conectar(); 
			String sql = "ALTER TABLE " + nomeTabela + " ADD COLUMN IF NOT EXISTS " + nomeAttr + " " 
			+ tipoAttr.getTipoAtributo() + ";";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
            ps.close();
            System.out.println(sql + "\n");
			return new Atributo(nomeAttr, tipoAttr);
		} catch (Exception e) {
			System.out.println("Erro: " + e.toString());
			return null;
		}
	}
	
	public PrimaryKey criarPK(String nomeAttr, String nomeTabela) {
		try {
			Connection conn = Conexao.conectar(); 
			String sql = "ALTER TABLE " + nomeTabela + " ADD PRIMARY KEY (" + nomeAttr + ");";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
            ps.close();
            System.out.println(sql + "\n");
			return new PrimaryKey(nomeAttr, nomeTabela);
		} catch (Exception e) {
			System.out.println("Erro: " + e.toString());
			return null;
		}
	}
	
	public boolean criarPKComposta(String nomeTabela, List<String>pkColunas) {
		try {
			Connection conn = Conexao.conectar();
			  StringBuilder sql = new StringBuilder("ALTER TABLE " + nomeTabela + " ADD PRIMARY KEY (");
	            for (int i = 0; i < pkColunas.size(); i++) {
	                sql.append(pkColunas.get(i));
	                if (i < pkColunas.size() - 1) {
	                    sql.append(", ");
	                }
	            }
	            sql.append(");");
	            PreparedStatement ps = conn.prepareStatement(sql.toString());
	            ps.executeUpdate();
	            ps.close();
	            System.out.println(sql + "\n");
			return true;
		} catch (Exception e) {
			System.out.println("Erro: " + e.toString());
			return false;
		}
	}
	
	public ForeignKey criarFK(String nome, String nomeRef, String tabelaRef, String tabela) {
		try {
			Connection conn = Conexao.conectar(); 
			String sql = "ALTER TABLE " + tabela + " ADD CONSTRAINT " + nome + " FOREIGN KEY (" + nome + ") REFERENCES " 
			+ tabelaRef + "(" + nomeRef + ");";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
            ps.close();
            System.out.println(sql + "\n");
			return new ForeignKey(nome, nomeRef, tabelaRef, tabela);
		} catch (Exception e) {
			System.out.println("Erro: " + e.toString());
			return null;
		}
	}
	
	public boolean removerTabela(String nomeTabela) {
		try {
			Connection conn = Conexao.conectar(); 
			String sql = "DROP TABLE IF EXISTS " + nomeTabela + ";";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
            ps.close();
            System.out.println(sql + "\n");
			return true;
		} catch (Exception e) {
			System.out.println("Erro: " + e.toString());
			return false;
		}
	}
}

