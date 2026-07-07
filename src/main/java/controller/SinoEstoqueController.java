package controller;

import java.io.IOException;

import dao.SinoEstoqueDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/notificacao/estoque")
public class SinoEstoqueController extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest resquest, HttpServletResponse response) {
		SinoEstoqueDAO sino = new SinoEstoqueDAO();
		
		response.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("application/json");
		
		try {
			response.getWriter().write(sino.verificarStatus());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
