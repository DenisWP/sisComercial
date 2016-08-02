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

import net.miginfocom.swing.MigLayout;
import Classes.Categoria;
import DAO.CadCategoriaDAO;
import Model.CategoriaTableModel;

@SuppressWarnings("serial")
public class CadCategoria extends Cadastro{
	 
	 JLabel lCat, lDesc, lCatCad;
	 public JTextField txtCat, txtDesc;
	 JPanel panelTable;
	
	 private JTable table;
	 private JScrollPane scrollPane;

	 private List<Categoria> catList;
	 
	 public static Categoria c;

	 public CadCategoria() throws SQLException{	
		setTitle("Cadastro de Categorias");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img//dmr_icon.png"));

		lCat = new JLabel("Categoria");
		lCat.setBounds(30, 23, 92, 14);
		txtCat = new JTextField("");
		txtCat.setBounds(30, 48, 249, 20);

		lDesc = new JLabel("Descricao");	
		lDesc.setBounds(309, 23, 85, 14);
		txtDesc = new JTextField("");
		txtDesc.setBounds(309, 48, 402, 20);
		
		lCatCad = new JLabel("Categorias Cadastradas");
		lCatCad.setBounds(30, 95, 200, 14);
		
		panelTable = new JPanel();
		panelTable.setLayout(new MigLayout());
		panelTable.setBackground(new Color(220, 220, 220));
		panelTable.setBounds(30, 120, 680, 360);

		C1.add(lCat);
		C1.add(txtCat);
		C1.add(lDesc);
		C1.add(txtDesc);
		C1.add(lCatCad);
		
		table = new JTable();
		scrollPane = new JScrollPane(table);
		panelTable.add(scrollPane,"width 665:360:1000");
	
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
						String tc = txtCat.getText();
						String td = txtDesc.getText();
						id=descobreID();
						System.out.println("ID: "+id);
						salvarOuEditar(id,tc,td);  
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
			
			//"Novo"
			B6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					habilitar();	
				}
			});	
	
	}

	protected void onEditar() {
		int rowIndex = table.getSelectedRow();
		if (rowIndex == -1){
			JOptionPane.showMessageDialog(null, "Selecione a categoria a ser editada.");
			return;
		}
		
		c = new CategoriaTableModel(catList).get(rowIndex);
		c.setIdCategoria(c.getIdCategoria());
		txtCat.setText(c.getNomeCategoria());
		txtDesc.setText(c.getDescricao());

	}

	private void refreshTable() throws SQLException{
		 catList = new CadCategoriaDAO().findCategoria();
		 if(catList !=null){
			 	table.setModel(new CategoriaTableModel(catList));
		 }

    } 
	 
	private void clearTxt(){
		txtCat.setText("");
		txtDesc.setText("");
	}
	
	public void onRemove(){
		int rowIndex = table.getSelectedRow();
		if (rowIndex == -1){
			JOptionPane.showMessageDialog(null, "Selecione a categoria a ser removida!");
			return;
		}
		
		Categoria c = new CategoriaTableModel(catList).get(rowIndex);
		int confirmar = JOptionPane.showConfirmDialog( null,"Deseja realmente excluir a categoria?", "Excluir",JOptionPane.YES_NO_OPTION); 
		
		if(confirmar != 0){
			return;
		}
		
		int id = c.getIdCategoria();
		
		try {
			new CadCategoriaDAO().Excluir(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void salvarOuEditar(int id, String tc, String td) throws SQLException{
		Categoria categoria = new Categoria();
		CadCategoriaDAO dao = new CadCategoriaDAO();
		if(dao.idCategoriaExiste(id)){
				//Editar
				categoria.setIdCategoria(id);
				categoria.setNomeCategoria(tc);
				categoria.setDescricao(td);
				new CadCategoriaDAO().Editar(categoria);
		} else {
			//Salvar
			new CadCategoriaDAO().Salvar(tc,td,id);

		}
	}

	public int descobreID(){
		try{
			int rowIndex = table.getSelectedRow();
			Categoria c = new CategoriaTableModel(catList).get(rowIndex);		
			int id = c.getIdCategoria();
			return id;
		}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("Erro DescobreID.");
		}
		return -1;
	}
	
	public void desabilitar(){
		txtCat.setEnabled(false);
		txtDesc.setEnabled(false);
		B1.setEnabled(false);
		B2.setEnabled(false);
		B4.setEnabled(false);
		B5.setEnabled(false);
	}
	
	public void habilitar(){
		txtCat.setEnabled(true);
		txtDesc.setEnabled(true);
		B1.setEnabled(true);
		B2.setEnabled(true);
		B4.setEnabled(true);
		//B5.setEnabled(true);
	}
	
	public static void main(String[] args) {
    		CadCategoria c = null;
			try {
				c = new CadCategoria();
				c.desabilitar();
			} catch (HeadlessException | SQLException e) {
				e.printStackTrace();
			}
			c.setVisible(true);
	}

    
}
