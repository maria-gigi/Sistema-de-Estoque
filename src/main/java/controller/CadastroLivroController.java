package controller;

import dao.CadastroLivroDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.CadastroLivroModel;

@WebServlet("/cadastro/livro")
public class CadastroLivroController extends HttpServlet{
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            CadastroLivroModel produto = new CadastroLivroModel();
                    
            produto.setCodigoBarras(request.getParameter("codigoBarras"));
            produto.setTitulo(request.getParameter("titulo")); 
            produto.setEditora(request.getParameter("editora"));
            produto.setGenero(request.getParameter("genero"));
            produto.setLocalArmazenamento(request.getParameter("localArmazenamento"));
            produto.setDataPublicacao(request.getParameter("dataPublicacao"));
            produto.setQuantidade(request.getParameter("quantidade"));
            produto.setQuantidadeMin(request.getParameter("quantidadeMin"));
            produto.setValor(request.getParameter("valor"));
            
            CadastroLivroDAO dao = new CadastroLivroDAO();
            
            if(dao.salvar(produto)){
                response.sendRedirect("pages/dashboard.html");
            }else{
                response.sendRedirect("pages/cadastroProdutos.html");
            }
        }
    }
