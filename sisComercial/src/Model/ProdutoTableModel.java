package Model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Classes.Produto;

@SuppressWarnings("serial")
public class ProdutoTableModel extends AbstractTableModel{
	private static final int COL_ID=0;
	private static final int COL_NO=1;
	private static final int COL_VU=2;
	private static final int COL_QE=3;
	private static final int COL_CAT=4;


	private List<Produto> produto;
	
	//Construtor
	public ProdutoTableModel(List<Produto> produto){
		this.produto=produto;
	}

	//Numero de Colunas
	public int getColumnCount() {
		return 5;
	}
	
	//Numero de linhas
	public int getRowCount() {
		return produto.size();
	}
	
	//Definir Valores
	public Object getValueAt(int rowIndex, int columnIndex){
		Produto prod = produto.get(rowIndex);
		if(columnIndex==COL_ID){
			return prod.getIdProduto();
		} else if(columnIndex == COL_NO){
			return prod.getNome();
		} else if(columnIndex == COL_VU){
			return prod.getValoruni();
		} else if(columnIndex == COL_QE){
			return prod.getQtdestoque();
		} else if(columnIndex == COL_CAT){
			return prod.getCategoria_idCategoria();
		} 
		return null;
	}
	
	//Nomear colunas
	public String getColumnName(int column){ 
		String coluna ="";
		switch(column){
			case COL_ID:
				coluna = "Código";
				break;
			case COL_NO:
				coluna="Nome";
				break;
			case COL_VU:
				coluna="Valor Unitário";
				break;
			case COL_QE:
				coluna="Qtd Estoque";
				break;
			case COL_CAT:
				coluna="Categoria";
				break;
			default:
				throw new IllegalArgumentException("Coluna inexistente!");
		}	
		return coluna;
	}
	
	//Tipo de dados da Coluna
	public Class<?> getColumnClass(int columnIndex){
		if(columnIndex == COL_ID){
			return int.class;
		} else if(columnIndex == COL_NO){
			return String.class;
		} else if(columnIndex == COL_VU){
			return String.class;
		} else if(columnIndex == COL_QE){
			return int.class;
		}  else if(columnIndex == COL_CAT){
			return int.class;
		} 
		return null;
	}
	
	//Setar qual linha esta selecionada
	public Produto get(int row){
		return produto.get(row);
	}
}
