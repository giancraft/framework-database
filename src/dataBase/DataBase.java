package dataBase;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DataBase {
	private String schema;
	
	public DataBase(String schema) {
		this.schema = schema;
	}
	
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema;
	}

	public boolean criaSchema(Conexao conexao) {
		try {
			Connection conn = conexao.ex();
			String sql = "CREATE SCHEMA IF NOT EXISTS " + getSchema();
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
