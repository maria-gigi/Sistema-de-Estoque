package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectionFactory;

public class AdicionarEstoqueDAO {
	public boolean adicionar(int quantidade, String CodBarProduto) {
		String updateProduto = "UPDATE Livros SET quantidade = quantidade + ? WHERE CodBarProduto = ? ";
		String sqlEstoque = "INSERT INTO Estoque VALUES (CodBarProduto, quantidade)";
		
		try(Connection con = ConnectionFactory.getConnection();
	            PreparedStatement stmtupdateProduto = con.prepareStatement(updateProduto);
	            PreparedStatement stmtsqlEstoque = con.prepareStatement(sqlEstoque)){
				
			stmtupdateProduto.setInt(1, quantidade);
			stmtupdateProduto.setString(2, CodBarProduto);
			
			
			stmtsqlEstoque.setInt(2, quantidade);
			stmtsqlEstoque.setString(1,CodBarProduto);

			stmtupdateProduto.executeUpdate();
			stmtsqlEstoque.executeUpdate();
	          
            return true;
          
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
	}
}
