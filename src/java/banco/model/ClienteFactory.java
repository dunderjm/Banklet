package banco.model;

public class ClienteFactory {
    public Cliente getCliente(int tipo){
        if (tipo == 0){
            return new ClienteFisico();
        }else{
            return new ClienteJuridico();
        }
    }
    
}
