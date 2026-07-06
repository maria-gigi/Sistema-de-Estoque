package controller;

import java.io.IOException;

import dao.DashboardResumoDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dashboard/resumo")
public class DashboardResumoController extends HttpServlet{
	@Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
     throws IOException{
		
		DashboardResumoDAO dao = new DashboardResumoDAO();
		
        if(dao.gerarResumo()){
        	response.setContentType("application/json");
            response.getWriter().write(dao.getResult());
            
            response.setStatus(HttpServletResponse.SC_OK);
        }else {
        	response.setStatus(HttpServletResponse.SC_BAD_GATEWAY);
        }
    
     }
    
}
