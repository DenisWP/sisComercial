package Telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Cadastro extends JFrame{ 
	 public JButton B1, B2, B3, B4, B5, B6;
	 Container C0 = getContentPane();
	 Container C1 = new JPanel();
	 
	 public Cadastro(){
		 
		//veficando o tamanho da tela e dimensionando;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension scrnsize = toolkit.getScreenSize();
		int width = (int)scrnsize.getWidth();  
		int heigth = (int)scrnsize.getHeight(); 
		setBounds((width-750)/2,(heigth-600)/2,750,600);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("img//dmr_icon.png"));
		
		C0.setLayout(new BorderLayout());
		C0.setBackground(Color.WHITE);
		C1.setLayout(null);
		C1.setBackground(Color.WHITE);

		
		Container C2 = new JPanel();
		C2.setLayout(new GridLayout(2,1));
		C2.setBackground(Color.WHITE);

		
		Container C3 = new JPanel();
		C3.setBackground(Color.WHITE);

		
		Container C4 = new JPanel();
		C4.setBackground(Color.WHITE);
		
		B6 = new JButton("Novo");
		B6.setBounds(50, 50, 50, 20);
		B1 = new JButton("Salvar");
		B1.setBounds(50, 50, 50, 20);
		B2 = new JButton("Editar");
		B2.setBounds(50, 50, 50, 20);
		B3 = new JButton("Cancelar");
		B3.setBounds(50, 50, 50, 20);
		B4 = new JButton("Excluir");
		B4.setBounds(50, 50, 50, 20);
		B5 = new JButton("Procurar");
		B5.setBounds(50, 50, 50, 20);

		
	

		C0.add(BorderLayout.CENTER, C1);
		C0.add(BorderLayout.SOUTH, C2);
		
		C4.add(B6);
		C4.add(B1);
		C4.add(B2);
		C4.add(B3);
		C4.add(B4);
		C4.add(B5);
		
		C2.add(C3);
		C2.add(C4);
	}
	

	public static void main(String[] args) {
		Cadastro Cad = new Cadastro();
		Cad.setVisible(true);
	}
}
