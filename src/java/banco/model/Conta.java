package banco.model;

public abstract class Conta {
    private Cliente titular;
    private int codigo;
    private double saldo;
    
    public Conta(){
        
    }
    
    public Conta(Cliente titular, int identificacao, int agencia){
        this.titular = titular;
        this.codigo = identificacao;
    }
    
    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
        this.titular.addConta(this);
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void sacar(double valor){
        if (valor >= 0){
            if (this.saldo >= valor) {
                   this.saldo-=valor;
            }
        }
    }    
    
    public void depositar(double valor){
        if(valor >= 0){
            this.saldo+=valor;
        }
    }
    
    public void transferirPara(double valor, Conta conta){
        if (this.saldo >= valor){
            this.sacar(valor);
            conta.depositar(valor);
        }
    }

    @Override
    public String toString() {
        return "Conta{" + "titular=" + titular + ", codigo=" + codigo + ", saldo=" + saldo + '}';
    }
    
    
}