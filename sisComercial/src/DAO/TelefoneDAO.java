package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import BD.ConexaoBD;
import Classes.Telefone;

public class TelefoneDAO {

	private Connection con;
	
	Connection conn = this.con; 
	
	public TelefoneDAO() throws SQLException {
		con= ConexaoBD.getConnection();
	}
	
	public int Salvar(String tel, String cel) throws SQLException {
		Connection conn = this.con;  
		Telefone t = new Telefone();
		
		int idT;
		
		try {  
 
			 String sql = "INSERT INTO telefone (fixo, cel) VALUES (?,?)";   
			 PreparedStatement pstm = conn.prepareStatement(sql);
			 pstm.setString(1, tel);
			 pstm.setString(2, cel);
			 pstm.executeUpdate(); 
		  
				System.out.println("Telefone salvo com sucesso!");
				} catch (SQLException e) {   
				  		System.out.println("Erro ao salvar o telefone.");
				  		e.printStackTrace(); 
				} finally {
				  		con.close();
			}
				
			idT=t.getIdTelefone();
			
			return idT;
	}
}
