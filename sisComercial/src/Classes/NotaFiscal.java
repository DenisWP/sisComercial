package Classes;

public class NotaFiscal {

	private String CNPJ;
	Cliente c;
	Produto p;
	
	public NotaFiscal(Cliente c, Produto p, String cnpj){
		this.c=c;
		this.p=p;
		this.CNPJ=cnpj;	
	}
	
	public NotaFiscal(){
		
	}
	
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

}
