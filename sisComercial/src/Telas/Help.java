package Telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Help extends JFrame implements ActionListener{
		JButton ok;
		
	public Help() {
		
		//veficando o tamanho da tela e dimensionando;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension scrnsize = toolkit.getScreenSize();
		int width = (int)scrnsize.getWidth();  
		int heigth = (int)scrnsize.getHeight(); 
	 	
	 	//configurando layout 
		setTitle("Sobre");
	 	setLayout(null);
	 	setResizable(false);
	 	setBounds((width-200)/2,(heigth-300)/2, 300, 200);
	 	setIconImage(Toolkit.getDefaultToolkit().getImage("img//dmr_icon.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.black,3));
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		Container C1 = getContentPane();
		C1.setLayout(null);
		
		//criando objetos		
		JLabel titulo = new JLabel("Sistema Comercial REV 1.0");
		titulo.setBounds(50 , 20 , 200 , 20);
		JLabel subtitulo = new JLabel("Trabalho desenvolvido pelos alunos:");
		subtitulo.setBounds(50 , 40 , 230 , 20);
		JLabel um = new JLabel("Denis Wilson");
		um.setBounds(50 , 80 , 100 , 20);
		JLabel dois = new JLabel("Maily Santos");
		dois.setBounds(50 , 100 , 100 , 20);
		JLabel tres = new JLabel("Rafael Turquetti");
		tres.setBounds(50 , 120 , 100 , 20);
		ok = new JButton("OK");
		ok.addActionListener(this);
		ok.setBounds(120, 150, 60, 30);
		
		//adcionando objetos
		C1.add(titulo);
		C1.add(subtitulo);
		C1.add(um);
		C1.add(dois);
		C1.add(tres);
		C1.add(ok);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok){
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		Help H = new Help();
		H.setVisible(true);

	}

}
