package Classes;

public class Produto_has_Compra {
	private int Produto_idProduto;
	private int Compra_idCompra;
	private int qtdestoque;
	
	public int getProduto_idProduto() {
		return Produto_idProduto;
	}
	public void setProduto_idProduto(int produto_idProduto) {
		Produto_idProduto = produto_idProduto;
	}
	public int getCompra_idCompra() {
		return Compra_idCompra;
	}
	public void setCompra_idCompra(int compra_idCompra) {
		Compra_idCompra = compra_idCompra;
	}
	public int getQtdestoque() {
		return qtdestoque;
	}
	public void setQtdestoque(int qtdestoque) {
		this.qtdestoque = qtdestoque;
	}
	
	
}
