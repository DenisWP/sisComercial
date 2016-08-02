package Telas;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Classes.PFisica;
import DAO.CadClienteFDAO;

public class CadClienteF extends Cadastro{
	 JComboBox CB12;
	 JRadioButton Rb5, Rb6;
	 ButtonGroup onlyOne;
	 JTextArea Ta15;	 
	 JFormattedTextField TF2,TF3;
	 JLabel L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12, L13, L14, L15;
	 JTextField Tx1, Tx2, Tx7, Tx8, Tx9, Tx10, Tx11, Tx13, Tx14;	 
	 String[] PFJ = {"Física","Jurídica"};
	 String[] Est = {"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PR","PB","PA","PE","PI","RJ","RN","RS","RO","RR","SC","SE","SP","TO"};

	public CadClienteF(){
		setTitle("Cadastro de Cliente Pessoa Física");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img//dmr_icon.png"));

		L1 = new JLabel("Código Cliente");
		L1.setBounds(50,50,100,40);
		Tx1 = new JTextField(" ");
		Tx1.setBounds(50, 90, 100, 20);	
		Tx1.setEditable(false);
		
		L2 = new JLabel("CPF");	
		L2.setBounds(220, 50, 40, 40);
		TF2 = new  JFormattedTextField();
		MaskFormatter maskCpf   = new MaskFormatter();
		String Cpf= "###.###.###-##";
		try{
			maskCpf.setMask(Cpf);
			maskCpf.install(TF2);
		}
		catch(Exception e){	
		}
		TF2.setBounds(220,90,100,20);

		
		L3 = new JLabel("RG");
		L3.setBounds(400, 50, 40, 40);
		TF3 = new  JFormattedTextField();
		MaskFormatter maskRg   = new MaskFormatter();
		String Rg= "##.###.###";
		try{
			maskRg.setMask(Rg);
			maskRg.install(TF3);
		}
		catch(Exception e){	
		}
		TF3.setBounds(400, 90, 100, 20);
		
		L4 = new JLabel("Cliente Ativo");
		L4.setBounds(620,50,100,40);

		L5 = new JLabel("Sim");
		L5.setBounds(600,80,100,40);
		Rb5 = new JRadioButton("Sim");
		Rb5.setBounds(630,90,20,20);
		
		L6 = new JLabel("Não");
		L6.setBounds(660,80,100,40);
		Rb6 = new JRadioButton("Não");
		Rb6.setBounds(690,90,20,20);
		
		onlyOne = new ButtonGroup();
		onlyOne.add(Rb5);
		onlyOne.add(Rb6);		
	
		L7 = new JLabel("Nome");
		L7.setBounds(50, 110, 40, 40);
		Tx7 = new JTextField(" ");
		Tx7.setBounds(50,150,650,20);	
		
		L8 = new JLabel("Rua");
		L8.setBounds(50,170,40,40);
		Tx8 = new JTextField(" ");
		Tx8.setBounds(50,210,500,20);
		
		L9 = new JLabel("Bairro");
		L9.setBounds(50,230,40,40);
		Tx9 = new JTextField(" ");
		Tx9.setBounds(50,270,200,20);
		
		L10 = new JLabel("Nº");
		L10.setBounds(600,170,40,40);
		Tx10 = new JTextField(" ");
		Tx10.setBounds(600,210,100,20);
		
		L11 = new JLabel("Cidade");
		L11.setBounds(300,230,60,40);
		Tx11 = new JTextField(" ");
		Tx11.setBounds(300,270,250,20);
				
		L12 = new JLabel("Estado");
		L12.setBounds(600,230,60,40);
		CB12 = new JComboBox(Est);
		CB12.setBounds(600,270,100,20);
		
		L13 = new JLabel("Telefone");
		L13.setBounds(50,290,200,40);
		Tx13 = new JTextField(" ");
		Tx13.setBounds(50,330,200,20);
		
		L14 = new JLabel("Celular");
		L14.setBounds(300,290,200,40);
		Tx14 = new JTextField(" ");
		Tx14.setBounds(300,330,200,20);
		
		L15 = new JLabel("Observações");
		L15.setBounds(50, 350,100, 40 );
		Ta15 = new JTextArea();
		Ta15.setBackground(Color.LIGHT_GRAY);
		Ta15.setBounds(50, 390, 650, 40);
		
		C1.add(L1);
		C1.add(Tx1);
		C1.add(L2);
		C1.add(TF2);
		C1.add(L3);
		C1.add(TF3);
		C1.add(L4);
		C1.add(L5);
		C1.add(Rb5);		
		C1.add(L6);
		C1.add(Rb6);
		C1.add(L7);
		C1.add(Tx7);
		C1.add(L8);
		C1.add(Tx8);
		C1.add(L9);
		C1.add(Tx9);
		C1.add(L10);
		C1.add(Tx10);
		C1.add(L11);
		C1.add(Tx11);
		C1.add(L12);
		C1.add(CB12);
		C1.add(L13);
		C1.add(Tx13);
		C1.add(L14);
		C1.add(Tx14);
		C1.add(L15);
		C1.add(Ta15);
		
		
		/**
		 * Implementando ações dos botões
		 */
			
			//"Salvar"
			B1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						PFisica pfisica = new PFisica(); 
				      
						CadClienteFDAO pfDAO = new CadClienteFDAO();  
						pfDAO.Salvar(pfisica);
						Tx7.requestFocus();  
				    
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
						CadClienteFDAO lista = new CadClienteFDAO();
						lista.Excluir();
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
						CadClienteFDAO cadastro= new CadClienteFDAO();
						cadastro.Procurar();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			

			
		
		
		
	}


	public static void main(String[] args) {
		CadClienteF CadCF = new CadClienteF();
		CadCF.setVisible(true);

	}

}
