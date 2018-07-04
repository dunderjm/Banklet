console.log("Estou sendo carreado");
    inputDepositar = document.querySelector('#inputDepositar');
    confirmDepositar = document.querySelector('#confirmDepositar');
    depositar = document.querySelector('#depositar');

    inputSacar = document.querySelector('#inputSacar');
    confirmSacar = document.querySelector('#confirmSacar');
    sacar = document.querySelector('#sacar');

    inputTransferirA = document.querySelector('#inputTransferirA');
    inputTransferirB = document.querySelector('#inputTransferirB');
    confirmTransferir = document.querySelector('#confirmTransferir');
    Transferir = document.querySelector('#Transferir');

    confirmDepositar.addEventListener('click', function(){
        texto = inputDepositar.value;
        depositar.setAttribute('href', "${conta.depositar(" + texto + ")}");
    });

    confirmSacar.addEventListener('click', function(){
        texto = inputSacar.value;
        sacar.setAttribute('href', "${conta.depositar(" + texto + ")}");
    });

    /*confirmTransferir.addEventListener('click', function{
        texto = inputDepositar.value;
        depositar.setAttribute('href', "${conta.depositar(" + texto + ")}");
    });*/
