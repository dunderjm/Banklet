package banco.model;

import java.util.List;
import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private List<Conta> contas;
    
    public Pessoa(){
        contas = new ArrayList<>();
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