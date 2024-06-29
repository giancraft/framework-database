package tabelas.tipoAtributo;

public class TipoAtributo {
	public String varchar(int caracteres) {
		return "varchar(" + caracteres + ")";
	}
	
	public String inteiro() {
		return "int";
	}
	
	public String flutuante() {
		return "float";
	}
}
