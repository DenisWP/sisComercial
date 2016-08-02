package Telas;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Classes.Empresa;
import Classes.PFisica;
import DAO.CadClienteFDAO;
import DAO.CadEmpresaDAO;

public class CadEmpresa extends Cadastro{
	 public JComboBox CB9;
	 public JFormattedTextField TF1, TF2, TF10, TF11;
	 JLabel L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11;
	 public JTextField Tx3, Tx4, Tx5, Tx6, Tx7, Tx8, Tx9;	 
	 String[] Est = {"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PR","PB","PA","PE","PI","RJ","RN","RS","RO","RR","SC","SE","SP","TO"};

	public CadEmpresa(){
		
		setTitle("Cadastro de Empresa");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img//dmr_icon.png"));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		L1 = new JLabel("CNPJ");
		L1.setBounds(50,50,40,40);
		TF1 = new  JFormattedTextField();
		MaskFormatter maskCnpj   = new MaskFormatter();
		String Cnpj= ("##.###.###/####-##");
		try{
			maskCnpj.setMask(Cnpj);
			maskCnpj.install(TF1);
		}
		catch(Exception e){	
		}
		TF1.setBounds(50,90,120,20);

		L2 = new JLabel("Inscrição Estadual");
		L2.setBounds(250,50,200,40);
		TF2 = new  JFormattedTextField();
		MaskFormatter maskIns   = new MaskFormatter();
		String Ins= ("##.###.###/####-##");
		try{
			maskIns.setMask(Ins);
			maskIns.install(TF2);
		}
		catch(Exception e){	
		}
		TF2.setBounds(250,90,120,20);
		
		L3 = new JLabel("Razão Social");
		L3.setBounds(50,110,200,40);
		Tx3 = new JTextField(" ");
		Tx3.setBounds(50,150,650,20);
		
		L4 = new JLabel("Nome Fantasia");
		L4.setBounds(50,170,200,40);
		Tx4 = new JTextField(" ");
		Tx4.setBounds(50,210,650,20);

		L5 = new JLabel("Rua:");
		L5.setBounds(50, 230, 40, 40);
		Tx5 = new JTextField(" ");
		Tx5.setBounds(50,270,500,20);
		
		L6 = new JLabel("Bairro:");
		L6.setBounds(50,290,100,40);
		Tx6 = new JTextField(" ");
		Tx6.setBounds(50,330,200,20);
		
		L7 = new JLabel("Nº:");
		L7.setBounds(600,230,40,40);
		Tx7 = new JTextField(" ");
		Tx7.setBounds(600,270,100,20);
		
		L8 = new JLabel("Cidade");
		L8.setBounds(300,290,60,40);
		Tx8 = new JTextField(" ");
		Tx8.setBounds(300,330,250,20);
				
		L9 = new JLabel("Estado:");
		L9.setBounds(600,290,60,40);
		CB9 = new JComboBox(Est);
		CB9.setBounds(600,330,100,20);
		
		L10 = new JLabel("Telefone");
		L10.setBounds(50,350,200,40);
		TF10 = new  JFormattedTextField();
		MaskFormatter maskTel   = new MaskFormatter();
		String Tel= ("(##) ####-####");
		try{
			maskTel.setMask(Tel);
			maskTel.install(TF10);
		}
		catch(Exception e){	
		}
		TF10.setBounds(50,390,120,20);
		
		L11 = new JLabel("Telefone Comercial");
		L11.setBounds(300,350,200,40);
		TF11 = new  JFormattedTextField();
		MaskFormatter maskCel   = new MaskFormatter();
		String Cel= ("(##) ####-####");
		try{
			maskCel.setMask(Cel);
			maskCel.install(TF11);
		}
		catch(Exception e){	
		}
		TF11.setBounds(300,390,120,20);
		
		C1.add(L1);
		C1.add(TF1);
		C1.add(L2);
		C1.add(TF2);
		C1.add(L3);
		C1.add(Tx3);
		C1.add(L4);
		C1.add(Tx4);
		C1.add(L5);
		C1.add(Tx5);
		C1.add(L6);
		C1.add(Tx6);
		C1.add(L7);
		C1.add(Tx7);
		C1.add(Tx7);
		C1.add(L8);
		C1.add(Tx8);
		C1.add(L9);
		C1.add(CB9);
		C1.add(L10);
		C1.add(TF10);
		C1.add(L11);
		C1.add(TF11);

		
		//"Salvar"
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Empresa empresa = new Empresa(TF1.getText(), TF2.getText(), Tx3.getText(), Tx4.getText(), 
							Tx5.getText(), Tx6.getText(), Tx8.getText(), Tx7.getText(), CB9.getSelectedItem().toString(), 
							TF10.getText(), TF11.getText()); 
			      
					CadEmpresaDAO empDAO = new CadEmpresaDAO();  
					empDAO.Salvar(empresa);  
					setDefaultCloseOperation(EXIT_ON_CLOSE);
			    } catch (SQLException e1) {   
			    	e1.printStackTrace();  
			    	}  
				
			}
		});		
		
		//"Editar"
		B2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		//"Cancelar"
		B3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});		
		
		//"Excluir"
		B4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CadEmpresaDAO empDAO = new CadEmpresaDAO();  
					empDAO.Excluir();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//"Procurar"
		B5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CadEmpresaDAO empDAO = new CadEmpresaDAO();  
					empDAO.Procurar();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
	}
	
	public static void main(String[] args) {
		CadEmpresa CadE = new CadEmpresa();
		CadE.setVisible(true);

	}

}

