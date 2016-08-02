package Model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Classes.CargoFunc;

@SuppressWarnings("serial")
public class CadCargoTableModel extends AbstractTableModel{

	private static final int COL_ID=0;
	private static final int COL_CAR=1;
	private static final int COL_FUNC=2;
	private static final int COL_SAL=3;

	private List<CargoFunc> cargo;
	
	//Construtor
	public CadCargoTableModel(List<CargoFunc> cargoList){
		this.cargo=cargoList;
	}

	//Numero de Colunas
	public int getColumnCount() {
		return 4;
	}
	
	//Numero de linhas
	public int getRowCount() {
		return cargo.size();
	}
	
	//Definir Valores
	public Object getValueAt(int rowIndex, int columnIndex){
		CargoFunc cargoF = cargo.get(rowIndex);
		if(columnIndex==COL_ID){
			return cargoF.getIdCargo();
		} else if(columnIndex == COL_CAR){
			return cargoF.getCargo();
		} else if(columnIndex == COL_FUNC){
			return cargoF.getFuncoes();
		} else if(columnIndex == COL_SAL){
			return cargoF.getSalario();
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
			case COL_CAR:
				coluna = "Cargo";
				break;
			case COL_FUNC:
				coluna = "Funções";
				break;
			case COL_SAL:
				coluna = "Salário";
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
		} else if(columnIndex == COL_CAR){
			return String.class;
		} else if(columnIndex == COL_FUNC){
			return String.class;
		} else if(columnIndex == COL_SAL){
			return Float.class;
		}
		return null;
	}
	
	//Setar qual linha esta selecionada
	public CargoFunc get(int row){
		return cargo.get(row);
	}
	
}
