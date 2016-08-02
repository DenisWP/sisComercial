package Telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.*;

@SuppressWarnings("unused")
public class Princ extends JFrame{
	Help Hel = new Help();
	Cadastro CadE = new CadEmpresa();
	Cadastro CadCF = new CadClienteF();
	Cadastro CadCJ = new CadClienteJ();
	Cadastro CadF = new CadastroFunc();
	Cadastro CadP = new CadProduto();
	Venda Vend = new Venda();
	telaLogin Log = new telaLogin();
	CadastroPermissoes CadPerm = new CadastroPermissoes();
	
	JMenu arquivo, empresa, movimento, relatorio, help;
	public static JMenuItem logout, sair, cadEmpr, cadCliF, cadCliJ, cadFun, perFun, cadPro, vend, est, relCli, relProd, sobre;
	
	
	public Princ(){
		setTitle("DMR - Sistema de Controle Varejista");	
		
		//veficando o tamanho da tela e dimensionando;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension scrnsize = toolkit.getScreenSize();
		int width = (int)scrnsize.getWidth();  
		int heigth = (int)scrnsize.getHeight(); 
		setBounds(0,0,width,heigth);
		
		//configurar desktop
		JDesktopPane desktop = new JDesktopPane();
		desktop.setLayout(null);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img//dmr_icon.png"));
		
//		Icon img = new ImageIcon(getClass().getResource("img//images.png"));
//    	JLabel imagem = new JLabel("");
//		imagem.setIcon(img);
//		imagem.setBounds(100, 100, width,heigth);
//		
//    	this.getContentPane().add( desktop );
//		desktop.add(imagem);
		
		
		//criando barra de menus
		JMenuBar barra = new JMenuBar();
		
		arquivo = new JMenu("Arquivo");
		empresa = new JMenu("Cadastro");
		movimento = new JMenu("Movimentação");
		relatorio = new JMenu("Relatórios");
		help = new JMenu("Help");
		
		logout = new JMenuItem("Logout");
		sair = new JMenuItem("Sair");
		
		cadEmpr = new JMenuItem("Empresa");
		cadCliF = new JMenuItem("Cliente Pessoa Física");
		cadCliJ = new JMenuItem("Cliente Pessoa Jurídica");
		cadFun = new JMenuItem("Funcionário");
		//perFun = new JMenuItem("Permissões de Funcionários");
		cadPro = new JMenuItem("Produto");
		
		vend = new JMenuItem("Venda");
		est = new JMenuItem("Estoque");
		
		relCli = new JMenuItem("Cliente");
		relProd = new JMenuItem("Produto");
		
		sobre = new JMenuItem("Sobre");
		
		arquivo.add(logout);
		arquivo.add(sair);
				
		empresa.add(cadEmpr);
		empresa.add(cadCliF);
		empresa.add(cadCliJ);
		empresa.add(cadFun);
		//empresa.add(perFun);
		empresa.add(cadPro);
		
		movimento.add(vend);
		movimento.add(est);
		
		relatorio.add(relCli);
		relatorio.add(relProd);
		
		help.add(sobre); 
		
		barra.add(arquivo);
		barra.add(empresa);
		barra.add(movimento);
		barra.add(relatorio);
		barra.add(help);
		setJMenuBar(barra);
		
		arquivo.setMnemonic('A');
		logout.setMnemonic('O');
		sair.setMnemonic('S');
		
		empresa.setMnemonic('C');
		cadEmpr.setMnemonic('E');
		cadCliF.setMnemonic('F');
		cadCliJ.setMnemonic('J');
		cadFun.setMnemonic('C');
		//perFun.setMnemonic('P');
		cadPro.setMnemonic('O');
		
		movimento.setMnemonic('M');
		vend.setMnemonic('V');
		est.setMnemonic('E');
		
		relatorio.setMnemonic('R');
		relCli.setMnemonic('C');
		relProd.setMnemonic('P');
		
		help.setMnemonic('H');
		sobre.setMnemonic('S');	
		
				
		//adcionando funções ao menu
		 logout.addActionListener(
				 new ActionListener() {
					 public void actionPerformed( ActionEvent evento ) {
						 int confirmar = JOptionPane.showConfirmDialog( null,"Deseja realmente fazer logout?", "Logout",JOptionPane.YES_NO_OPTION); 
							if(confirmar == 0){
								 dispose();
								 Log.setVisible(true);
							}
					 }
				 }
		 );	 
		 
		 sair.addActionListener(
				 new ActionListener() {
					 public void actionPerformed( ActionEvent evento ) {
						 System.exit( 0 );
					 }
				 }
		 );
		 
		 vend.addActionListener(
				 new ActionListener() {
					 public void actionPerformed( ActionEvent evento ) {
						 Vend.setVisible(true);
					 }
				 }
		 );	
		
		 cadCliF.addActionListener(
				 new ActionListener() {
					 public void actionPerformed( ActionEvent evento ) {
						 CadCF.setVisible(true);
					 }
				 }
		 );
		 
		 cadCliJ.addActionListener(
				 new ActionListener() {
					 public void actionPerformed( ActionEvent evento ) {
						 CadCJ.setVisible(true);
					 }
				 }
		 );
		 
		 cadCliF.addActionListener(
				 new ActionListener() {
					 public void actionPerformed( ActionEvent evento ) {
						 CadCF.setVisible(true);
					 }
				 }
		 );
		 
//		 cadFun.addActionListener(
//				 new ActionListener() {
//					 public void actionPerformed( ActionEvent evento ) {
//						 CadF.setVisible(true);
//					 }
//				 }
//		 );
		 
		 cadEmpr.addActionListener(
				 new ActionListener() {
					 public void actionPerformed( ActionEvent evento ) {
						 CadE.setVisible(true);
					 }
				 }
		 );

//		 perFun.addActionListener(
//				 new ActionListener() {
//					 public void actionPerformed( ActionEvent evento ) {
//						 CadPerm.setVisible(true);
//					 }
//				 }
//		 );
		 
		 cadPro.addActionListener(
				 new ActionListener() {
					 public void actionPerformed( ActionEvent evento ) {
						 CadP.setVisible(true);
					 }
				 }
		 );
		 
		
		 relCli.addActionListener(
				 new ActionListener() {
					 public void actionPerformed( ActionEvent evento ) {
							try{
								RelatorioCliente RC = new RelatorioCliente();
								//Abrindo o pdf para visualização
								File pdf = new File("C://dmr//Relatório_Cliente.pdf");  
								try {  
								  Desktop.getDesktop().open(pdf);  
								} catch(Exception ex) {  
								  ex.printStackTrace();  
								  JOptionPane.showMessageDialog(null, "Erro no Desktop: " + ex);  
								}	
							}
							catch(Exception ex){
							System.out.println("Erro ao abrir");
						}
					 }
				 }
		 );
		 
		 relProd.addActionListener(
				 new ActionListener() {
					 public void actionPerformed( ActionEvent evento ) {
							try{
								RelatorioProduto RP = new RelatorioProduto();
								//Abrindo o pdf para visualização
								File pdf = new File("C://dmr//Relatório_Produto.pdf");  
								try {  
								  Desktop.getDesktop().open(pdf);  
								} catch(Exception ex) {  
								  ex.printStackTrace();  
								  JOptionPane.showMessageDialog(null, "Erro no Desktop: " + ex);  
								}	
							}
							catch(Exception ex){
							System.out.println("Erro ao abrir");
						}
					 }
				 }
	 );
		 
		 
		 sobre.addActionListener(
				 new ActionListener() {
					 public void actionPerformed( ActionEvent evento ) {
					 	Hel.setVisible(true);
					 }
				 }
		 );	
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	

	}   

	
	public static void main(String[] args) {
		Princ P = new Princ();
		P.setVisible(true);

	}

}

