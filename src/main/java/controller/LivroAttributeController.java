package controller;

import dao.LivroAttributeDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/livro")
public class LivroAttributeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		try {
			LivroAttributeDAO livroAttributeDAO = new LivroAttributeDAO();

			response.getWriter().write(livroAttributeDAO.exibir());
			response.setStatus(HttpServletResponse.SC_OK);

			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
