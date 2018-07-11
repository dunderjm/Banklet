package banco.model;

public abstract class Conta {
    private Cliente titular;
    private int codigo;
    private double saldo;
    private String tipo;
    
    public Conta(String tipo){
        this.tipo = tipo;
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

    public String getTipo() {
        return tipo;
    }
   
    public abstract void sacar(double valor);      
    
    public abstract void depositar(double valor);
    
    public abstract void transferirPara(double valor, Conta conta);

    @Override
    public String toString() {
        return "Conta{" + "titular=" + titular + ", codigo=" + codigo + ", saldo=" + saldo + '}';
    }
    
    
}