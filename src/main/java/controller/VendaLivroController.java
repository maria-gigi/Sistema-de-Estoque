package controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.VendaLivroModel;

import java.io.IOException;

import dao.VendaLivroDAO;

@WebServlet("/venda/produto")
public class VendaLivroController extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		VendaLivroModel model = new VendaLivroModel();
		
		model.setCodigoBarras(request.getParameter("codigoBarras"));
		model.setQuantidade(request.getParameter("quantidade"));
		model.setDesconto(request.getParameter("desconto"));
		model.setDesconto(request.getParameter("valorTotal"));
        
        VendaLivroDAO dao = new VendaLivroDAO();
        
        if(dao.salvar(model)){
            response.sendRedirect("pages/dashboard.html");
        }else{
            response.sendRedirect("pages/vendaLivros.html");
        }
    }
}


