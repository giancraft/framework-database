package view;

import conexao.Conexao;
import dataBase.*;
import tabelas.*;
import atributo.*;

public class Main {
	public static void main(String[] args) {
		Conexao conexao = Conexao.getInstance();
		conexao.usuario("gian")
		.senha("1234")
		.caminho("localhost")
		.porta(3306);
		DataBaseFactory db = new DataBaseFactory();
		db.removerSchema("banco");
		db.criarSchema("banco");
		TableFactory tabela1 = new TableFactory();
		tabela1.criarTabela("teste", "id_teste", new Int(11));
		tabela1.criarColuna("teste", "nome", new Varchar(15));
		tabela1.criarColuna("teste", "preco", new Decimal(11,11));
		tabela1.criarPK("id_teste", "teste");
		
		TableFactory tabela2 = new TableFactory();
		tabela2.criarTabela("teste2", "id_teste2", new Int(11));
		tabela2.criarColuna("teste2", "nome", new Varchar(15));
		tabela2.criarColuna("teste2", "id_teste", new Int(11));
		tabela2.criarPK("id_teste2", "teste2");
		tabela2.criarFK("id_teste", "id_teste", "teste", "teste2");
		
		
		
		
		
		
		
		/*DataBase db = new DataBase("banco");
		
		Conexao conexao = Conexao.getInstance();
		conexao.usuario("gian")
		.senha("1234")
		.caminho("localhost")
		.porta(3306);
		
		db.criaSchema(conexao);
		
		Atributo attr1 = new Atributo();
		attr1.nomeAttr("id_teste")
		.inteiro(11);
		
		Atributo attr2 = new Atributo();
		attr2.nomeAttr("nome")
		.varchar(15);
		
		Table criador = new Table("teste", db);
		PrimaryKey pk1 = new PrimaryKey(attr1.getNomeAttr(), criador.getNomeTabela());
		criador.criarTabela(conexao, attr1);
		criador.criarColuna(conexao, attr2);
		criador.removerPK(conexao);
		criador.criarPK(conexao, pk1);
		
		Atributo attr3 = new Atributo();
		attr3.nomeAttr("id_teste2")
		.inteiro(11);
		
		Atributo attr4 = new Atributo();
		attr4.nomeAttr("id_teste")
		.inteiro(11);
		
		Table criador2 = new Table("teste2", db);
		PrimaryKey pk2 = new PrimaryKey(attr3.getNomeAttr(), criador2.getNomeTabela());
		ForeignKey fk1 = new ForeignKey(attr4.getNomeAttr(), attr1.getNomeAttr(), criador.getNomeTabela(), criador2.getNomeTabela());
		criador2.criarTabela(conexao, attr3);
		criador2.criarColuna(conexao, attr2);
		criador2.criarColuna(conexao, attr4);
		criador2.removerPK(conexao);
		criador2.removerFK(conexao, fk1);
		criador2.criarPK(conexao, pk2);
		criador2.criarFK(conexao, fk1);
		
		/*attr4.foreignKey(criador.getNomeTabela());
		criador2.addFK(conexao, attr4);*/
	}
}
