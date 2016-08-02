package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import BD.ConexaoBD;
import Classes.Categoria;

import com.mysql.jdbc.Statement;

public class CadCategoriaDAO {

	public void Salvar(String tc, String td, int id) throws SQLException {
		Connection conn = ConexaoBD.getConnection();
		
		conn.setAutoCommit(false);
		PreparedStatement pstm=null;

		String sql_edit = "INSERT INTO categoria (idCategoria, nome, descricao) VALUES (?,?,?)";
		String sql_save = "INSERT INTO categoria (nome, descricao) VALUES (?,?)";
		
		try{
			
			//Se o ID já existir, Edita
			if(idCategoriaExiste(id)){
				pstm = conn.prepareStatement(sql_edit);
				pstm.setInt(1, id); 
				pstm.setString(2, tc); 
				pstm.setString(3, td);
				pstm.executeUpdate();
			} else { 
			//Senão, Salva
				pstm = conn.prepareStatement(sql_save);
				pstm.setString(1, tc); 
				pstm.setString(2, td);
				pstm.executeUpdate();
			}

			conn.commit();
			
			JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!", "Salvar", JOptionPane.INFORMATION_MESSAGE);  
		} catch (Exception e) {   
			
			if(conn != null){
				conn.rollback();
				System.out.println("Fez o rollback!");
			}
		  	
			JOptionPane.showMessageDialog(null, "Não foi possível salvar os dados!\nInformações sobre o erro: "  
		  						+ e, "Salvar", JOptionPane.ERROR_MESSAGE);  
		  		e.printStackTrace(); 
		  } finally {
		  		ConexaoBD.close(conn, pstm, null);
		  	}  
	}

	@SuppressWarnings("unused")
	public int Excluir(int id) throws SQLException {
		Connection conn = ConexaoBD.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement ps = null;
		 try { 
			 Statement statement = (Statement) conn.createStatement();
			 int deleteCount = statement.executeUpdate("DELETE FROM categoria WHERE idCategoria='id'");	 
			 ps = conn.prepareStatement("DELETE FROM categoria WHERE idCategoria=?");
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

	public int Editar(Categoria c) throws SQLException {
		Connection conn = ConexaoBD.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement pstm=null;

		String sql = "UPDATE categoria SET nome=?, descricao=? WHERE idCategoria= ?";
		
		try{
			
			pstm = conn.prepareStatement(sql);	
			pstm.setString(1, c.getNomeCategoria()); 
			pstm.setString(2, c.getDescricao());  
			pstm.setInt(3,c.getIdCategoria());
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

	public List<Categoria> findCategoria() throws SQLException {
		Connection conn = ConexaoBD.getConnection();
		PreparedStatement pstm= null;
		List<Categoria> categorias = new ArrayList<Categoria>();
		String sql="SELECT * FROM Categoria";
		ResultSet rs = null;
		try{
			pstm=conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				Categoria categoria = new Categoria();
				categoria.setIdCategoria(rs.getInt("idCategoria"));
				categoria.setNomeCategoria(rs.getString("nome"));
				categoria.setDescricao(rs.getString("descricao"));

				categorias.add(categoria);

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível salvar na lista!\nInformações sobre o erro: "  
						+ e, "Salvar", JOptionPane.ERROR_MESSAGE);  
			e.printStackTrace(); 
		} finally {
		  		ConexaoBD.close(conn, pstm, rs);
		}  
		
		return categorias;
	}

	 public boolean idCategoriaExiste(int id){

		 Connection conn = ConexaoBD.getConnection();
    	 PreparedStatement pstm = null; 
    	 ResultSet rs = null;
    	 
		 try{
			 String sql=("SELECT idCategoria FROM categoria WHERE idCategoria="+id+"");
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
	 
	public int descobreIDCategoria(String nomeCat){
   	 	 int id=0;
   	 
		 Connection conn = ConexaoBD.getConnection();
    	 PreparedStatement pstm = null; 
    	 ResultSet rs = null;
    	 
    	 Categoria categ = new Categoria();
    	 
		 try{
			 String sql=("SELECT idCategoria FROM categoria WHERE nome='"+nomeCat+"'");
			 pstm=conn.prepareStatement(sql);
			 rs = pstm.executeQuery();
		 		while(rs.next()){
		 			if((rs.getString(1)).equals(nomeCat)){
		 				System.out.println("Achou!");
		 				id= categ.getIdCategoria();
		 				return id;
		 			}
		 			else {
		 				System.out.println("Não achou!");
		 				return -1;
		 			}
		 		}
		 }catch(Exception e){
			 JOptionPane.showMessageDialog(null, "Informações sobre o erro: "+ e, "Erro", JOptionPane.ERROR_MESSAGE);  
			  		e.printStackTrace(); 
		 }finally{
			 ConexaoBD.close(conn, pstm, rs);
	     }
		return -1;
	}
}


