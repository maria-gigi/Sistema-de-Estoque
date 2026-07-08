package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;

public class SinoEstoqueDAO {
	public String  verificarStatus() {
		String sql = "SELECT quantidade, quantidadeMin FROM Livros";
		
		var con = ConnectionFactory.getConnection();
		try(PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();){
			String status = null;
			
			while(rs.next()) {
				
				status ="COM ESTOQUE";
				
				if(0 == rs.getInt(1)){
					status = "ACABOU";
					break;
				} 
				
				if(rs.getInt(2) > rs.getInt(1)) {
					status ="ACABANDO";
				}
				
			}
			
			
			String textoJson = """
				    { "status": "%s" }
				    """.formatted(status);
			
			return textoJson;
			
		}catch(SQLException esql) {
			esql.printStackTrace();
			throw new Error("Erro ao verificar o Status");
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				throw new Error("Erro ao fechar conexao com o banco");
			}
		}
	}
}
