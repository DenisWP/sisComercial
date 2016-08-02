package Classes;

public class Venda_has_Produto {
	private int Venda_idVenda;
	private int Produto_idProduto;
	private int qtdestoque;
	
	public int getVenda_idVenda() {
		return Venda_idVenda;
	}
	public void setVenda_idVenda(int venda_idVenda) {
		Venda_idVenda = venda_idVenda;
	}
	public int getProduto_idProduto() {
		return Produto_idProduto;
	}
	public void setProduto_idProduto(int produto_idProduto) {
		Produto_idProduto = produto_idProduto;
	}
	public int getQtdestoque() {
		return qtdestoque;
	}
	public void setQtdestoque(int qtdestoque) {
		this.qtdestoque = qtdestoque;
	}
}
