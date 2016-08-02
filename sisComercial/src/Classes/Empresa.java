package Classes;

public class Empresa {
	
	private String CNPJ, inscEst, rSocial, nFantasia, rua, bairro, num, cidade, estado, tel, comercial;
	
	public Empresa(String CNPJ, String inscEst, String rSocial, String nFantasia, String rua, String bairro, 
			       String cidade, String num, String estado, String tel, String comercial) {

		this.CNPJ=CNPJ;
		this.inscEst=inscEst;
		this.rSocial=rSocial;
		this.nFantasia=nFantasia;
		this.rua=rua;
		this.bairro=bairro;
		this.cidade=cidade;
		this.num=num;
		this.estado=estado;
		this.tel=tel;
		this.comercial=comercial;	
	} 

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getInscEst() {
		return inscEst;
	}

	public void setInscEst(String inscEst) {
		this.inscEst = inscEst;
	}

	public String getrSocial() {
		return rSocial;
	}

	public void setrSocial(String rSocial) {
		this.rSocial = rSocial;
	}

	public String getnFantasia() {
		return nFantasia;
	}

	public void setnFantasia(String nFantasia) {
		this.nFantasia = nFantasia;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getComercial() {
		return comercial;
	}

	public void setComercial(String comercial) {
		this.comercial = comercial;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
	

}
