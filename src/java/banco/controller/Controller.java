package banco.controller;

import banco.model.Cliente;
import banco.model.DAO.ClienteDAO;
import banco.model.DAO.ConnectionFactory;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/app")
public class Controller extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException{
        String tarefa = request.getParameter("tarefa");
        if(tarefa == null){
            throw new IllegalArgumentException("Error");
        }
        
        tarefa = "banco.controller." + tarefa;
        
        try{
            Class <?> tipo = Class.forName(tarefa);
            Tarefa instancia = (Tarefa) tipo.newInstance();
            String pagina = instancia.executa(request, response);
            RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        }
        catch(ClassNotFoundException | InstantiationException |IllegalAccessException e){
            throw new ServletException(e);
        }
        
    }
}
