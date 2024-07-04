package view;

import conexao.Conexao;
import dataBase.*;
import tabelas.*;
import atributo.*;
import java.util.List;
import java.util.ArrayList;

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
		//tabela2.criarFK("id_teste", "id_teste", "teste", "teste2");
		
		TableFactory tabelaAs = new TableFactory();
		List<String> lista = new ArrayList<>();
		lista.add("id_teste");
		lista.add("id_teste2");
		tabelaAs.criarTabela("teste_teste2", "id_teste", new Int(11));
		tabelaAs.criarColuna("teste_teste2", "id_teste2", new Int(11));
		tabelaAs.criarPKComposta("teste_teste2", lista);
		tabelaAs.criarFK("id_teste", "id_teste", "teste", "teste_teste2");
		tabelaAs.criarFK("id_teste2", "id_teste2", "teste2", "teste_teste2");
	}
}
