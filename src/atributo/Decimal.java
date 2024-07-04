package atributo;

public class Decimal extends TipoAtributo {
	
	public Decimal(int tamanho, int tamanho2) {
		this.setTipoAtributo("DECIMAL(" + tamanho + "," + tamanho2 + ")");
	}
}
