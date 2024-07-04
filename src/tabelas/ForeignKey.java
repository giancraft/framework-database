package tabelas;

public class ForeignKey {
	private String nome;
	private String nomeReferencia;
	private String tabelaReferencia;
	private String tabela;
	
	public ForeignKey(String nome, String nomeRef, String tabelaRef, String tabela) {
		this.nome = nome;
		this.nomeReferencia = nomeRef;
		this.tabelaReferencia = tabelaRef;
		this.tabela = tabela;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeReferencia() {
		return nomeReferencia;
	}
	public void setNomeReferencia(String nomeReferencia) {
		this.nomeReferencia = nomeReferencia;
	}
	public String getTabelaReferencia() {
		return tabelaReferencia;
	}
	public void setTabelaReferencia(String tabelaReferencia) {
		this.tabelaReferencia = tabelaReferencia;
	}
	public String getTabela() {
		return tabela;
	}
	public void setTabela(String tabela) {
		this.tabela = tabela;
	}
	
	
}
