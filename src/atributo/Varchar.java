package atributo;

public class Varchar extends TipoAtributo {
	
	public Varchar(int tamanho) {
		this.setTipoAtributo("VARCHAR(" + tamanho + ")");
	}
}
