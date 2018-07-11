package banco.model;

import banco.model.DAO.ContaDAO;

public class ContaCorrente extends Conta{
    public ContaCorrente(){
        super("Corrente");
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
            double taxa = 0.10;
            double novoSaldo = this.getSaldo() + valor - taxa;
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