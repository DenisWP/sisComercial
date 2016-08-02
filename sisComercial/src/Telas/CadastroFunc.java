package Telas;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import BD.ConexaoBD;
import Classes.CargoFunc;
import DAO.CadastroFuncDAO;
import DAO.EnderecoDAO;
import DAO.LoginDAO;
import DAO.TelefoneDAO;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


@SuppressWarnings("serial")
public class CadastroFunc extends CadClienteF {
	@SuppressWarnings("rawtypes")
	public JComboBox CB16, CB17;
	JTextField Tx18, txtCat;
	JLabel lCat, lDesc, L16, L17, L18;
	JButton bCadLogin;
	
	String horaTrab;
	String[] Horario = {"6:00am - 16:00pm", "7:00am - 17:00pm", "8:00am - 18:00pm", "10:00am - 20:00pm","12:00pm - 22:00pm"};
	
	CargoFunc cfunc;
	float salario;
	CadastroPermissoes cp;
	
	Connection con=null;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CadastroFunc(){
		setTitle("Cadastro de Funcionário");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img//dmr_icon.png"));
		
		L1.setVisible(false);
		L2.setVisible(false);
		L4.setVisible(false);
		L5.setVisible(false);
		L6.setVisible(false);
		Rb5.setVisible(false);
		Rb6.setVisible(false);
		L15.setVisible(true);
		Ta15.setVisible(true);
		
		
		lCat = new JLabel("Código Funcionário");
		lCat.setBounds(50, 50, 130, 40);
		//CadastroFuncDAO cfdao = new CadastroFuncDAO();
		//int id = cfdao.findMaxId();
		//txtCat = new JTextField(id+1);
		txtCat = new JTextField("");
		txtCat.setBounds(50,90,100,20);
		txtCat.setEditable(false);
		
		lDesc = new JLabel("CPF");
		lDesc.setBounds(220, 50, 40, 40);
		
		bCadLogin = new JButton("Cadastrar Login");
		bCadLogin.setBounds(550, 90, 150, 20);	
		bCadLogin.setVisible(true);
		
    	L15.setBounds(50, 410,100, 40 );
		Ta15.setBounds(50, 450, 650, 40);
		
		L16 = new JLabel("Cargo");
		L16.setBounds(50, 350,100, 40 );
		CB16 = new JComboBox();
		CB16.setBounds(50,390,200,20);
 
		carregaComboBox();
        
		L17 = new JLabel("Horário de Trabalho");
		L17.setBounds(300, 350,130, 40 );
		CB17 = new JComboBox(Horario);
		CB17.setBounds(300,390,200,20);
		
		L18 = new JLabel("Salário");
		L18.setBounds(550, 350,130, 40 );
		Tx18 = new JTextField(" ");
		Tx18.setBounds(550,390,150,20);
		Tx18.setEditable(false);	
		
		salario = carregaSalario();
		System.out.println(salario);
		Tx18.setText(Float.toString(salario));
		
		C1.add(lCat);
		C1.add(lDesc);
		C1.add(txtCat);
		C1.add(bCadLogin);
		C1.add(L16);
		C1.add(CB16);
		C1.add(L15);
		C1.add(Ta15);
		C1.add(L17);
		C1.add(CB17);
		C1.add(L18);
		C1.add(Tx18);
		
		
		CB17.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	          horaTrab = (String)(CB17.getSelectedItem()); 
	        	}
			}
		);
		
		/**
		 * Implementando ações dos botões
		 */
			
			//"Salvar"
			B1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						con.setAutoCommit(false);
						int idL=0, idT=0, idE=0, nivel = 0, num;
						String rua, bairro, cidade,estado, tel, cel, cpf, rg, nome, horario, obs, usuario, senha;
						
						//Salva parte do Endereco
						rua=Tx8.getText();
						num=Integer.parseInt(Tx10.getText());
						bairro=Tx9.getText();
						cidade=Tx11.getText();
						estado=CB12.getSelectedItem().toString();
						EnderecoDAO end = new EnderecoDAO();
						idE=end.Salvar(rua,num,bairro,cidade,estado);

								
						//Salva a parte do Telefone
						tel=Tx13.getText();
						cel=Tx14.getText();
						TelefoneDAO t = new TelefoneDAO();
						idT=t.Salvar(tel,cel);
						
												
						//Salva a parte dos dados do Funcionario
						cpf= TF2.getText();
						rg= TF3.getText();
						nome= Tx7.getText();
						horario= CB17.getSelectedItem().toString();
						obs=Ta15.getText();
						
						
						cp = new CadastroPermissoes();
						idL=cp.login.getIdLogin();
						usuario=cp.login.getUsuario();
						senha=cp.login.getSenha();
						nivel=cp.login.getNivel();
						
						
						CadastroFuncDAO c = new CadastroFuncDAO();
						c.Salvar(cpf,rg,nome,horario,obs,idL, idT, idE, usuario, senha, nivel);
						
						
						CadastroPermissoes cp = new CadastroPermissoes();
						LoginDAO lDAO = new LoginDAO();  
						idL = lDAO.Salvar(cp.login);
						
						con.commit();
						
					} catch (SQLException e1) {
						e1.printStackTrace();
						try {
							con.rollback();
						} catch (SQLException e2) {
							e2.printStackTrace();
						}
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
					dispose();
				}
			});		
			
			//"Excluir"
			B4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			
			//"Procurar"
			B5.setEnabled(false);
	
			//"Cadastrar Login"
			bCadLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CadastroPermissoes CadPer = new CadastroPermissoes();
					CadPer.setVisible(true);
				}
			});
			
			
	}

	@SuppressWarnings("unchecked")
	public void carregaComboBox(){    
	          try{     
	              java.sql.Connection conn;    
	              conn = ConexaoBD.getConnection();
	              Statement st = (Statement) conn.createStatement();    
	              ResultSet rs = st.executeQuery("SELECT nome FROM cargo ORDER BY nome" );    
	              while(rs.next()){   
	            	  CB16.addItem(rs.getString("nome"));    
	              }    
	              rs.close(); 
	              st.close();
	              conn.close();    
	          }    
	          catch(Exception e){    
	              JOptionPane.showMessageDialog(null, "Erro ao carregar os cargos!", "Erro", JOptionPane.ERROR_MESSAGE);    
	          }         
	  }    
	
	
	private float carregaSalario(){

		java.sql.Connection conn; 
		PreparedStatement pstm = null; 
		CargoFunc cargoF = new CargoFunc();
        try {
        	String cargo;
			conn = ConexaoBD.getConnection(); 
			cargo=CB16.getSelectedItem().toString();
			String sql="SELECT salario FROM cargo WHERE nome='"+cargo+"'";
			pstm=conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
				while(rs.next()){
						salario=cargoF.getSalario();		
				}
		} catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Erro ao carregar o salário!", "Erro", JOptionPane.ERROR_MESSAGE); 
			e.printStackTrace();
		}   
		return salario;
	}
	
	
	public static void main(String[] args) {
		CadastroFunc CadF = null;
		CadF = new CadastroFunc();
		CadF.setVisible(true);

	}

}
