package atributo;

public class Atributo {
	private String nomeAttr;
	private TipoAtributo tipoAttr;
	
	public Atributo (String nomeAttr, TipoAtributo tipoAttr) {
		this.nomeAttr = nomeAttr;
		this.tipoAttr = tipoAttr;
	}
	
	public String getNomeAttr() {
		return nomeAttr;
	}
	public void setNomeAttr(String nomeAttr) {
		this.nomeAttr = nomeAttr;
	}
	public TipoAtributo getTipoAttr() {
		return tipoAttr;
	}
}
