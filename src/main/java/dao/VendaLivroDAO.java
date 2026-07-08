package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        	stmtVenda.setBigDecimal(2, BigDecimal.valueOf(Double.parseDouble(model.getValorTotal())));
        	stmtVenda.setInt(3, Integer.parseInt(model.getQuantidade()));
        	stmtVenda.setBigDecimal(4, BigDecimal.valueOf(Double.parseDouble(model.getDesconto())));
            
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
