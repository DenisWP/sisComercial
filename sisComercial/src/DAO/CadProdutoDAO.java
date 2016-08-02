package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import BD.ConexaoBD;
import Classes.Produto;

public class CadProdutoDAO {

	public void Salvar(int id, String tn, String vu, String qe, int cat) throws MySQLIntegrityConstraintViolationException {
		Connection conn = ConexaoBD.getConnection();
		
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		PreparedStatement pstm=null;

		String sql_edit = "INSERT INTO produto (idProduto, nome, valoruni, qtdestoque, Categoria_idCategoria) VALUES (?,?,?,?,?)";
		String sql_save = "INSERT INTO produto (nome, valoruni, qtdestoque, Categoria_idCategoria) VALUES (?,?,?,?)";
		
		try{
			
			//Se o ID já existir, Edita
			if(idProdutoExiste(id)){
				pstm = conn.prepareStatement(sql_edit);
				pstm.setInt(1, id); 
				pstm.setString(2, tn); 
				pstm.setString(3, vu);
				pstm.setString(4, qe);
				pstm.setInt(5, cat);
				pstm.executeUpdate();
			} else { 
			//Senão, Salva
				pstm = conn.prepareStatement(sql_save);
				pstm.setString(1, tn); 
				pstm.setString(2, vu);
				pstm.setString(3, qe);
				pstm.setInt(4, cat);
				pstm.executeUpdate();
			}

			conn.commit();
			
			JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!", "Salvar", JOptionPane.INFORMATION_MESSAGE);  
		} catch (SQLException e) {   
			
			if(conn != null){
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.out.println("Fez o rollback!");
			}
		  	
			JOptionPane.showMessageDialog(null, "Não foi possível salvar os dados!\nInformações sobre o erro: "  
		  						+ e, "Salvar", JOptionPane.ERROR_MESSAGE);  
		  		e.printStackTrace(); 
		  }
			  finally {
		  
		  		ConexaoBD.close(conn, pstm, null);
		  	}  
		
	}

	public int Excluir(int id) throws SQLException {
		Connection conn = ConexaoBD.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement ps = null;
		 try { 
			 Statement statement = (Statement) conn.createStatement();
			 int deleteCount = statement.executeUpdate("DELETE FROM produto WHERE idProduto='id'");	 
			 ps = conn.prepareStatement("DELETE FROM produto WHERE idProduto=?");
			 ps.setInt(1, id); 
			 deleteCount = ps.executeUpdate();
			 conn.commit();
			 JOptionPane.showMessageDialog (null, "Removido com sucesso!");
			 } catch (SQLException e) {
				 JOptionPane.showMessageDialog(null, "Tente novamente.");
				 System.err.println(e.getMessage());
			 } finally {  
			   ConexaoBD.close(conn, ps, null);
			 }
		return id;	
	}

	public int Editar(Produto produto) throws SQLException {
		Connection conn = ConexaoBD.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement pstm=null;

		String sql = "UPDATE produto SET nome=?, valoruni=?, qtdestoque=?, Categoria_idCategoria=? WHERE idProduto= ?";
		
		try{
			
			pstm = conn.prepareStatement(sql);	
			pstm.setString(1, produto.getNome()); 
			pstm.setString(2, produto.getValoruni());  
			pstm.setInt(3,produto.getQtdestoque());
			pstm.setInt(4,produto.getCategoria_idCategoria());
			pstm.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {   
			
			if(conn != null){
				conn.rollback();
				System.out.println("Fez o rollback!");
			}
			
			JOptionPane.showMessageDialog(null, "Não foi possível editar os dados!\nInformações sobre o erro: "  
		  						+ e, "Salvar", JOptionPane.ERROR_MESSAGE);  
		  		e.printStackTrace(); 
		  } finally {
		  		ConexaoBD.close(conn, pstm, null);
		 }   
		
		return 0;
		
		
	}
	
	public List<Produto> findProduto() {
		Connection conn = ConexaoBD.getConnection();
		PreparedStatement pstm= null;
		List<Produto> produtos = new ArrayList<Produto>();
		String sql="SELECT * FROM produto";
		ResultSet rs = null;
		try{
			pstm=conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				Produto produto = new Produto();
				produto.setIdProduto(rs.getInt("idProduto"));
				produto.setNome(rs.getString("nome"));
				produto.setValoruni(rs.getString("valoruni"));
				produto.setQtdestoque(rs.getInt("qtdestoque"));
				produto.setCategoria_idCategoria(rs.getInt("Categoria_idCategoria"));
				
				produtos.add(produto);

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível salvar na lista!\nInformações sobre o erro: "  
						+ e, "Salvar", JOptionPane.ERROR_MESSAGE);  
			e.printStackTrace(); 
		} finally {
		  		ConexaoBD.close(conn, pstm, rs);
		}  
		
		return produtos;
	}
	
	public boolean idProdutoExiste(int id) {
		 Connection conn = ConexaoBD.getConnection();
    	 PreparedStatement pstm = null; 
    	 ResultSet rs = null;
    	 
		 try{
			 String sql=("SELECT idProduto FROM produto WHERE idProduto="+id+"");
			 pstm=conn.prepareStatement(sql);
			 rs = pstm.executeQuery();
		 		while(rs.next()){
		 			if((rs.getInt(1))==id){
		 				System.out.println("Existe!");
		 				return true;
		 			}
		 			else {
		 				System.out.println("Não existe!");
		 				return false;
		 			}
		 		}
		 }catch(Exception e){
			 JOptionPane.showMessageDialog(null, "Informações sobre o erro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);  
			  		e.printStackTrace(); 
		 }finally{
			 ConexaoBD.close(conn, pstm, rs);
	     }
		 return false;     
	}

}
