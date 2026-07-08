package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import connection.ConnectionFactory;

public class LivroAttributeDAO {
	public String exibir(){
		String sql = "SELECT codigoBarras, titulo, editora, genero,"
				+ "localArmazenamento, dataPublicacao, quantidade"
				+ "quantidadeMin, valor FROM Livros";

		
		try(var con = ConnectionFactory.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery()){
			
			List<Map<String, String>> list = new ArrayList<>();
			while(rs.next()) {
				Map<String, String> Livro = new HashMap<>();
				Livro.put("codigoBarras",rs.getString(1));
				Livro.put("titulo",rs.getString(2));
				Livro.put("editora",rs.getString(3));
				Livro.put("genero",rs.getString(4));
				Livro.put("localArmazenamento",rs.getString(5));
				Livro.put("dataPublicacao",rs.getString(6));
				Livro.put("quantidade",rs.getString(7));
				Livro.put("quantidadeMin",rs.getString(8));
				Livro.put("valor",rs.getString(9));
				
				list.add(Livro);
			}
			
			return new Gson().toJson(list);
		}catch(SQLException esql) {
			esql.printStackTrace();
			throw new Error("Erro na procura de produto");
		}
		
	}
	
	

}
