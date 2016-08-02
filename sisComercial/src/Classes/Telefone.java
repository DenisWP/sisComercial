package Classes;

public class Telefone {
	private int idTelefone;
	String fixo;
	String cel;
	
	public Telefone(String fixo, String cel) {
		this.fixo=fixo;
		this.cel=cel;
	}
	
	public Telefone() {

	}

	public String getFixo() {
		return fixo;
	}

	public void setFixo(String fixo) {
		this.fixo = fixo;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public int getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}

}
