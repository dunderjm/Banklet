public class Conta {
    private Pessoa titular;
    private int identificacao;
    private int agencia;
     private double saldo;
    
    public Conta(){
        
    }
    
    public Conta(Pessoa titular, int identificacao, int agencia){
        this.titular = titular;
        this.identificacao = identificacao;
        this.agencia = agencia;
    }
    
    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
        this.titular.addConta(this);
    }

    public int getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(int identificacao) {
        this.identificacao = identificacao;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
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
}