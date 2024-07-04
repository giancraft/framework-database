package dataBase;

public class DataBase {
	private static String nome;
	
	public DataBase(String nome) {
		DataBase.nome = nome;
	}

	public static String getNome() {
		return nome;
	}
	public static void setNome(String schema) {
		DataBase.nome = schema;
	}
}
