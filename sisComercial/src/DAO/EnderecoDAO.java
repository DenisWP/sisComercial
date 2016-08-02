package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import BD.ConexaoBD;
import Classes.Endereco;

public class EnderecoDAO {

	private Connection con;
	
	public EnderecoDAO() throws SQLException {
		con= ConexaoBD.getConnection();
	}

	public int Salvar(String rua, int num, String bairro, String cidade, String estado) throws SQLException {
		 Connection conn = this.con;    
		 Endereco e = new Endereco();
		 
		 int idE=0;
		 
		 try{  
			  String sql = "INSERT INTO endereco (rua, bairro, cidade, estado, num) VALUES (?,?,?,?,?)";
			  PreparedStatement pstm = conn.prepareStatement(sql);
			  
			  //Mudar para: e.setRua(rua);
			  pstm.setString(1, rua);
			  pstm.setString(2, bairro);
			  pstm.setString(3, cidade);
			  pstm.setString(4, estado);
			  pstm.setInt(5, num);
			  
			  pstm.executeUpdate(); 
			  
			  System.out.println("Endereco salvo com sucesso!");
		} catch (SQLException e1){   
			  System.out.println("Erro ao salvar o telefone.");
			  e1.printStackTrace(); 
		  } finally{
			  con.close();
			}
				
			idE=e.getIdEndereco();
			
			return idE;
	}
}
