package Classes;

public class Login {
	
	private int idLogin;
	public String usuario;
	public String senha;
	public int nivel;
	
	public Login(String usuario, String senha, int nivel){
		this.usuario=usuario;
		this.senha=senha;		
		this.nivel=nivel;
	}
	
	public Login() {
	
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
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

	public int getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

}
