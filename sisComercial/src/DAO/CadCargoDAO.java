package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import BD.ConexaoBD;
import Classes.CargoFunc;
import com.mysql.jdbc.Statement;

public class CadCargoDAO {

	public void Salvar(String tc, float ts, String tf, int id) throws SQLException {
		Connection conn = ConexaoBD.getConnection();
		
		conn.setAutoCommit(false);
		PreparedStatement pstm=null;
		
		String sql_edit = "INSERT INTO cargo (idCargo, nome, funcoes, salario) VALUES (?,?,?,?)";
		String sql_save = "INSERT INTO cargo (nome, funcoes, salario) VALUES (?,?,?)";
		
		try{
			
			//Se o ID já existe, Edita
			if(idCargoExiste(id)){
				pstm = conn.prepareStatement(sql_edit);
				pstm.setInt(1, id);
				pstm.setString(2, tc);
				pstm.setString(3, tf);
				pstm.setFloat(4, ts);
				pstm.executeUpdate();
			} else {
			//Senão, Salva
				pstm = conn.prepareStatement(sql_save);
				pstm.setString(1, tc);
				pstm.setString(2, tf);
				pstm.setFloat(3, ts);
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
			 int deleteCount = statement.executeUpdate("DELETE FROM cargo WHERE idCargo='id'");	 
			 ps = conn.prepareStatement("DELETE FROM cargo WHERE idCargo=?");
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
	
	public int Editar(CargoFunc c) throws SQLException {
		Connection conn = ConexaoBD.getConnection();
		conn.setAutoCommit(false);
		PreparedStatement pstm=null;
		
		String sql = "UPDATE cargo SET nome=?, funcoes=?, salario=? WHERE idCargo= ?";
		
		try{
			
			pstm = conn.prepareStatement(sql);	
			pstm.setString(1, c.getCargo()); 
			pstm.setString(2, c.getFuncoes());  
			pstm.setFloat(3, c.getSalario());
			pstm.setInt(4,c.getIdCargo());
			pstm.executeUpdate();
			
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

	public List<CargoFunc> findCargo() throws SQLException {
		Connection conn = ConexaoBD.getConnection();
		PreparedStatement pstm= null;
		List<CargoFunc> cargos = new ArrayList<CargoFunc>();
		String sql="SELECT * FROM cargo";
		ResultSet rs = null;
		try{
			pstm=conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				CargoFunc cargo = new CargoFunc();
				cargo.setIdCargo(rs.getInt("idCargo"));
				cargo.setCargo(rs.getString("nome"));
				cargo.setFuncoes(rs.getString("funcoes"));
				cargo.setSalario(rs.getFloat("salario"));

				cargos.add(cargo);

			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível editar os dados!\nInformações sobre o erro: "  
						+ e, "Salvar", JOptionPane.ERROR_MESSAGE);  
			e.printStackTrace(); 
		} finally {
		  		ConexaoBD.close(conn, pstm, rs);
		} 
		
		return cargos;
	}

	
	public boolean idCargoExiste(int id) {

		 Connection conn = ConexaoBD.getConnection();
    	 PreparedStatement pstm = null; 
    	 ResultSet rs = null;
    	 
		 try{
			 String sql=("SELECT idCardo FROM cargo WHERE idCargo="+id+"");
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
