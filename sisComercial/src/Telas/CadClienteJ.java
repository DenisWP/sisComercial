package Telas;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class CadClienteJ extends CadEmpresa{
	JLabel L0,L15;
	JTextField Tx0;
	JTextArea Ta15;
	JRadioButton Rb5, Rb6;
	ButtonGroup onlyOne;
	 
	public CadClienteJ(){
		setTitle("Cadastro de Cliente Pessoa Jurídica");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img//dmr_icon.png"));
		
		L1.setVisible(false);
		TF1.setVisible(false);
		L2.setVisible(false);
		TF2.setVisible(false);
		
		L0 = new JLabel("Código Cliente");
		L0.setBounds(50,50,100,40);
		Tx0 = new JTextField(" ");
		Tx0.setBounds(50, 90, 100, 20);
		
		L1 = new JLabel("CNPJ");
		L1.setBounds(220, 50, 40, 40);
		TF1 = new  JFormattedTextField();
		MaskFormatter maskCnpj   = new MaskFormatter();
		String Cnpj= ("##.###.###/####-##");
		try{
			maskCnpj.setMask(Cnpj);
			maskCnpj.install(TF1);
		}
		catch(Exception e){	
		}
		TF1.setBounds(220,90,120,20);

		L2 = new JLabel("Inscrição Estadual");
		L2.setBounds(400, 50, 130, 40);
		TF2 = new  JFormattedTextField();
		MaskFormatter maskIns   = new MaskFormatter();
		String Ins= ("##.###.###/####-##");
		try{
			maskIns.setMask(Ins);
			maskIns.install(TF2);
		}
		catch(Exception e){	
		}
		TF2.setBounds(400, 90, 120, 20);
		
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
	
		L15 = new JLabel("Observações");
		L15.setBounds(50, 410,100, 40 );
		Ta15 = new JTextArea();
		Ta15.setBackground(Color.LIGHT_GRAY);
		Ta15.setBounds(50, 450, 650, 40);
		
		C1.add(L0);
		C1.add(Tx0);
		C1.add(L1);
		C1.add(TF1);
		C1.add(L2);
		C1.add(TF2);
		C1.add(L4);
		C1.add(L5);
		C1.add(L6);
		C1.add(Rb5);
		C1.add(Rb6);
	
		C1.add(L15);
		C1.add(Ta15);
		
	}
	

	public static void main(String[] args) {
		CadClienteJ CadCJ = new CadClienteJ();
		CadCJ.setVisible(true);

	}

}

