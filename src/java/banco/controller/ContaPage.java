package banco.controller;

import banco.model.Cliente;
import banco.model.Conta;
import banco.model.DAO.ContaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/app/conta/*")
public class ContaPage extends HttpServlet{
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response
    ) throws IOException, ServletException{
        
        HttpSession session = request.getSession(); 
        Cliente cliente = (Cliente)session.getAttribute("user");
        int id_cliente = cliente.getId();
        int id = Integer.valueOf(request.getParameter("id"));
        Conta conta = new ContaDAO().getContaById(id, id_cliente);
        if(conta == null){
            response.sendError(404);
        }else{
            request.setAttribute("conta", conta);
            request.getRequestDispatcher("/WEB-INF/conta.jsp").forward(request, response);
        }        
    }
}
