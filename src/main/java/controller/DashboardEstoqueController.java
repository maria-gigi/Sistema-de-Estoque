package controller;

import dao.DashboardEstoqueDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/dashboard/estoque")
public class DashboardEstoqueController extends HttpServlet{
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException{
         
         String nome = request.getParameter("filtroNome");
         String tipo = request.getParameter("filtroGenero");
         String editora = request.getParameter("filtroEditora");
         String data = request.getParameter("filtroData");
         
         DashboardEstoqueDAO dao = new DashboardEstoqueDAO();
         String resultado = dao.listarComFiltro(nome,tipo, editora ,data);
         
         response.setContentType("application/json");
         response.setCharacterEncoding("UTF-8");
         response.getWriter().write(resultado);
     }
     
    
}