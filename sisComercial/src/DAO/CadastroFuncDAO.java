package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import BD.ConexaoBD;
import Classes.Funcionario;

public class CadastroFuncDAO {

	private Connection con;
	
	public CadastroFuncDAO() throws SQLException {
		ConexaoBD.getConnection();
	}
	
    public int findMaxId() throws SQLException {
		Connection conn = this.con;
		PreparedStatement pstm=null;
        ResultSet rs = null;
        String sql = "SELECT MAX(idFuncionario) FROM funcionario";
        int id = 0;
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
           // if (rs.next()) {
                id = rs.getInt(1);
           // }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
        return id;
    }
	
	@SuppressWarnings({ "rawtypes", "null" })
	public String[] carregaCargos(JComboBox CB16) throws SQLException {
		String[] nomes = {""};
		int i=0;
		try  
	        {  
	            String sql = "SELECT nome FROM cargo ORDER BY ASC";
	            PreparedStatement stmt = this.con.prepareStatement(sql);  
	            ResultSet rs = null;  
	            while(rs.next()){     
	                nomes[i]= rs.getString("nome").toString();
	            }   
	            rs=stmt.executeQuery();
	        }
	        catch(Exception e)  
	        {  
	            JOptionPane.showMessageDialog(null, "Ocorreu erro ao carregar os Cargos", "Erro", JOptionPane.ERROR_MESSAGE);  
	        }
		return nomes; 
	}
	
	public void Salvar(String cpf, String rg, String nome, String horario, String obs, int idL, int idT, int idE, String usuario, String senha, int nivel) throws SQLException{
		Connection conn = this.con;
		PreparedStatement pstm=null;
		new Funcionario();
		
		System.out.println("Entrou FuncDAO");
			
		try{	
			String sql = "INSERT INTO funcionario (CPF, nome, rg, obs, Endereco_idEndereco, horariotrab, Telefone_idTelefone, Login_idLogin, usuario, senha, nivel) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1,cpf);
			pstm.setString(2,nome);
			pstm.setString(3,rg);
			pstm.setString(4,obs);
			pstm.setInt(5,idE);
			pstm.setString(6,horario);
			pstm.setInt(7,idT);
			pstm.setInt(8,idL);
			pstm.setString(9,usuario);
			pstm.setString(10,senha);
			pstm.setInt(11,nivel);
			
			pstm.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!", "Salvar", JOptionPane.INFORMATION_MESSAGE);  
		} catch (SQLException e) {   
		  		JOptionPane.showMessageDialog(null, "Não foi possível salvar os dados!\nInformações sobre o erro: "  
		  						+ e, "Salvar", JOptionPane.ERROR_MESSAGE);  
		  		e.printStackTrace(); 
		  }
	}
	
}
