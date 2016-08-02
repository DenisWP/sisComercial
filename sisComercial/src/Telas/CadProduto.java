package Telas;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mysql.jdbc.Statement;

import BD.ConexaoBD;
import Classes.Produto;
import DAO.CadCategoriaDAO;
import DAO.CadProdutoDAO;
import Model.CategoriaTableModel;
import Model.ProdutoTableModel;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class CadProduto extends Cadastro{
	@SuppressWarnings("rawtypes")
	JComboBox CB3;
	JLabel L1, L2, L3, L4, L5, L6;
	JTextField Tx1, Tx2, Tx3, Tx4, Tx5;

	JPanel panelTable;
	
	private JTable table;
	private JScrollPane scrollPane;
	
	private List<Produto> prodList;
	
	public static Produto p;
	
	public CadProduto(){
		setTitle("Cadastro de Produto");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img//dmr_icon.png"));
		
		L1 = new JLabel("Código");
		L1.setBounds(50,50,100,40);
		Tx1 = new JTextField(" ");
		Tx1.setBounds(50, 90, 100, 20);	

		L2 = new JLabel("Nome");
		L2.setBounds(200, 50, 40, 40);
		Tx2 = new JTextField(" ");
		Tx2.setBounds(210, 90, 480, 20);
		
		L3 = new JLabel("Categoria");
		L3.setBounds(50,110,1000,40);
		CB3 = new JComboBox();
		CB3.setBounds(50, 150, 150, 20);
		
		L4 = new JLabel("Quantidade Estoque");
		L4.setBounds(250,110,130,40);
		Tx4 = new JTextField(" ");
		Tx4.setBounds(250, 150, 200, 20);
		
		L5 = new JLabel("Valor Unitário");
		L5.setBounds(500,110,100,40);
		Tx5 = new JTextField(" ");
		Tx5.setBounds(500, 150, 190, 20);
		
		L6 = new JLabel("Produtos Cadastrados");
		L6.setBounds(50,180,1000,40);
		
		carregaComboBox();
		
		C1.add(L1);
		C1.add(Tx1);
		C1.add(L2);
		C1.add(Tx2);
		C1.add(L3);
		C1.add(CB3);
		C1.add(L4);
		C1.add(Tx4);
		C1.add(L5);
		C1.add(Tx5);
		C1.add(L6);
		
		panelTable = new JPanel();
		panelTable.setLayout(new MigLayout());
		panelTable.setBackground(new Color(220, 220, 220));
		panelTable.setBounds(50, 220, 640, 270);
		
		table = new JTable();
		scrollPane = new JScrollPane(table);
		panelTable.add(scrollPane,"width 625:270:1000");
	
		refreshTable();
		
		C1.add(panelTable);
		
		C1.setVisible(true);
		
		
		/**
		 * Implementando ações dos botões
		 */
			
			//"Salvar"
			B1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int id;
					try {
						String tn = Tx2.getText();
						String vu = Tx5.getText();
						float v= Float.parseFloat(vu); 
						String qe = Tx4.getText();
						String categ = CB3.getSelectedItem().toString();
						CadCategoriaDAO catdao = new CadCategoriaDAO();
						int cat = catdao.descobreIDCategoria(categ);
						//int cat = CB3.getSelectedIndex();
						id=descobreID();
						System.out.println("ID: "+id);
						salvarOuEditar(id, tn, vu, qe, cat);  
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
					refreshTable();

				}
			});
			
			//"Procurar"
			B5.setEnabled(false);
			
			//"Novo"
			B6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					habilitar();	
				}
			});
	
	}

	private void clearTxt() {
		//Tx1.setText("");
		Tx2.setText("");
		Tx5.setText("");
		Tx4.setText("");
		
	}

	private int descobreID() {
		try{
			int rowIndex = table.getSelectedRow();
			Produto p = new ProdutoTableModel(prodList).get(rowIndex);		
			int id = p.getIdProduto();
			return id;
		}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("Erro DescobreID.");
		}
		return -1;
	}
	
	private void refreshTable() {
		 prodList = new CadProdutoDAO().findProduto();
		 if(prodList !=null){
			 	table.setModel(new ProdutoTableModel(prodList));
		 }
		
	}

	private void salvarOuEditar(int id, String tn, String vu, String qe, int cat) throws SQLException {
		Produto produto = new Produto();
		CadProdutoDAO dao = new CadProdutoDAO();
		if(dao.idProdutoExiste(id)){
				//Editar
				produto.setIdProduto(id);
				produto.setNome(tn);
				produto.setValoruni(vu);
				produto.setCategoria_idCategoria(cat);
				new CadProdutoDAO().Editar(produto);
		} else {
			//Salvar
			new CadProdutoDAO().Salvar(id,tn,vu,qe,cat);

		}
		
	}
	
	private void onEditar() {
		int rowIndex = table.getSelectedRow();
		if (rowIndex == -1){
			JOptionPane.showMessageDialog(null, "Selecione o produto a ser editado.");
			return;
		}
		
		p = new ProdutoTableModel(prodList).get(rowIndex);
		p.setIdProduto(p.getIdProduto());
		Tx2.setText(p.getNome());
		Tx5.setText(p.getValoruni());
		String qtd = Integer.toString(p.getQtdestoque());
		Tx4.setText(qtd);
		
	}
	
	private void onRemove() {
		int rowIndex = table.getSelectedRow();
		if (rowIndex == -1){
			JOptionPane.showMessageDialog(null, "Selecione o produto a ser removido!");
			return;
		}
		
		Produto p = new ProdutoTableModel(prodList).get(rowIndex);
		int confirmar = JOptionPane.showConfirmDialog( null,"Deseja realmente excluir o produto?", "Excluir",JOptionPane.YES_NO_OPTION); 
		
		if(confirmar != 0){
			return;
		}
		
		int id = p.getIdProduto();
		
		try {
			new CadProdutoDAO().Excluir(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
	
	private void habilitar(){
		Tx2.setEnabled(true);
		Tx4.setEnabled(true);
		Tx5.setEnabled(true);
		B1.setEnabled(true);
		B2.setEnabled(true);
		B4.setEnabled(true);
		//B5.setEnabled(true);
		CB3.setEnabled(true);
	}
	
	private void desabilitar(){
		Tx1.setEnabled(false);
		Tx2.setEnabled(false);
		Tx4.setEnabled(false);
		Tx5.setEnabled(false);
		B1.setEnabled(false);
		B2.setEnabled(false);
		B4.setEnabled(false);
		B5.setEnabled(false);
		CB3.setEnabled(false);
	}
	
	@SuppressWarnings("unchecked")
	public void carregaComboBox(){    
	          try{     
	              java.sql.Connection conn;    
	              conn = ConexaoBD.getConnection();
	              Statement st = (Statement) conn.createStatement();    
	              ResultSet rs = st.executeQuery("SELECT nome FROM categoria ORDER BY nome" );    
	              while(rs.next()){   
	            	  CB3.addItem(rs.getString("nome"));    
	              }    
	              rs.close(); 
	              st.close();
	              conn.close();    
	          }    
	          catch(Exception e){    
	              JOptionPane.showMessageDialog(null, "Erro ao carregar os cargos!", "Erro", JOptionPane.ERROR_MESSAGE);    
	          }         
	  } 
	
	public static void main(String[] args) {
		CadProduto CadP = new CadProduto();
		CadP.desabilitar();
		CadP.setVisible(true);

	}

}
