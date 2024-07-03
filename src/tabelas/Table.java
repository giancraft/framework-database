package tabelas;

import conexao.Conexao;
import dataBase.DataBase;
import interfaces.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
	private boolean primaryKeyExists(Conexao conexao) throws Exception {
		Connection conn = conexao.conectar(db);
        String sql = "SELECT COUNT(*) FROM information_schema.table_constraints "
                     + "WHERE table_schema = ? AND table_name = ? AND constraint_type = 'PRIMARY KEY'";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, db.getSchema());
        ps.setString(2, getNomeTabela());
        ResultSet rs = ps.executeQuery();
        boolean exists = false;
        if (rs.next()) {
            exists = rs.getInt(1) > 0;
        }
        rs.close();
        ps.close();
        return exists;
    }
	
	public boolean removerPK(Conexao conexao) {
        try {
            if (primaryKeyExists(conexao)) {
            	Connection conn = conexao.conectar(db);
                String sql = "ALTER TABLE " + getNomeTabela() + " DROP PRIMARY KEY;";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.executeUpdate();
                ps.close();
                System.out.println(sql + "\n");
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
	public boolean addPK(Conexao conexao, PrimaryKey pk) {
		try {
			Connection conn = conexao.conectar(db);
			String sql = "ALTER TABLE " + pk.getTabela() + " ADD PRIMARY KEY (" + pk.getNome() + ");";
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
	
	 private boolean foreignKeyExists(Conexao conexao, String fkName) throws Exception {
         	Connection conn = conexao.conectar(db);
	        String sql = "SELECT COUNT(*) FROM information_schema.table_constraints "
	                     + "WHERE table_schema = ? AND table_name = ? AND constraint_type = 'FOREIGN KEY' AND constraint_name = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, db.getSchema());
	        ps.setString(2, getNomeTabela());
	        ps.setString(3, fkName);
	        ResultSet rs = ps.executeQuery();
	        boolean exists = false;
	        if (rs.next()) {
	            exists = rs.getInt(1) > 0;
	        }
	        rs.close();
	        ps.close();
	        return exists;
	    }
	
	public boolean removerFK(Conexao conexao, ForeignKey fk) {
        try {
            if (foreignKeyExists(conexao, fk.getNome())) {
            	Connection conn = conexao.conectar(db);
                String sql = "ALTER TABLE " + fk.getTabela() + " DROP FOREIGN KEY " + fk.getNome() + ";";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.executeUpdate();
                ps.close();
                System.out.println(sql + "\n");
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
	public boolean addFK(Conexao conexao, ForeignKey fk) {
		try {
			Connection conn = conexao.conectar(db);
			String sql = "ALTER TABLE " + fk.getTabela() + " ADD CONSTRAINT " + fk.getNome() + " FOREIGN KEY (" + fk.getNome() + ") REFERENCES " + fk.getTabelaReferencia() + "(" 
			+ fk.getNomeReferencia() + ");";
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
