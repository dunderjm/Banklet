package banco.model;

import banco.model.DAO.ContaDAO;

public class ContaPoupanca extends Conta{

    public ContaPoupanca() {
        super("Poupança");
    }
    
    @Override
    public void sacar(double valor){
        if (valor >= 0){
            if (this.getSaldo() >= valor) {
                double taxa = 0.20;
                double novoSaldo = this.getSaldo() - valor - taxa;
                this.setSaldo(novoSaldo);
                new ContaDAO().update(this.getSaldo(), this.getCodigo());
            }
        }
    }
     
     @Override
     public void depositar(double valor){
        if(valor >= 0){
            double novoSaldo = this.getSaldo() + valor;
            this.setSaldo(novoSaldo);
            new ContaDAO().update(this.getSaldo(), this.getCodigo());
        }
    }
    
     @Override
    public void transferirPara(double valor, Conta conta){
        if (this.getSaldo() >= valor){
            this.sacar(valor);
            conta.depositar(valor);
        }
    }
}