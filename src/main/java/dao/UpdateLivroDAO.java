package dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import connection.ConnectionFactory;
import model.LivroModel;

public class UpdateLivroDAO {
	public boolean atualizar(LivroModel livro) {
		String sqlSeletor = "SELECT id FROM Livros WHERE id = ?";
		String sqlUpdate = "UPDATE Livros SET "
				   + "codigoBarras = ? "
		           + "titulo = ?, "
		           + "editora = ?, "
		           + "genero = ?, "
		           + "localArmazenamento = ?, "
		           + "dataPublicacao = ?, "
		           + "quantidade = ?, "
		           + "quantidadeMin = ?, "
		           + "valor = ? "
		           + "WHERE id = ?";
		
		var con = ConnectionFactory.getConnection();
		try(PreparedStatement stmtSeletor = con.prepareStatement(sqlSeletor);
			PreparedStatement stmtUpdate = con.prepareStatement(sqlUpdate);
			ResultSet rsSeletor = stmtSeletor.executeQuery();){
			
			if(!rsSeletor.next()){
				return false;
			}else {
				rsSeletor.next();
			}
			
			
			stmtUpdate.setString(1, livro.getCodigoBarras());
			stmtUpdate.setString(2, livro.getTitulo());
			stmtUpdate.setString(3, livro.getEditora());
			stmtUpdate.setString(4, livro.getEditora());
			stmtUpdate.setString(5, livro.getLocalArmazenamento());
			stmtUpdate.setDate(6, java.sql.Date.valueOf(LocalDate.parse(livro.getDataPublicacao())));
			stmtUpdate.setInt(7, Integer.parseInt(livro.getQuantidadeMin()));
			stmtUpdate.setInt(8, Integer.parseInt(livro.getQuantidade()));
			stmtUpdate.setBigDecimal(9, BigDecimal.valueOf(Double.parseDouble(livro.getValor())));
			stmtUpdate.setInt(10, rsSeletor.getInt(1));
			
			stmtUpdate.executeQuery();
			return true;
		}catch(SQLException esql) {
			try {
				con.rollback();
			}catch(SQLException e) {
				e.printStackTrace();
				throw new Error("NAO DEU CERTO ROLLBACK");
			}
			return false;
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
				throw new Error("NAO DECHOU A CONEXAO.");
			}
		}
		
	}
}
