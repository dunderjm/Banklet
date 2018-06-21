package banco.controller;

import banco.model.PessoaFisica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Escondido implements Tarefa{
    
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response){
        PessoaFisica exemplo = new PessoaFisica("João", "02484403224");
        request.setAttribute("pessoa", exemplo);
        return "WEB-INF/escondido.jsp";
    }
}
