package tabelas;

import conexao.Conexao;
import interfaces.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import atributo.*;

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
            e.printStackTrace();
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
			e.printStackTrace();
			return null;
		}
	}
	
	/*private boolean primaryKeyExists(Conexao conexao) throws Exception {
		Connection conn = Conexao.conectar(); 
        String sql = "SELECT COUNT(*) FROM information_schema.table_constraints "
                     + "WHERE table_schema = ? AND table_name = ? AND constraint_type = 'PRIMARY KEY'";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, DataBase.getSchema());
        ps.setString(2, getNomeTabela());
        ResultSet rs = ps.executeQuery();
        boolean exists = false;
        if (rs.next()) {
            exists = rs.getInt(1) > 0;
        }
        rs.close();
        ps.close();
        return exists;
    }*/
	
	/*public boolean removerPK(Conexao conexao) {
        try {
            if (primaryKeyExists(conexao)) {
            	Connection conn = Conexao.conectar(); 
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
    }*/
	
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
			e.printStackTrace();
			return null;
		}
	}
	
	/* private boolean foreignKeyExists(Conexao conexao, String fkName) throws Exception {
		 	Connection conn = Conexao.conectar(); 
	        String sql = "SELECT COUNT(*) FROM information_schema.table_constraints "
	                     + "WHERE table_schema = ? AND table_name = ? AND constraint_type = 'FOREIGN KEY' AND constraint_name = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, DataBase.getSchema());
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
	    }*/
	
	/*public boolean removerFK(Conexao conexao, ForeignKey fk) {
        try {
            if (foreignKeyExists(conexao, fk.getNome())) {
            	Connection conn = Conexao.conectar(); 
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
    }*/
	
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
			e.printStackTrace();
			return null;
		}
	}
}

