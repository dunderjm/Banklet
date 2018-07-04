package banco.model.DAO;

import banco.model.Cliente;
import banco.model.Conta;
import banco.model.ContaFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaDAO {
    Connection con;
    public ContaDAO(Connection con){
        this.con = con;
    }
    
    public void getContasCliente(Cliente cliente){
        try{
            String sql = "select * FROM conta WHERE id_cliente = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, cliente.getId());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int tipo = rs.getInt("poupanca");
                Conta conta = new ContaFactory().getConta(tipo);
                conta.setSaldo(rs.getFloat("saldo"));
                conta.setCodigo(rs.getInt("codigo"));
                conta.setTitular(cliente);
                System.out.println("Loop");
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
