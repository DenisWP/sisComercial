package Classes;

public class Relatorio {

	private int tipo;
	public Relatorio(int tipo){
		this.tipo=tipo;
	}
	
	public Relatorio() {
		
	}

	public void geraRelatorio(int opcao){
		switch(opcao){
		         case 1: System.out.println("Gerar relatorio de Clientes");
		         		 break;
		         case 2: System.out.println("Gerar relatorio de Produtos");
		                 break;		         		 
		}
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
