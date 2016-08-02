package Telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Venda extends JFrame implements ActionListener {
	NotaFiscal Nota = new NotaFiscal();
	
	JLabel L1, L2, L3, L4, L5, L6;
	JTextField Tx1, Tx2, Tx3, Tx4, Tx5;
	JButton B6;
	JTextArea Ta1;
	JScrollPane SC1;
	Container C0 = getContentPane();
	
	public Venda(){
		setTitle("Central de Vendas");
		
		//veficando o tamanho da tela e dimensionando;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension scrnsize = toolkit.getScreenSize();
		int width = (int)scrnsize.getWidth();  
		int heigth = (int)scrnsize.getHeight(); 
		setBounds((width-750)/2,(heigth-600)/2,750,600);	
		setResizable(false);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("img//dmr_icon.png"));

		Font F = new Font("Sans Serif",Font.BOLD,16);
		
		L6 = new JLabel("Seja bem Vindo !");
		L6.setBounds(230,20, 200, 40);
		L6.setFont(F);
		
		C0.setLayout(null);
		C0.setBackground(Color.WHITE);
		
		SC1 = new JScrollPane();
		Ta1 = new JTextArea();
		//Ta1.setBounds(400,50,300,450);
		Ta1.setText("Empresa do Cliente\n"+"Endreço tal e tal num: 0000\n"
        +"--------------------------------------------------------------------------\n"+"Cupom Fiscal");
		SC1 = new JScrollPane(Ta1);
		SC1.setBounds(400,50,300,450);
		
		L1 = new JLabel("Cliente");
		L1.setBounds(50,50,100,40);
		Tx1 = new JTextField(" ");
		Tx1.setBounds(50, 90, 300, 50);		
		
		L2 = new JLabel("Descrição do Produto");
		L2.setBounds(50, 140, 200, 40);
		Tx2 = new JTextField(" ");
		Tx2.setBounds(50,180,300,50);
		
		L3 = new JLabel("Quantidade (Und/Kg)");
		L3.setBounds(50,230,200,40);
		Tx3 = new JTextField(" ");
		Tx3.setBounds(50,270,300,50);
		
		L4 = new JLabel("Subtotal R$");
		L4.setBounds(50,320,100,40);
		Tx4 = new JTextField(" ");
		Tx4.setBounds(50, 360, 300, 50);
		
		L5 = new JLabel("Total R$");
		L5.setBounds(50,410,100,40);
		Tx5 = new JTextField(" ");
		Tx5.setBounds(50, 450, 300, 50);
	
		B6 = new JButton("Finalizar");
		B6.setBounds( 325, 530, 100, 30);
		B6.addActionListener(this);
		
		C0.add(L6);
		C0.add(SC1);
		C0.add(L1);
		C0.add(Tx1);
		C0.add(L2);
		C0.add(Tx2);
		C0.add(L3);
		C0.add(Tx3);
		C0.add(L4);
		C0.add(Tx4);
		C0.add(L5);
		C0.add(Tx5);
		C0.add(B6);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == B6){
			int respFinalizar = JOptionPane.showConfirmDialog(null,"Finalizar Compra?","janela",JOptionPane.YES_NO_CANCEL_OPTION);
			if (respFinalizar == 0){
				try{
					//Abrindo o pdf para visualização
					File pdf = new File("C:\\dmr\\PDF_DevMedia.pdf");  
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
			System.out.println();
			
		}
	}
	public static void main(String[] args) {
		Venda Ven = new Venda();
		Ven.setVisible(true);
	}



}
