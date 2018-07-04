
import banco.model.Conta;
import banco.model.DAO.ContaDAO;

public class Teste {
    public static void main(String[] args){
        Conta conta = new ContaDAO().getContaById(4556, 1);
        conta.depositar(500);
    }
}
