package interfaces;

import atributo.*;
import tabelas.*;

public interface ITableFactory {
	public Table criarTabela(String nomeTabela, String nomeAttr, TipoAtributo tipoAttr);
	public Atributo criarColuna(String nomeTabela,String nomeAttr, TipoAtributo tipoAttr);
	public PrimaryKey criarPK(String nomeAttr, String nomeTabela);
	public ForeignKey criarFK(String nome, String nomeRef, String tabelaRef, String tabela);
}
