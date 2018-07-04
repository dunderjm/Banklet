package banco.controller;

import banco.model.Cliente;
import banco.model.Conta;
import banco.model.DAO.ClienteDAO;
import banco.model.DAO.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ClientePage implements Tarefa{
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse Response) {
        try(Connection con = new ConnectionFactory().getConnection()){
            HttpSession session = request.getSession();
            Cliente cliente = null;
            List<Conta> contas = null;
            Object sessao = session.getAttribute("user");
            if(sessao instanceof Cliente){
                cliente = (Cliente)sessao;
                int id = cliente.getId();
                cliente = new ClienteDAO(con).getClienteById(id);
                contas = cliente.getContas();
            }
            for(Conta conta: contas){
                System.out.println(conta);
            }
            
            request.setAttribute("cliente", cliente);
            request.setAttribute("contas", contas);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        return "WEB-INF/cliente.jsp";
    }
    
}
