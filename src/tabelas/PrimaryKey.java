package tabelas;

public class PrimaryKey {
	String nome;
	String tabela;
	
	public PrimaryKey(String nome, String tabela) {
		this.nome = nome;
		this.tabela = tabela;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTabela() {
		return tabela;
	}
	public void setTabela(String tabela) {
		this.tabela = tabela;
	}
}
