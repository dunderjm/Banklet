package banco.controller;

import banco.model.Cliente;
import banco.model.ClienteFactory;
import banco.model.Conta;
import banco.model.DAO.ClienteDAO;
import banco.model.DAO.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientePage implements Tarefa{
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse Response) {
        String email = "joaosantana1998@gmail.com";
        String senha = "joao123";
        try(Connection con = new ConnectionFactory().getConnection()){
            Cliente cliente = new ClienteDAO(con).getCliente(email, senha);
            request.setAttribute("cliente", cliente);
            List<Conta> contas = cliente.getContas();
            for(Conta conta: contas){
                System.out.println(conta);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        return "WEB-INF/cliente.jsp";
    }
    
}
