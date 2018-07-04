
package banco.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet{
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response
    ) throws IOException, ServletException{
       request.getSession().removeAttribute("user");
       response.sendRedirect(request.getContextPath());
    }
}
