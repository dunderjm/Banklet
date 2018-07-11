<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width">
        <title>Login</title>
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    </head>
    <body class="blue-grey lighten-5">
        <div class="container">
            <div class="row">
                <div class="col s2 teal"></div>

                    <div class="col s8" style="margin-top:100px">
                        <div class="row">
                           <form class="col s12" action="login" method="post">
                             <div class="row">
                                <h3 style="text-align:center; margin-bottom: 80px">Entrar</h3>
                               <div class="input-field col s6">
                                 <i class="material-icons prefix">mail</i>
                                 <input id="email" type="email" name="email" class="validate">
                                 <label>E-mail</label>
                               </div>
                               <div class="input-field col s6">
                                 <i class="material-icons prefix">vpn_key</i>
                                 <input id="password" type="password" name="senha" class="validate">
                                 <label>Senha</label>
                               </div>
                               <div class="input-field col s12 center">
                                  <c:if test="${not empty error}"
                                      <p class="red-text">${error}</p>
                                  </c:if>
                                 <button type="submit" class="btn z-depth-0" style="margin-top:10px">Confirmar</button>
                               </div>
                             </div>
                           </form>
                       </div><!-- row -->
                       <div class="col s12 center">
                           <a href="cadastroCliente.jsp">Cadastre-se</a>
                       </div>
                    </div><!-- col s8 -->

                <div class="col s2 teal"></div>
            </div>
        </div>
    </body>
</html>
