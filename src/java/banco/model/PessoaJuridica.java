package banco.model;

public class PessoaJuridica extends Pessoa{
    String cnpj;
    
    public PessoaJuridica(){
        
    }
    
    public PessoaJuridica(String nome, String cnpj){
        super(nome);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
   
}