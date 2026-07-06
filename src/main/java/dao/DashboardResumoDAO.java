package dao;

import com.google.gson.Gson;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class DashboardResumoDAO {
	private String result;
	public boolean gerarResumo(){
	         
		String sqlEstoque = "SELECT SUM(quantidade) FROM Livros" ;
		
		String sqlVenda = "SELECT SUM(quantidade) FROM Venda" ;
		
		try (Connection  conn = ConnectionFactory.getConnection();
	         PreparedStatement stmtEstoque = conn.prepareStatement(sqlEstoque);
			PreparedStatement stmtVenda = conn.prepareStatement(sqlVenda);
	         ResultSet rsEstoque = stmtEstoque.executeQuery();
			ResultSet rsVenda = stmtEstoque.executeQuery()){
	            int estoque = 0;
	            int saida = 0;
	            
	            rsEstoque.next();
	            estoque = rsEstoque.getInt(1);

	            rsVenda.next();
	            saida = rsVenda.getInt(1);
        
	            int total = estoque - saida;
	            
	            Map<String, Integer> resultado = new HashMap<>();
	            resultado.put("estoque", estoque);
	            resultado.put("saida", saida);
	            resultado.put("total", total);
	            
	            String json = new Gson().toJson(resultado);
		        this.result = json;
	            return true;
		}catch (Exception e) {
		        e.printStackTrace();
		        return false;
		}
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}



