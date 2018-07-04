<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title></title>
        <!-- Materialize CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>
    <body style="background-color:#fbfbfb">
        <div class="row light-blue darken-1 white-text">
            <div class="container">
                <div class="col s11">
                    <h3><strong>${user.nome}</strong></h3>
                    <p>${user.getCadastroNacional()}</p>
                </div>
                <div class="col s1">
                    <a href="logout" class="btn green lighten-1 z-depth-0" style="margin-top:60px">Sair</a>
                </div>
            </div>
        </div>
        <div class="container">

            <ul class="collection with-header z-depth-1">
            <li class="collection-header"><h5><i class="small material-icons left">credit_card</i>Contas</h5></li>
                <c:choose>
                  <c:when test="${not empty contas}">
                        <c:forEach var="conta" items="${contas}">
                        <li class="collection-item">
                            <div class="secondary-content">
                                <a href ="app/conta?id=${conta.codigo}" class="btn-small green lighten-1 z-depth-0"><i class="tiny material-icons right">arrow_forward</i>Acessar Conta</a>
                            </div>
                            <div>
                                <strong>${conta.tipo}</strong><br>
                                Código: ${conta.codigo} <br>
                                R$ ${conta.saldo}
                            </div>
                        </li>
                        </c:forEach>
                  </c:when>
                  <c:otherwise>
                    <li class="collection-item">
                        <div>
                          <h4>O Cliente não tem conta ainda!</h4>
                        </div>
                    </li>
                  </c:otherwise>
                </c:choose>
          </ul>
        </div><!-- container -->
    </body>
</html>
