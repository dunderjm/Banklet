package banco.model;

public class ClienteFisico extends Cliente{
    private String cpf;
    public ClienteFisico(){
 
    }
    
    public ClienteFisico(String nome, String cpf){
        super(nome);
        this.cpf = cpf;
    }

    @Override
    public String getCadastroNacional() {
        return this.cpf;
    }

    @Override
    public void setCadastroNacional(String numero) {
        this.cpf = numero;
    }
    
    
}