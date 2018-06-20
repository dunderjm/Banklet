import java.util.List;
public abstract class Pessoa {
    String nome;
    List<Conta> contas;
    
    public Pessoa(){
        
    }
    
    public Pessoa(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Conta> getContas(){
        return contas;
    }
    
    public void addConta(Conta conta){
        this.contas.add(conta);
    }
}