package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;
import model.VendaLivroModel;

public class VendaLivroDAO{
	public boolean salvar(VendaLivroModel model){
	
		
    	String sqlVenda = "INSERT INTO Venda " + 
                "(CodBarProduto, valorTotal, quantidade, desconto) " +
                "VALUES (?, ?, ?, ?)";
    	
		String sqlLivro = "UPDATE Livros SET quantidade = quantidade - ? "
				+ "WHERE codigoBarras = ? ";
               
        try(Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmtVenda = con.prepareStatement(sqlVenda);
    		PreparedStatement stmtLivro = con.prepareStatement(sqlLivro);){


        	stmtVenda.setString(1,model.getCodigoBarras());
        	stmtVenda.setString(2, model.getValorTotal());
        	stmtVenda.setString(3, model.getQuantidade());
        	stmtVenda.setString(3, model.getDesconto());
            
        	stmtVenda.executeUpdate();
        	
        	stmtLivro.setString(1,model.getQuantidade());
        	stmtLivro.setString(2, model.getCodigoBarras());
        	
        	stmtLivro.executeUpdate();
            
            return true;
          
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
                
    }
	 
}
