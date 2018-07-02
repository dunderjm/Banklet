package banco.model;

public class ContaFactory {
    public Conta getConta(int tipo){
        if(tipo == 0){
            return new ContaCorrente();
        }else if(tipo == 1){
            return new ContaPoupanca();
        }
        return null;
    }
}
