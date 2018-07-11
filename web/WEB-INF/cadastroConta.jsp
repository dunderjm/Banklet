<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title></title>
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
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

                <div class="card z-depth-1">
                    <form action="app?tarefa=CadastroConta" method="post">
                        <div class="card-content">
                        <span class="card-title">Abrir nova conta</span><br>
                        <div class="input-field">
                            <p>
                                <label>
                                    <input name="tipoConta" type="radio" value="0" checked />
                                    <span>Conta Corrente</span>
                                </label>
                            </p>
                            <p>
                                <label>
                                    <input name="tipoConta" type="radio" value="1"/>
                                    <span>Conta Poupança</span>
                                </label>
                            </p>
                        </div>
                        </div>
                        <div class="card-action">
                            <button class="btn waves-effect waves-light" type="submit">Confirmar</button>
                        </div>
                    </form>
                </div><!-- card z-depth-1 -->

        </div><!-- container -->
    </body>
</html>
