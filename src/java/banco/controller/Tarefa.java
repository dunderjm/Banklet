package banco.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Tarefa {
    String executa(HttpServletRequest request, HttpServletResponse Response);
}
