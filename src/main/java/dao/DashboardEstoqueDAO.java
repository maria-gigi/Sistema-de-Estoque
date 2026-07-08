package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import connection.ConnectionFactory;
public class DashboardEstoqueDAO {
	public String listarComFiltro(String titulo,String genero ,String data) {
		List<String> listFiltro = new ArrayList<>();
		String sqlFiltro = "SELECT codigoBarras, titulo, editora, genero, "
				+ "localArmazenamento, dataPublicacao, quantidade, valor, quantidadeMin "
				+ "FROM Livros WHERE 1=1";
		
		if(titulo != null && !titulo.trim().isEmpty()) {
			sqlFiltro += " AND titulo = ?";
			System.out.println("Entrou no TITULO");
			listFiltro.add(titulo);
		}
		
		if(genero != null && !genero.trim().isEmpty()) {
			sqlFiltro += " AND genero = ?";
			listFiltro.add(genero);
		}
		
		if(data != null && !data.trim().isEmpty()) {
			sqlFiltro += " AND dataPublicacao >= ?";	
		}
		
		var con = ConnectionFactory.getConnection();
		try(PreparedStatement stmtFiltro = con.prepareStatement(sqlFiltro);){
			int i = 1;
			for(String filtro : listFiltro) {
				stmtFiltro.setString(i, filtro);
				i++;
			}
			
			if(data != null && !data.trim().isEmpty()) {
				stmtFiltro.setDate(i, java.sql.Date.valueOf(LocalDate.parse(data)));	
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
				livro.put("dataPublicacao", LocalDate.parse(rsFiltro.getString(6)).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				livro.put("quantidade", rsFiltro.getString(7));
				livro.put("valor", rsFiltro.getString(8));
				livro.put("quantidadeMin", rsFiltro.getString(9));
				
				if(0 == rsFiltro.getInt(7)){
					livro.put("status", "ACABOU");
				}else if(rsFiltro.getInt(9) > rsFiltro.getInt(7)) {
					livro.put("status", "ACABANDO");
				}
				
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
