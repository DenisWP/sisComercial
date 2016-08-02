package Telas;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import Classes.CargoFunc;
import DAO.CadCargoDAO;
import Model.CadCargoTableModel;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class CadCargoFunc extends Cadastro{
	 private JPanel pTable, pFuncoes;
	 private JTextField txtCargo, txtSalario;
	 private JTable table;
	 private JScrollPane sPane1;
	 private JLabel lblCargo, lblFuncoes, lblSalario, lblCargosCadastrados;
	 private JTextPane tpFuncoes;
	 public static CargoFunc c;
	 private List<CargoFunc> cargoList;
	 
	 public CadCargoFunc() throws SQLException{
		setTitle("Cadastro de Cargos");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img//dmr_icon.png"));
		
		lblCargosCadastrados = new JLabel("Cargos Cadastrados");
		lblCargosCadastrados.setBounds(30, 174, 200, 14);
		
		pTable = new JPanel();
		pTable.setBackground(new Color(220, 220, 220));
		pTable.setBounds(30, 120, 680, 270);
		pTable.setLayout(new MigLayout());
		
		lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(30, 11, 58, 21);
		
		txtCargo = new JTextField();
		txtCargo.setBounds(30, 31, 410, 20);
		txtCargo.setColumns(10);
		
		lblSalario = new JLabel("Salario");
		lblSalario.setBounds(479, 14, 46, 14);
		
		txtSalario = new JTextField();
		txtSalario.setBounds(479, 31, 232, 20);
		txtSalario.setColumns(10);
		
		lblFuncoes = new JLabel("Funcoes");
		lblFuncoes.setBounds(30, 62, 80, 14);
		
		pFuncoes = new JPanel();
		pFuncoes.setBorder(new LineBorder(new Color(0, 0, 0)));
		pFuncoes.setBackground(Color.WHITE);
		pFuncoes.setBounds(30, 81, 680, 82);
		pFuncoes.setLayout(null);
		
		tpFuncoes = new JTextPane();
		tpFuncoes.setBounds(10, 11, 661, 60);
		pFuncoes.add(tpFuncoes);
		
		sPane1 = new JScrollPane(pFuncoes);		
		
		C1.add(lblCargosCadastrados);
		C1.add(lblCargo);
		C1.add(lblSalario);
		C1.add(txtSalario);
		C1.add(txtCargo);
		C1.add(lblFuncoes);
		C1.add(pFuncoes);
		
		
		table = new JTable();
		sPane1 = new JScrollPane(table);
		pTable.setLocation(30, 200);
		pTable.add(sPane1,"width 665:300:1000");
		
		refreshTable();

		
		C1.add(pTable);		
		C1.setVisible(true);
		
		
		
		/**
		 * Implementando ações dos botões
		 */
			
			//"Salvar"
			B1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int id;
					try {
						String tc = txtCargo.getText();
						String ts = txtSalario.getText();
						String tf = tpFuncoes.getText();
						id = descobreID(); 
						System.out.println("ID: "+id);
						salvarOuEditar(id,tc,ts,tf);
						refreshTable();
						clearTxt();
				    } catch (SQLException e1) { 	  
				    	e1.printStackTrace();  
				      }  
				}
			});		
			
			//"Editar"
			B2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onEditar();
				}
			});
			
			//"Cancelar"
			B3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});		
			
			//"Excluir"
			B4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onRemove();
					try {
						refreshTable();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				}
			});
			
			//"Procurar"
			B5.setEnabled(false);
	
	}

	protected void onEditar() {
		int rowIndex = table.getSelectedRow();
		if (rowIndex == -1){
			JOptionPane.showMessageDialog(null, "Selecione o cargo a ser editado.");
			return;
		}
		
		c = new CadCargoTableModel(cargoList).get(rowIndex);
		c.setIdCargo(c.getIdCargo());
		txtCargo.setText(c.getCargo());
		String sal = String.valueOf(c.getSalario());
		txtSalario.setText(sal);
		tpFuncoes.setText(c.getFuncoes());

	}

	private void refreshTable() throws SQLException{
		 cargoList = new CadCargoDAO().findCargo();
		 if(cargoList !=null){
			 	table.setModel(new CadCargoTableModel(cargoList));
		 }

    } 
	 
	private void clearTxt(){
		txtCargo.setText("");
		txtSalario.setText("");
		tpFuncoes.setText("");
	}
	
	public void onRemove(){
		int rowIndex = table.getSelectedRow();
		if (rowIndex == -1){
			JOptionPane.showMessageDialog(null, "Selecione o caorgo a ser removid!");
			return;
		}
		
		CargoFunc c = new CadCargoTableModel(cargoList).get(rowIndex);
		int confirmar = JOptionPane.showConfirmDialog( null,"Deseja realmente excluir o cargo?", "Excluir",JOptionPane.YES_NO_OPTION); 
		
		if(confirmar != 0){
			return;
		}
		
		int id = c.getIdCargo();
		
		try {
			new CadCargoDAO().Excluir(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	protected void salvarOuEditar(int id, String tc, String ts, String tf) throws SQLException {
		CargoFunc cF = new CargoFunc();
		CadCargoDAO dao = new CadCargoDAO();
		if(dao.idCargoExiste(id)){
			//Editar
			cF.setIdCargo(id);
			cF.setCargo(tc);
			cF.setFuncoes(tf);
			float sal=Float.parseFloat(ts);
			cF.setSalario(sal);
			new CadCargoDAO().Editar(cF);
		} else{
			//Salvar
			float sal=Float.parseFloat(ts);
			cF.setSalario(sal);
			new CadCargoDAO().Salvar(tc, sal, tf, id);
		}
		
	}

	protected int descobreID() {
		try{
			int rowIndex = table.getSelectedRow();
			CargoFunc cF = new CadCargoTableModel(cargoList).get(rowIndex);
			int id = cF.getIdCargo();
			return id;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Erro DescobreID.");
		}
		return -1;
	}
	
	public void desabilitar(){
		txtCargo.setEnabled(false);
		txtSalario.setEnabled(false);
		tpFuncoes.setEnabled(false);
		B1.setEnabled(false);
		B2.setEnabled(false);
		B4.setEnabled(false);
		B5.setEnabled(false);
	}
	
	public void habilitar(){
		txtCargo.setEnabled(true);
		txtSalario.setEnabled(true);
		tpFuncoes.setEnabled(true);
		B1.setEnabled(true);
		B2.setEnabled(true);
		B4.setEnabled(true);
		//B5.setEnabled(true);
	}
	
	public static void main(String[] args) {
		CadCargoFunc c = null;
		try {
			c = new CadCargoFunc();
		} catch (HeadlessException | SQLException e) {
			e.printStackTrace();
		}
		c.setVisible(true);
	}
}
