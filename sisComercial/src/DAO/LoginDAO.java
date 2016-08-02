package DAO;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BD.ConexaoBD;
import Classes.Login;
import Telas.Princ;

public class LoginDAO {

	 private Connection con;
	 public Princ princ;
	
	 int idLogin;
	 
	 public LoginDAO() throws SQLException{
		 	con= ConexaoBD.getConnection();
	 }
	 
	 public String Acesso(Login login, int nivel) throws SQLException{
		 	Connection conn = this.con;
		 		 
	        String status = "Acesso Negado";
	        String usuario = "", senha = ""; 
	        nivel=-1;
	        try {
	        	java.sql.Statement stmt = conn.createStatement();
	        	String sql=("SELECT usuario,senha,nivel FROM login");
			 	ResultSet rs = stmt.executeQuery(sql);
	            while (rs.next()) {
	                usuario = rs.getString(1);
	                senha = rs.getString(2);
	                nivel= rs.getInt(3);
	                
	                if (login.getUsuario().equals(usuario) && login.getSenha().equals(senha)) {
	                    		status = "Acesso Permitido";
	                    		ControleAcesso(nivel);	                    		
	                } 
	            }
	            stmt.close();
	            con.close();
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
	        JOptionPane.showMessageDialog(null,status);
	        return status;
	    }

	@SuppressWarnings("unused")
	private String md5(String senha) {
		try {
			MessageDigest digs = MessageDigest.getInstance("MD5");
			digs.update((new String(senha)).getBytes("UTF8"));
			String str = new String(digs.digest());
			return str;
		} catch (Exception ex) {
				return "Erro no Login!";
    	  }

	 }
	
	
	 @SuppressWarnings({ "static-access" })
	private void ControleAcesso(int nivel) throws SQLException {		 	 					
		switch(nivel){	
				case 1:
						System.out.println("Usuario com privilegios de administrador");
						princ = new Princ();
						
						if(CadEmpresaDAO.isEmpty()){	
							princ.cadEmpr.setEnabled(true); 
							princ.logout.setEnabled(true);
							princ.sair.setEnabled(true);
							princ.cadEmpr.setEnabled(true);
							princ.cadCliF.setEnabled(false);
							princ.cadCliJ.setEnabled(false);
							princ.cadFun.setEnabled(false);
							princ.perFun.setEnabled(false);
							princ.cadPro.setEnabled(false);
							princ.vend.setEnabled(false);
							princ.est.setEnabled(false);
							princ.relCli.setEnabled(false);
							princ.relProd.setEnabled(false);
							princ.sobre.setEnabled(false);
							princ.setVisible(true);
							JOptionPane.showMessageDialog(princ, "Cadastre a sua empresa antes de ter acesso ao programa!"); 
						} else {
							princ.logout.setEnabled(true);
							princ.sair.setEnabled(true);
							princ.cadEmpr.setEnabled(false);
							princ.cadCliF.setEnabled(true);
							princ.cadCliJ.setEnabled(true);
							princ.cadFun.setEnabled(true);
							princ.perFun.setEnabled(true);
							princ.cadPro.setEnabled(true);
							princ.vend.setEnabled(true);
							princ.est.setEnabled(true);

							princ.sobre.setEnabled(true);
							princ.setVisible(true);	
						}
						
						princ.setVisible(true);
						break;
				case 2:
						System.out.println("Usuario com privilegios de gerente");
						princ = new Princ();
						princ.logout.setEnabled(true);
						princ.sair.setEnabled(true);
						princ.cadEmpr.setEnabled(false);
						princ.cadCliF.setEnabled(true);
						princ.cadCliJ.setEnabled(true);
						princ.cadFun.setEnabled(true);
						princ.perFun.setEnabled(true);
						princ.cadPro.setEnabled(true);
						princ.vend.setEnabled(true);
						princ.est.setEnabled(true);
						princ.relCli.setEnabled(true);
						princ.relProd.setEnabled(true);
						princ.sobre.setEnabled(true);
						princ.setVisible(true);
						break;
						
				case 3:
						System.out.println("Usuario com privilegios de vendedor");
						princ = new Princ();
						princ.logout.setEnabled(true);
						princ.sair.setEnabled(true);
						princ.cadEmpr.setEnabled(false);
						princ.cadCliF.setEnabled(false);
						princ.cadCliJ.setEnabled(false);
						princ.cadFun.setEnabled(false);
						princ.perFun.setEnabled(false);
						princ.cadPro.setEnabled(false);
						princ.vend.setEnabled(true);
						princ.est.setEnabled(true);
						princ.relCli.setEnabled(true);
						princ.relProd.setEnabled(true);
						princ.sobre.setEnabled(true);
						princ.setVisible(true);
						break;
		}
			
	   
	}
	 
	public int Salvar(Login l) throws SQLException{
		Connection conn = this.con;
		int idL;		
		
		try{
			
			String sql = "INSERT INTO login (usuario, senha, nivel) VALUES (?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1,l.getUsuario());
			pstm.setString(2,l.getSenha());
			pstm.setInt(3,l.getNivel());
			pstm.executeUpdate();
				
			System.out.println("Login salvo com sucesso!");
			} catch (SQLException e) {   
			  		System.out.println("Erro ao salvar o login.");
			  		e.printStackTrace(); 
			} finally {
			  		con.close();
		}
			
		idL=l.getIdLogin();
		
		return idL;
	}
	
	
	public Login Pesquisar(int id) throws SQLException{
		 Connection conn = this.con; 	 
    	 java.sql.Statement st; 
		 st=conn.createStatement();
		 
		 Login log = new Login();
		 ResultSet rs = st.executeQuery("SELECT idLogin, usuario, senha, nivel FROM login");
		 while(rs.next()){
			 if((rs.getInt(1))==id){
				 log.setUsuario(rs.getString(2));
				 log.setSenha(rs.getString(3));
				 log.setNivel(rs.getInt(4));
			 }
		 }
	     con.close();          

		return log;	
	}
	 
} 
	 



