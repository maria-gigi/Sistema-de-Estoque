package dao;

import connection.ConnectionFactory;
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
            stmt.setDate(5, java.sql.Date.valueOf(LocalDate.parse(model.getDataPublicacao())));
            stmt.setString(6, model.getQuantidade());
            stmt.setString(7, model.getQuantidadeMin());
            stmt.setString(8, model.getValor());

            
            stmt.executeUpdate();
            
            stmtqueryEstoque.setString(1, model.getCodigoBarras());
            stmtqueryEstoque.setInt(2, );
            return true;
          
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
                
    }
    
}
