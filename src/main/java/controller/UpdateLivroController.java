package controller;

import dao.UpdateLivroDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.LivroModel;

@WebServlet("/editar/produto")
public class UpdateLivroController extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		LivroModel livroModel = new LivroModel(
				request.getParameter("codigoBarras"),
				request.getParameter("titulo"),
				request.getParameter("editora"),
				request.getParameter("genero"),
				request.getParameter("localArmazenamento"),
				request.getParameter("dataPublicacao"),
				request.getParameter("quantidade"),
				request.getParameter("quantidadeMin"),
				request.getParameter("valor"));
		
		UpdateLivroDAO updateLivroDAO = new UpdateLivroDAO();
		
		if(updateLivroDAO.atualizar(livroModel)){
			response.setStatus(HttpServletResponse.SC_OK);
		}else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		
	}
}
