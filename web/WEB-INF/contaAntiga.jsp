<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br" dir="ltr">
    <head>
        <meta charset="utf-8">
        <title></title>
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
        <script src="/banklet/form.js"></script>
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
                    <a href="/banklet/logout"class="btn green lighten-1 z-depth-0" style="margin-top:60px">Sair</a>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="card teal z-depth-0">
                <div class="card-content white-text">
                    <i class="small material-icons left">credit_card</i>
                    <span class="card-title">${conta.tipo}</span>
                    <p>Código: ${conta.codigo} <br>
                    Saldo: ${conta.saldo}</p>
                </div>
            </div>

            <div class="col s12 m6">

                <div class="card z-depth-1">
                    <div class="card-content">
                        <span class="card-title">Depositar</span><br>
                        <div class="input-field">
                            <input placeholder="Valor" id="inputDepositar" name="valor" type="text">
                            <label for="inputDepositar">Valor</label>
                        </div>
                    </div>
                    <div class="card-action">
                        <a class="btn" id="confirmDepositar">Confirmar</a>
                        <a href="" class="btn blue" id="depositar">Depositar</a>
                    </div>
                </div>

                <div class="card z-depth-1">
                    <div class="card-content">
                        <span class="card-title">Sacar</span><br>
                        <div class="input-field">
                            <input placeholder="Valor" id="inputSacar" name="valor" type="text">
                            <label for="inputSacar">Valor</label>
                        </div>
                    </div>
                    <div class="card-action">
                        <a class="btn" id="confirmSacar">Confirmar</a>
                        <a href="" class="btn blue" id="sacar">Sacar</a>
                    </div>
                </div>

                <div class="card z-depth-1">
                    <div class="card-content">
                        <span class="card-title">Transferir</span><br>

                        <div class="row">
                            <div class="input-field col s6">
                                <input placeholder="codigo" id="inputTransferirA" name="valor" type="text">
                                <label for="inputTransferirA">Código</label>
                            </div>
                            <div class="input-field col s6">
                                <input placeholder="valor" id="inputTransferirB" type="text">
                                <label for="inputTransferirB">Valor</label>
                            </div>
                        </div><!-- row -->

                    </div><!-- card content -->
                    <div class="card-action">
                        <a class="btn" id="confirmTransferir">Confirmar</a>
                        <a href="" class="btn blue" id="Transferir">Transferir</a>
                    </div>
                </div>

            </div><!-- col s12 m6 -->

        </div><!-- container -->


    </body>
</html>
