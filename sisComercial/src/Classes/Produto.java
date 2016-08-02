package Classes;

public class Produto {

	private int idProduto;
	private String nome;
	private String valoruni;	
	private int qtdestoque;
	private int Categoria_idCategoria;
	
	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getQtdestoque() {
		return qtdestoque;
	}

	public void setQtdestoque(int qtdestoque) {
		this.qtdestoque = qtdestoque;
	}

	public int getCategoria_idCategoria() {
		return Categoria_idCategoria;
	}

	public void setCategoria_idCategoria(int categoria_idCategoria) {
		Categoria_idCategoria = categoria_idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValoruni() {
		return valoruni;
	}

	public void setValoruni(String vu) {
		this.valoruni = vu;
	}

}
