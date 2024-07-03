package interfaces;

import conexao.Conexao;
import tabelas.*;

public interface ITable {
	public boolean criarTabela(Conexao conn, Atributo attr);
	public boolean addColuna(Conexao conn, Atributo attr);
	public boolean addPK(Conexao conn, PrimaryKey pk);
	public boolean addFK(Conexao conn, ForeignKey fk);
}
