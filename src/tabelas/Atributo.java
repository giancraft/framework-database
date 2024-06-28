package tabelas;

import tabelas.tipoAtributo.*;

public class Atributo {
	private String nomeAttr;
	private String tipoAttr;
	private String tipoKey = "";
	
	public Atributo nomeAttr(String nomeAttr) {
		this.nomeAttr = nomeAttr;
		return this;
	}
	public Atributo tipoAttr(String tipoAttr) {
		this.tipoAttr = tipoAttr;
		return this;
	}
	public Atributo tipoKey(String tipoKey) {
		this.tipoKey = tipoKey;
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
	public void setTipoAttr(String tipoAttr) {
		this.tipoAttr = tipoAttr;
	}
	public String getTipoKey() {
		return tipoKey;
	}
	public void setTipoKey(String tipoKey) {
		this.tipoKey = tipoKey;
	}
	
	
}
