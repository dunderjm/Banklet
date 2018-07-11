package banco.controller;

import banco.model.DAO.ClienteBean;
import banco.model.DAO.ClienteDAO;
import banco.model.DAO.ConnectionFactory;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastroCliente")
public class CadastroCliente extends HttpServlet{

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
       Connection con = new ConnectionFactory().getConnection();
       String nome = request.getParameter("nome") + request.getParameter("sobrenome");
       String cadastroNacional = request.getParameter("cadastroNacional");
       String email = request.getParameter("email");
       String senha = request.getParameter("senha");
       int tipo = Integer.valueOf(request.getParameter("tipoCliente"));
       
       ClienteBean novoCliente = new ClienteBean();
       novoCliente.setNome(nome);
       novoCliente.setEmail(email);
       novoCliente.setSenha(senha);
       novoCliente.setCadastroNacional(cadastroNacional);
       novoCliente.setTipo(tipo);
       
       new ClienteDAO(con).novoCliente(novoCliente);
       request.setAttribute("cadastroConfirmado", "Cliente Cadastrado com "
               + "Sucesso");
       response.sendRedirect("cadastroCliente.jsp");
    }
    
}
