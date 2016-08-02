package Telas;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Classes.Login;
import DAO.CadCategoriaDAO;
import DAO.LoginDAO;

@SuppressWarnings("serial")
public class CadastroPermissoes extends Cadastro{
	 JLabel lblIdFunc, lblLogin, lblSenha, lblPermissoes;
	 JTextField txtIdFunc, txtLogin, Tx3, Tx7;
	 JPasswordField jpSenha;
	 JRadioButton rbAdm, rbGer, rbVen;
	 JTextArea taPermissoes;
	 ButtonGroup bg;
	 Login login;
	 int nivel, id;
	 
	public CadastroPermissoes(){
		
		setTitle("Cadastro de Funcionário - Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img//dmr_icon.png"));
		
		login = new Login();
		
		lblIdFunc = new JLabel("Cod Funcionario");
		lblIdFunc.setBounds(51, 50, 106, 14);
		
		txtIdFunc = new JTextField();
		txtIdFunc.setBounds(51, 75, 91, 20);
		txtIdFunc.setEditable(false);
		
		lblLogin = new JLabel("Login");
		lblLogin.setBounds(200, 50, 46, 14);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(200, 75, 219, 20);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(475, 50, 46, 14);
		
		jpSenha = new JPasswordField();
		jpSenha.setBounds(475, 75, 219, 20);
		
		lblPermissoes = new JLabel("Nivel de Permissoes");
		lblPermissoes.setBounds(51, 120, 116, 14);
		
		rbAdm = new JRadioButton("Administrador");
		rbAdm.setBounds(51, 148, 109, 23);
		rbAdm.setBackground(Color.WHITE);
		
		rbVen = new JRadioButton("Vendedor");
		rbVen.setBounds(320, 148, 109, 23);
		rbVen.setBackground(Color.WHITE);
		
		rbGer = new JRadioButton("Gerente");
		rbGer.setBounds(199, 148, 109, 23);
		rbGer.setBackground(Color.WHITE);
		
		bg = new ButtonGroup();
		bg.add(rbAdm);
		bg.add(rbGer);
		bg.add(rbVen);
		
		taPermissoes = new JTextArea();
		taPermissoes.setBounds(51, 178, 643, 321);
		taPermissoes.setBackground(Color.lightGray);
		taPermissoes.setEditable(false);


		B1.setBounds(50, 50, 50, 20);
		B2.setBounds(50, 50, 50, 20);
		B3.setBounds(50, 50, 50, 20);

		B4.setVisible(false);
		B5.setVisible(false);
		
		
		C1.add(lblIdFunc);
		C1.add(txtIdFunc);
		C1.add(lblLogin);
		C1.add(txtLogin);
		C1.add(lblSenha);
		C1.add(jpSenha);
		C1.add(rbAdm);
		C1.add(rbGer);
		C1.add(rbVen);
		C1.add(lblPermissoes);
		C1.add(taPermissoes);
		
		/**
		 * Implementando ações dos RadioButtons
		 */
		
		rbAdm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nivel=1;
				escrevePermissoes();
			}
		});
		
		rbGer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nivel=2;
				escrevePermissoes();
			}
		});
		
		rbVen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nivel=3;
				escrevePermissoes();
			}
		});
		
		
		/**
		 * Implementando ações dos botões
		 */
			
			//"Salvar"
			B1.setText("Ok");
			B1.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					try{
						login.setNivel(nivel);
						login.setSenha(jpSenha.getText());
						login.setUsuario(txtLogin.getText());
//						LoginDAO lDAO = new LoginDAO();  
//						id = lDAO.Salvar(login);  
				    } catch (Exception e1) { 	  
				    	e1.printStackTrace();  
				    }
					dispose();
				}
			});		
			
			B2.setVisible(false);
			
			//"Cancelar"
			B3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});		
		
	}

	
	public String escrevePermissoes(){
		if (rbAdm.isSelected()){
			String adm = "Nivel selecionado: Administrador/n/n Menu Cadastro:  Empresa, Funcionário, Cargo, Pessoa Física, "
					+ "Pessoa Jurídica, Produto, Categoria Produto. /nMenu Movimentação: Venda e Estoque /n "
					+ "Menu Relatórios: Cliente e Produto"; 
			taPermissoes.setText(adm);
			return adm;
		} else 	if (rbGer.isSelected()){
			String ger = "Nivel selecionado: Gerente/n/n Menu Cadastro: Funcionário, Cargo, Pessoa Física, "
					+ "Pessoa Jurídica, Produto, Categoria Produto. /nMenu Movimentação: Venda e Estoque /n "
					+ "Menu Relatórios: Cliente e Produto"; 
			taPermissoes.setText(ger);
			return ger;
		} else 	if (rbVen.isSelected()){
			String ven = "Nivel selecionado: Vendedor/n/n Menu Cadastro: Não possui acesso a nenhuma opção. "
					+ "/nMenu Movimentação: Venda e Estoque /nMenu Relatórios: Cliente e Produto"; ; 
			taPermissoes.setText(ven);
			return ven;
		}
		
		return null;
		
	}
	
	
//	public static void main(String[] args) {
//		CadastroPermissoes CadPer = new CadastroPermissoes();
//		CadPer.setVisible(true);
//
//	}

}
