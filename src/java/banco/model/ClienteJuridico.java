package banco.model;

public class ClienteJuridico extends Cliente{
    String cnpj;
    
    public ClienteJuridico(){
        
    }
    
    public ClienteJuridico(String nome, String cnpj){
        super(nome);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String getCadastroNacional() {
        return this.cnpj;
    }

    @Override
    public void setCadastroNacional(String numero) {
        this.cnpj = numero;
    }
   
}