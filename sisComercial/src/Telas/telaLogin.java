package Telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Classes.Login;
import DAO.LoginDAO;


@SuppressWarnings("serial")
public class telaLogin extends JFrame{
	    public int aux;	
	    JButton OK, Cancel;
		JTextField txtLogin;
		JPasswordField txtSenha;
		JCheckBox Bold, Italico;
		static Princ pri = new Princ();
		Login logar;
		static telaLogin login;
	
	public telaLogin(){
		//veficando o tamanho da tela e dimensionando;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension scrnsize = toolkit.getScreenSize();
		int width = (int)scrnsize.getWidth();  
		int heigth = (int)scrnsize.getHeight(); 
		setResizable(false);
		
		//criando objetos da tela 
		setTitle("|  DMR  |");	
		setIconImage(Toolkit.getDefaultToolkit().getImage("img//dmr_icon.png"));
		OK =  new JButton("Ok");

		getRootPane().setDefaultButton(OK);
	    Cancel = new JButton("Cancel");
	    
	    txtLogin = new JTextField();
		txtSenha = new JPasswordField();
		
		//set layout
		Container C1 = getContentPane();
		C1.setLayout(new GridLayout(3,2));
		
		//adicionando componentes
		C1.add(new JLabel("Login:"));
		C1.add(txtLogin);
		C1.add(new JLabel("Senha:"));
		C1.add(txtSenha);
		C1.add(OK);
		C1.add(Cancel);
		setBounds((width-200)/2,(heigth-300)/2, 300, 150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
	


	OK.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				logar = new Login(txtLogin.getText(), txtSenha.getText(),aux);
				LoginDAO lista = new LoginDAO();
				lista.Acesso(logar,aux);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		
		}	
	});
	
	
	Cancel.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(1);
		}
	});
	
}
	public static void main(String[] args){
		telaLogin lo = new telaLogin();
		lo.setVisible(true);	
	}
}