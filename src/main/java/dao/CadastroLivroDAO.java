package dao;

import connection.ConnectionFactory;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.CadastroLivroModel;
import java.sql.SQLException;
import model.CadastroLivroModel;

public class CadastroLivroDAO {
    public boolean salvar(CadastroLivroModel model){
    	String sql = "INSERT INTO Livros " + 
                "(codigoBarras, titulo, editora, genero, localArmazenamento, "
                + "dataPublicacao, quantidade, quantidadeMin, valor) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ? ,?)";
       String queryEstoque = "INSERT INTO Estoque (CodBarProduto, quantidade) "
       		+ "VALUES (?,?)";
        try(Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement stmtqueryEstoque = con.prepareStatement(queryEstoque)){
            
            stmt.setString(1, model.getCodigoBarras());
            stmt.setString(2, model.getTitulo());
            stmt.setString(3, model.getEditora());
            stmt.setString(4, model.getGenero());
            stmt.setString(5, model.getLocalArmazenamento());
            stmt.setDate(6, java.sql.Date.valueOf(LocalDate.parse(model.getDataPublicacao())));
            stmt.setInt(7, Integer.parseInt(model.getQuantidade()));
            stmt.setInt(8, Integer.parseInt(model.getQuantidadeMin()));
            stmt.setBigDecimal(9,  BigDecimal.valueOf(Double.parseDouble(model.getValor())) );

            
            stmt.executeUpdate();
            
            stmtqueryEstoque.setString(1, model.getCodigoBarras());
            stmtqueryEstoque.setInt(2, Integer.parseInt(model.getQuantidade()) );
            
            stmtqueryEstoque.executeUpdate();
            return true;
          
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
                
    }
    
}
