package dataBase;

public class DataBase {
	private static String schema;
	
	public DataBase(String schema) {
		DataBase.schema = schema;
	}

	public static String getSchema() {
		return schema;
	}
	public static void setSchema(String schema) {
		DataBase.schema = schema;
	}
}
