package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import Telas.CadEmpresa;
import Telas.Princ;
import BD.ConexaoBD;
import Classes.Empresa;

public class CadEmpresaDAO {

	private Connection con;
	Statement empresa;
	ResultSet rs;
	Princ princ;
	CadEmpresa ce;
	
	public CadEmpresaDAO() throws SQLException{
	 	con= ConexaoBD.getConnection();
	}
	
	@SuppressWarnings("static-access")
	public void Salvar(Empresa empresa) throws SQLException {  
		 // Pega a conexão estabelecida  
		 Connection conn = this.con;   
		  
		 try {  
		  // Monta a string sql  
			 String sql = "INSERT INTO empresa"+ "(CNPJ, inscEst, rSocial, nFantasia, rua, bairro, cidade, estado, tel, comercial)" +
					 " VALUES(?,?,?,?,?,?,?,?,?,?)";
 
		  // Passa a string para o PreparedStatement  
		  PreparedStatement pstm = conn.prepareStatement(sql);  
		  
		  // Coloca os verdadeiros valores no lugar dos ?, ?  
		  pstm.setString(1, empresa.getCNPJ()); 
		  pstm.setString(2, empresa.getInscEst());
		  pstm.setString(3, empresa.getrSocial());
		  pstm.setString(4, empresa.getnFantasia());
		  pstm.setString(5, empresa.getRua());
		  pstm.setString(6, empresa.getBairro());
		  pstm.setString(7, empresa.getCidade());
		  pstm.setString(8, empresa.getEstado());
		  pstm.setString(9, empresa.getTel());
		  pstm.setString(10, empresa.getComercial());
		  
		  
		  // Executa  
		  pstm.execute();  
		  
		  // Retorna uma mensagem  
		  JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!", "Salvar", JOptionPane.INFORMATION_MESSAGE);  
		  } catch (SQLException e) {  
		  // Retorna uma mensagem informando o erro  
		  JOptionPane.showMessageDialog(null,  
		    "Não foi possível salvar os dados!\nInformações sobre o erro: "  
		      + e, "Salvar", JOptionPane.ERROR_MESSAGE);  
		  e.printStackTrace();  
		 } finally {
			 con.close();
		 }
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
	 }

	public void Procurar() {
		try{
			String SQL = "SELECT * FROM empresa";
			rs = empresa.executeQuery(SQL);
			rs.next();
			do{
				this.Preencher();	
			}while(rs.next());
					
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro de SQL","Mensagem",1);
		
		}
	}

	public void Excluir() throws SQLException {
		Connection conn = ConexaoBD.getConnection();	 
  	 	java.sql.Statement st; 
		st=conn.createStatement();	
		String CNPJ=JOptionPane.showInputDialog("Digite o CNPJ da sua empresa:");
		int deleteCount = st.executeUpdate("DELETE FROM empresa WHERE cnpj='CNPJ'");	 
		PreparedStatement ps = conn.prepareStatement("DELETE FROM empresa WHERE cnpj=?");
		ps.setString(1, CNPJ); 
		deleteCount = ps.executeUpdate();
		if(deleteCount==1){
			JOptionPane.showMessageDialog(null, "Deletado com sucesso.", "Deletar", JOptionPane.INFORMATION_MESSAGE); 
		}
		else{
			JOptionPane.showMessageDialog(null, "Não há registros.", "Deletar", JOptionPane.INFORMATION_MESSAGE);
		}

	}
	
	public void Editar() throws SQLException {
		Preencher();
		
		String A = ce.TF1.getText();
		String B = ce.Tx4.getText();
		String C = ce.Tx4.getText();
		String D = ce.TF2.getText();
		String E = ce.Tx5.getText();
		String F = ce.Tx6.getText();
		String G = ce.Tx8.getText();
		String H = ce.CB9.getToolTipText();
		String I = ce.TF10.getText();
		String J = ce.TF11.getText();
		String K = ce.Tx7.getText();
		
		
		String SQL = "UPDATE empresa " +
			     "SET rSocial ='"+B+"'"+
			          " ,nFantasia ='"+C+"'"+
			          " ,inscEst ='"+D+"'"+
			          " ,rua ='"+E+"'"+
			          " ,bairro ='"+F+"'"+
			          " ,cidade ='"+G+"'"+
			          " ,estado ='"+H+"'"+
			          " ,tel ='"+I+"'"+
			          " ,comercial ='"+J+"'"+
			          " ,num ='"+K+"'"+
			      " WHERE cnpj ="+A+"";
		
		empresa.executeUpdate(SQL);

	}

	public void Preencher() throws SQLException {
		ce.TF1.setText(rs.getString("cnpj"));
		ce.Tx4.setText(rs.getString("rSocial"));
		ce.Tx4.setText(rs.getString("nFantasia"));
		ce.TF2.setText(rs.getString("inscEst"));
		ce.Tx5.setText(rs.getString("rua"));
		ce.Tx6.setText(rs.getString("bairro"));
		ce.Tx8.setText(rs.getString("cidade"));
		ce.CB9.setToolTipText(rs.getString("estado"));
		ce.TF10.setText(rs.getString("tel"));
		ce.TF11.setText(rs.getString("comercial"));
		ce.Tx7.setText(rs.getString("num"));		
	}
	
	public static boolean isEmpty() throws SQLException{
   	 	 Connection conn = ConexaoBD.getConnection();	 
   	 	 java.sql.Statement st; 
		 st=conn.createStatement();
		 ResultSet rs = st.executeQuery("SELECT CNPJ FROM empresa");
		 if(rs.next()){
			 	return false;
		 }
		 else{
			 return true;
		 }
	}
}
