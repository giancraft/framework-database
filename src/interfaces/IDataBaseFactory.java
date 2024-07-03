package interfaces;

import dataBase.DataBase;

public interface IDataBaseFactory {
	public DataBase criarSchema(String nomeSchema);
	public boolean removerSchema(String nomeSchema);
}
