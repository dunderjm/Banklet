package banco.controller;

import banco.model.Cliente;
import banco.model.DAO.ClienteDAO;
import banco.model.DAO.ConnectionFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/login")
public class Login extends HttpServlet{
   
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response){
        try(Connection con = new ConnectionFactory().getConnection()){
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            Cliente cliente = new ClienteDAO(con).buscaEmaileSenha(email, senha);
            PrintWriter writer = response.getWriter();
            if(cliente == null){
               //Implementar error
            }else{
                HttpSession session = request.getSession();
                session.setAttribute("user", cliente);
                response.sendRedirect(request.getContextPath() + "/app?tarefa=ClientePage");
            }
            
        }catch(SQLException | IOException ex){
            throw new RuntimeException(ex);
        }
      
    }
    
}
