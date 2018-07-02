package banco.controller;

import banco.model.ClienteFisico;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Escondido implements Tarefa{
    
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response){
        ClienteFisico exemplo = new ClienteFisico("João", "02484403224");
        request.setAttribute("pessoa", exemplo);
        return "WEB-INF/escondido.jsp";
    }
}
