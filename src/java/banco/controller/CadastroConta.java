package banco.controller;

import banco.model.Cliente;
import banco.model.Conta;
import banco.model.ContaFactory;
import banco.model.DAO.ContaDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CadastroConta implements Tarefa{
    @Override
    public String executa (HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        Cliente cliente = (Cliente)session.getAttribute("user");
        int tipo = Integer.valueOf(request.getParameter("tipoConta"));
        Conta novaConta = new ContaFactory().getConta(tipo);
        novaConta.setTitular(cliente);
        new ContaDAO().novaConta(novaConta);
        request.setAttribute("cadastro", "Nova conta criado com sucesso!");
        return "WEB-INF/cadastroConta.jsp";
    }
}
