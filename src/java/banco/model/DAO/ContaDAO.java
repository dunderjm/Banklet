package banco.model.DAO;

import banco.model.Cliente;
import banco.model.Conta;
import banco.model.ContaFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
            int tipo = rs.getInt("poupanca");
            
            while(rs.next()){
                Conta conta = new ContaFactory().getConta(tipo);
                conta.setSaldo(rs.getFloat("saldo"));
                conta.setCodigo(rs.getInt("codigo"));
                conta.setTitular(cliente);
                cliente.addConta(conta);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
