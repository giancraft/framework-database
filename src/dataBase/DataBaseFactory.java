package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import conexao.Conexao;
import interfaces.IDataBaseFactory;

public class DataBaseFactory implements IDataBaseFactory{
	public DataBase criarSchema(String nomeSchema) {
		try {
			Connection conn = Conexao.conectarSemSchema();
			String sql = "CREATE SCHEMA IF NOT EXISTS " + nomeSchema;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
            ps.close();
            System.out.println(sql + "\n");
			return new DataBase(nomeSchema);
		} catch (Exception e) {
            e.printStackTrace();
            return null;
		}
	}
	
	public boolean removerSchema(String nomeSchema) {
		try {
			Connection conn = Conexao.conectarSemSchema();
			String sql = "DROP SCHEMA " + nomeSchema;
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
