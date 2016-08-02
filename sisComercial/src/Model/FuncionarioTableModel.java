package Model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Classes.Funcionario;

@SuppressWarnings("serial")
public class FuncionarioTableModel extends AbstractTableModel{

	//idFuncionario, CPF, nome, rg, obs, Endereco_idEndereco, 
	//horariotrab, Telefone_idTelefone, usuario, senha, nivel, Cargo_idCargo
	
	private static final int COL_ID=0;
	private static final int COL_CPF=1;
	private static final int COL_NOME=2;
	private static final int COL_RG=3;
	private static final int COL_OBS=4;
	private static final int COL_IDEND=5;
	private static final int COL_HORA=6;
	private static final int COL_IDTEL=7;
	private static final int COL_USER=8;
	private static final int COL_PASS=9;
	private static final int COL_NIVEL=10;
	private static final int COL_IDCARGO=11;

	private List<Funcionario> funcionario;
	
	//Construtor
	public FuncionarioTableModel(List<Funcionario> funcionario){
		this.funcionario=funcionario;
	}

	//Numero de Colunas
	public int getColumnCount() {
		return 12;
	}
	
	//Numero de linhas
	public int getRowCount() {
		return funcionario.size();
	}
	
	//Definir Valores
	public Object getValueAt(int rowIndex, int columnIndex){
		Funcionario func = funcionario.get(rowIndex);
		if(columnIndex==COL_ID){
			return func.getIdFuncionario();
		} else if(columnIndex == COL_CPF){
			return func.getCPF();
		} else if(columnIndex == COL_NOME){
			return func.getNome();
		} else if(columnIndex == COL_RG){
			return func.getRg();
		}else if(columnIndex == COL_OBS){
			return func.getObs();
		}else if(columnIndex == COL_IDEND){
			return func.getEndereco_idEndereco();
		}else if(columnIndex == COL_HORA){
			return func.getHorariotrab();
		}else if(columnIndex == COL_IDTEL){
			return func.getTelefone_idTelefone();
		}else if(columnIndex == COL_USER){
			return func.getUsuario();
		}else if(columnIndex == COL_PASS){
			return func.getSenha();
		}else if(columnIndex == COL_NIVEL){
			return func.getNivel();
		}else if(columnIndex == COL_IDCARGO){
			return func.getCargo_idCargo();
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
			case COL_CPF:
				coluna="CPF";
				break;
			case COL_NOME:
				coluna="Nome";
				break;
			case COL_RG:
				coluna="RG";
				break;
			case COL_OBS:
				coluna="Observação";
				break;
			case COL_IDEND:
				coluna="FK END";
				break;
			case COL_HORA:
				coluna="Horario Trab";
				break;
			case COL_IDTEL:
				coluna="FK TEL";
				break;
			case COL_USER:
				coluna="Usuario";
				break;
			case COL_PASS:
				coluna="Senha";
				break;
			case COL_NIVEL:
				coluna="Nível";
				break;
			case COL_IDCARGO:
				coluna="FK CARGO";
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
		} else if(columnIndex == COL_CPF){
			return String.class;
		} else if(columnIndex == COL_NOME){
			return String.class;
		} else if(columnIndex == COL_RG){
			return String.class;
		}else if(columnIndex == COL_OBS){
			return String.class;
		}else if(columnIndex == COL_IDEND){
			return int.class;
		}else if(columnIndex == COL_HORA){
			return String.class;
		}else if(columnIndex == COL_IDTEL){
			return int.class;
		}else if(columnIndex == COL_USER){
			return String.class;
		}else if(columnIndex == COL_PASS){
			return String.class;
		}else if(columnIndex == COL_NIVEL){
			return int.class;
		}else if(columnIndex == COL_IDCARGO){
			return int.class;
		}
		return null;
	}
	
	//Setar qual linha esta selecionada
	public Funcionario get(int row){
		return funcionario.get(row);
	}
	
	
}
