package banco.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovaConta implements Tarefa{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) {
       return "WEB-INF/cadastroConta.jsp";
    }
    
}
