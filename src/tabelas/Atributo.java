package tabelas;

public class Atributo {
	private String nomeAttr;
	private String tipoAttr;
	private String tipoKey = "";
	
	public Atributo (String nomeAttr, String tipoAttr) {
		this.nomeAttr = nomeAttr;
		this.tipoAttr = tipoAttr;
	}
	
	public Atributo nomeAttr(String nome) {
		this.nomeAttr = nome;
		return this;
	}
	
	public Atributo varchar(int caracteres) {
		this.tipoAttr = "VARCHAR(" + caracteres + ")";
		return this;
	}
	
	public Atributo inteiro(int quantidade) {
		this.tipoAttr = "INT(" + quantidade + ")";
		return this;
	}
	
	public Atributo flutuante() {
		this.tipoAttr = "FLOAT";
		return this;
	}
	
	public Atributo decimal(int quantidade) {
		this.tipoAttr = "DECIMAL(" + quantidade + ")";
		return this;
	}
	
	public Atributo tipoDouble() {
		this.tipoAttr = "DOUBLE";
		return this;
	}
	
	public Atributo date() {
		this.tipoAttr = "DATE";
		return this;
	}
	
	public Atributo datetime() {
		this.tipoAttr = "DATETIME";
		return this;
	}
	
	public Atributo bit() {
		this.tipoAttr = "BIT";
		return this;
	}
	
	public Atributo bitmap() {
		this.tipoAttr = "BITMAP";
		return this;
	}
	
	public Atributo tipoEnum() {
		this.tipoAttr = "ENUM";
		return this;
	}
	
	public Atributo primaryKey() {
		this.tipoKey = "PRIMARY KEY";
		return this;
	}
	
	public Atributo foreignKey(String nomeTabela){
		this.tipoKey = "FOREIGN KEY(" + getNomeAttr() + ") REFERENCES " + nomeTabela + "(" + getNomeAttr() + ")";
		return this;
	}
	
	public String getNomeAttr() {
		return nomeAttr;
	}
	public void setNomeAttr(String nomeAttr) {
		this.nomeAttr = nomeAttr;
	}
	public String getTipoAttr() {
		return tipoAttr;
	}
	public String getTipoKey() {
		return tipoKey;
	}
}
