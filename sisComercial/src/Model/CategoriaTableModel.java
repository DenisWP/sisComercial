package Model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Classes.Categoria;

@SuppressWarnings("serial")
public class CategoriaTableModel extends AbstractTableModel{

	private static final int COL_ID=0;
	private static final int COL_CAT=1;
	private static final int COL_DESC=2;

	private List<Categoria> categoria;
	
	//Construtor
	public CategoriaTableModel(List<Categoria> categoria){
		this.categoria=categoria;
	}

	//Numero de Colunas
	public int getColumnCount() {
		return 3;
	}
	
	//Numero de linhas
	public int getRowCount() {
		return categoria.size();
	}
	
	//Definir Valores
	public Object getValueAt(int rowIndex, int columnIndex){
		Categoria categ = categoria.get(rowIndex);
		if(columnIndex==COL_ID){
			return categ.getIdCategoria();
		} else if(columnIndex == COL_CAT){
			return categ.getNomeCategoria();
		} else if(columnIndex == COL_DESC){
			return categ.getDescricao();
		}
		return null;
	}
	
	//Nomear colunas
	public String getColumnName(int column){ 
		String coluna = "";
		switch(column){
			case COL_ID:
				coluna = "Código";
				break;
			case COL_CAT:
				coluna="Categoria";
				break;
			case COL_DESC:
				coluna="Descrição";
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
		} else if(columnIndex == COL_CAT){
			return String.class;
		} else if(columnIndex == COL_DESC){
			return String.class;
		}
		return null;
	}
	
	//Setar qual linha esta selecionada
	public Categoria get(int row){
		return categoria.get(row);
	}
	
}
