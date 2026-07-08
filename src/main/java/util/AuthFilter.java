package util;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter{
	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        String uri = req.getRequestURI();

        if(uri.endsWith("index.html") || uri.endsWith("login") || uri.contains(".css") || uri.contains(".js")){
            chain.doFilter(request, response);

            return;
        }
        if(session == null || session.getAttribute("usuario") == null) {
            res.sendRedirect(req.getContextPath()+"index.html");
            return;
        }

        String permissao = (String) session.getAttribute("perfil");
        if(uri.contains("cadastro") && !"admin".equals(permissao)){
            res.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        chain.doFilter(request, response);
    }
}
