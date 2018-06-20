public class PessoaJuridica extends Pessoa{
    String cnpj;
    Conta conta;
    
    public PessoaJuridica(){
        
    }
    
    public PessoaJuridica(String nome, String cnpj){
        super(nome);
        this.cnpj = cnpj;
    }
    
}