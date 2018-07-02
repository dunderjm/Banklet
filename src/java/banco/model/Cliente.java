package banco.model;

import java.util.List;
import java.util.ArrayList;

public abstract class Cliente implements CadastroNacional{
    private int id;
    private String nome;
    private List<Conta> contas;
    
    public Cliente(){
        contas = new ArrayList<>();
    }
    
    public Cliente(String nome){
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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