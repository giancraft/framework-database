package interfaces;

import tabelas.*;

public interface ITableFactory {
	public Table criarTabela(String nomeTabela, String nomeAttr, String tipoAttr, int sizeAttr);
	public Atributo criarColuna(String nomeTabela,String nomeAttr, String tipoAttr, int sizeAttr);
	public PrimaryKey criarPK(String nomeAttr, String nomeTabela);
	public ForeignKey criarFK(String nome, String nomeRef, String tabelaRef, String tabela);
}
