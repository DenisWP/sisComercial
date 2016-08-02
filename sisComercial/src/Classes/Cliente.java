package Classes;

public class Cliente {
	private int idCliente;
	private static String nome;
	private static String obs;
	private int Endereco_idEndereco;
	private int Telefone_idTelefone;
	
	public String getNome() {
		return nome;
	}

	@SuppressWarnings("static-access")
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObs() {
		return obs;
	}

	@SuppressWarnings("static-access")
	public void setObs(String obs) {
		this.obs = obs;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getEndereco_idEndereco() {
		return Endereco_idEndereco;
	}

	public void setEndereco_idEndereco(int endereco_idEndereco) {
		Endereco_idEndereco = endereco_idEndereco;
	}

	public int getTelefone_idTelefone() {
		return Telefone_idTelefone;
	}

	public void setTelefone_idTelefone(int telefone_idTelefone) {
		Telefone_idTelefone = telefone_idTelefone;
	}
	
}
