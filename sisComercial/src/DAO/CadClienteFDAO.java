package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BD.ConexaoBD;
import Classes.Cliente;
import Classes.Endereco;
import Classes.PFisica;
import Classes.Telefone;

import com.mysql.jdbc.Statement;

public class CadClienteFDAO {
	
	private Connection con;
	EnderecoDAO enderecoDAO;
	TelefoneDAO telefoneDAO;
	Endereco endereco;
	Telefone telefone;
	
	public CadClienteFDAO() throws SQLException {
		con= ConexaoBD.getConnection();
	}

	@SuppressWarnings("null")
	public void Salvar(PFisica pfisica) throws SQLException {
		 Connection conn = this.con;    
		 
		 try {  
//			  enderecoDAO.Salvar();
//			  telefoneDAO.Salvar();
			  // Monta a string sql  
			  String sql = "INSERT INTO pfisica"+ "(nome, obs, Endereco_idEndereco, Telefone_idTelefone, cpf, rg)" + " VALUES(?,?,?,?,?,?)"; 
			  // Passa a string para o PreparedStatement 
			  PreparedStatement pstm = conn.prepareStatement(sql);
		  
			  // Coloca os verdadeiros valores no lugar dos ?, ?  
			  pstm.setString(1, pfisica.getNome());  
			  pstm.setString(2, pfisica.getObs()); 
			  pstm.setInt(3, pfisica.getEndereco_idEndereco());
			  pstm.setInt(4, pfisica.getTelefone_idTelefone());
			  pstm.setString(5, pfisica.getCPF()); 
			  pstm.setString(6, pfisica.getRG());
		  
			  // Executa  
			  pstm.executeUpdate(); 
		  
			  // Retorna uma mensagem  
			  JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!", "Salvar", JOptionPane.INFORMATION_MESSAGE);  
		  	} catch (SQLException e) {  
		  		// Recotorna uma mensagem informando o erro  
		  		JOptionPane.showMessageDialog(null, "Não foi possível salvar os dados!\nInformações sobre o erro: "  
		  						+ e, "Salvar", JOptionPane.ERROR_MESSAGE);  
		  		e.printStackTrace();  
		  	} finally {
		  		con.close();
		 }
	}

	@SuppressWarnings("unused")
	public void Excluir() throws SQLException {
		Connection conn = this.con; 
		 try { 
			 String aux=JOptionPane.showInputDialog("Qual o código do cliente para apagar?");
			 int id=Integer.parseInt(aux); 
			 Statement statement = (Statement) conn.createStatement();
			 int deleteCount = statement.executeUpdate("DELETE FROM pfisica WHERE Cliente_idCliente='id'");	 
			 PreparedStatement ps = conn.prepareStatement("DELETE FROM pfisica WHERE Cliente_idCliente=?");
			 ps.setInt(1, id); 
			 deleteCount = ps.executeUpdate();
			 } catch (SQLException e) {
				 System.err.println(e.getMessage());
			 } 
		   finally {  
			      con.close();          
			   }
		
	}

	public void Procurar() {
		
		
	}

}
