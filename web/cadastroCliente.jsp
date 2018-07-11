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
        <div class="container">

                <div class="card z-depth-1">
                    <form action="/banklet/cadastroCliente" method="post">
                        <div class="card-content">
                            <span class="card-title">Cadastrar novo cliente</span><br>
                            <div class="row">
                                <div class="input-field col s6">
                                  <input id="nome" type="text" class="validate" maxlength="10" name="nome">
                                  <label for="nome">Nome</label>
                                </div>
                                <div class="input-field col s6">
                                  <input id="sobrenome" type="text" class="validate" maxlength="10" name="sobrenome">
                                  <label for="sobrenome">Sobrenome</label>
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s5">
                                  <input id="identificacao" type="text" class="validate" name="cadastroNacional">
                                  <label for="identificacao">CPF/CNPJ</label>
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s9">
                                  <input id="email" type="email" class="validate" name="email">
                                  <label for="email">Email</label>
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s4">
                                  <input id="password" type="password" class="validate" name="senha">
                                  <label for="password">Senha</label>
                                </div>
                            </div>

                            <div class="input-field">
                                <p>
                                    <label>
                                        <input name="tipoCliente" type="radio" value="0"checked />
                                        <span>Pessoa Física</span>
                                    </label>
                                </p>
                                <p>
                                    <label>
                                        <input name="tipoCliente" type="radio" value="1"/>
                                        <span>Pessoa Jurídica</span>
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
