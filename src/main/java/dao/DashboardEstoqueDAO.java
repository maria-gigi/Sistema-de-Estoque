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
public class DashboardEstoqueDAO {
	public String listarComFiltro(String nome,String tipo,String editora ,String data) {
		List<String> listFiltro = new ArrayList<>();
		String sqlFiltro = "SELECT codigoBarras, titulo, editora, genero, "
				+ "localArmazenamento, dataPublicacao, quantidade,valor "
				+ "FROM Livros WHERE 1=1";
		
		if(nome != null && !nome.trim().isEmpty()) {
			sqlFiltro += " AND nome = ?";
			listFiltro.add(nome);
		}
		
		if(tipo != null && !tipo.trim().isEmpty()) {
			sqlFiltro += " AND tipo = ?";
			listFiltro.add(tipo);
		}
		if(editora != null && !editora.trim().isEmpty()) {
			sqlFiltro += " AND editora = ?";	
			listFiltro.add(editora);
		}
		
		if(data != null && !data.trim().isEmpty()) {
			sqlFiltro += " AND data = ?";	
		}
		
		var con = ConnectionFactory.getConnection();
		try(PreparedStatement stmtFiltro = con.prepareStatement(sqlFiltro);){
			int i = 1;
			for(String filtro : listFiltro) {
				stmtFiltro.setString(i, filtro);
				i++;
			}
			
			if(data != null && !data.trim().isEmpty()) {
				stmtFiltro.setString( i , data);	
			}
			
			
			ResultSet rsFiltro = stmtFiltro.executeQuery();
			
			List<Map<String, String>> resultado = new ArrayList<>();
			while(rsFiltro.next()) {
				Map<String, String> livro= new HashMap<>();
				
				livro.put("codigoBarras", rsFiltro.getString(1));
				livro.put("titulo", rsFiltro.getString(2));
				livro.put("editora", rsFiltro.getString(3));
				livro.put("genero", rsFiltro.getString(4));
				livro.put("localArmazenamento", rsFiltro.getString(5));
				livro.put("dataPublicacao", rsFiltro.getString(6));
				livro.put("quantidade", rsFiltro.getString(7));
				livro.put("valor", rsFiltro.getString(8));
				
				resultado.add(livro);
			}
			
			return new Gson().toJson(resultado);
			
		}catch(SQLException esql) {
			esql.printStackTrace();
			throw new Error("Erro ao listar os produto no Dashboard");
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				throw new Error("Erro ao fechar conexao com o banco");
			}
		}
	}
}
