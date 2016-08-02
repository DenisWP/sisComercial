package Classes;

public class Funcionario {

	private int idFuncionario;
	private String CPF;
	private String nome;
	private String rg;
	private String obs;
	private String horariotrab;
	private String usuario;
	private String senha;
	private int nivel;
	private int Endereco_idEndereco; 
	private int Telefone_idTelefone; 
	private int Login_idLogin;	
	private int Cargo_idCargo;
	
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

	public int getLogin_idLogin() {
		return Login_idLogin;
	}

	public void setLogin_idLogin(int login_idLogin) {
		Login_idLogin = login_idLogin;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getHorariotrab() {
		return horariotrab;
	}

	public void setHorariotrab(String horariotrab) {
		this.horariotrab = horariotrab;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public int getCargo_idCargo() {
		return Cargo_idCargo;
	}

	public void setCargo_idCargo(int cargo_idCargo) {
		Cargo_idCargo = cargo_idCargo;
	}
}
