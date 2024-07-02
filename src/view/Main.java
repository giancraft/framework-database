package view;

import conexao.Conexao;
import dataBase.DataBase;
import tabelas.*;

public class Main {
	public static void main(String[] args) {
		DataBase db = new DataBase("banco");
		
		Conexao conexao = Conexao.getInstance();
		conexao.usuario("gian")
		.senha("1234")
		.caminho("localhost")
		.porta(3306);
		
		db.criaSchema(conexao);
		
		Atributo attr1 = new Atributo();
		attr1.nomeAttr("id_teste")
		.inteiro(11)
		.primaryKey();
		
		Atributo attr2 = new Atributo();
		attr2.nomeAttr("nome")
		.varchar(15);
		
		Table criador = new Table("teste", db);
		criador.criarTabela(conexao, attr1);
		criador.addColuna(conexao, attr2);
		
		Atributo attr3 = new Atributo();
		attr3.nomeAttr("id_teste2")
		.inteiro(11)
		.primaryKey();
		
		Atributo attr4 = new Atributo();
		attr4.nomeAttr("id_teste")
		.inteiro(11)
		.foreignKey(criador.getNomeTabela());
		
		Table criador2 = new Table("teste2", db);
		criador2.criarTabela(conexao, attr3);
		criador2.addColuna(conexao, attr2);
		criador2.addFK(conexao, attr4);
		
		/*attr4.foreignKey(criador.getNomeTabela());
		criador2.addFK(conexao, attr4);*/
	}
}
