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
         
         String titulo = request.getParameter("titulo");
         String genero = request.getParameter("genero");
         String data = request.getParameter("data");
         
         DashboardEstoqueDAO dao = new DashboardEstoqueDAO();
         String resultado = dao.listarComFiltro(titulo, genero ,data);
         
         response.setContentType("application/json");
         response.setCharacterEncoding("UTF-8");
         response.getWriter().write(resultado);
     }
     
    
}