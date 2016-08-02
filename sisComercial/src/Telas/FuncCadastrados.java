package Telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class FuncCadastrados extends Cadastro {

	JLabel lblFunc;
	JPanel pTable;
	JTable table;
	JScrollPane scrollPane;
	
	 public FuncCadastrados(){
		setTitle("Funcionários Cadastrados");
		//veficando o tamanho da tela e dimensionando;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension scrnsize = toolkit.getScreenSize();
		int width = (int)scrnsize.getWidth();  
		int heigth = (int)scrnsize.getHeight(); 
		setBounds((width-750)/2,(heigth-600)/2,750,600);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img//dmr_icon.png"));
		C1.setLayout(null);
		
		lblFunc = new JLabel("Funcionarios Cadastrados");
		lblFunc.setBounds(10, 25, 170, 14);
		C1.add(lblFunc);
		
		pTable = new JPanel(new MigLayout());
		pTable.setBackground(new Color(240, 240, 240));
		pTable.setBounds(10, 50, 725, 445);
		
		table = new JTable();
		scrollPane = new JScrollPane(table);
		pTable.add(scrollPane,"width 710:445:2000");		
		
		C1.add(pTable);
		C1.setVisible(true);
		
		
		/**
		 * Implementando ações dos botões
		 */
			
//			//"Salvar"
//			B1.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					try {
//						int id=c.getIdCategoria();
//						String tc = txtCat.getText();
//						String td = txtDesc.getText();
//						CadCategoriaDAO cDAO = new CadCategoriaDAO();  
//						cDAO.Salvar(tc,td,id);  
//						refreshTable();
//						clearTxt();
//				    } catch (SQLException e1) { 	  
//				    	e1.printStackTrace();  
//				    	}  
//					
//				}
//			});		
//			
//			//"Editar"
//			B2.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					onEditar();
//				}
//			});
//			
//			//"Cancelar"
//			B3.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					dispose();
//				}
//			});		
//			
//			//"Excluir"
//			B4.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					onRemove();
//					try {
//						refreshTable();
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//
//				}
//			});
//			
//			//"Procurar"
//			B5.setEnabled(false);
		
	 }
	 
	 
		public static void main(String[] args) {
			FuncCadastrados func = null;
			func = new FuncCadastrados();
			func.setVisible(true);

		}	
		
	}
	
