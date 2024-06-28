package view;

import conexao.Conexao;
import dataBase.DataBase;
import tabelas.*;
import tabelas.tipoAtributo.*;

public class Main {
	public static void main(String[] args) {
		DataBase db = new DataBase("banco");
		Conexao conexao = new Conexao("gian", "1234", "localhost", "3306");
		db.criaSchema(conexao);
		Atributo attr1 = new Atributo();
		TipoAtributo tipoAttr = new TipoAtributo();
		attr1.nomeAttr("id")
		.tipoAttr("varchar(45)")
		.tipoKey("primary key");
		Atributo attr2 = new Atributo();
		attr2.nomeAttr("nome")
		.tipoAttr("int");
		CriadorTabelas criador = new CriadorTabelas("teste", db);
		criador.criarTabela(conexao, attr1);
		criador.addColuna(conexao, attr2);
		
		
	}
}
