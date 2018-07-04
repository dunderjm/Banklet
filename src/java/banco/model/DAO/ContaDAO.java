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
    public ContaDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    public Conta getContaById(int id, int id_cliente){
        Conta conta = null;
        String sql = "select * from conta where codigo = ?"
                + "and id_cliente = ?";
        try(PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setInt(1, id);
            stmt.setInt(2, id_cliente);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                conta = new ContaFactory().getConta(rs.getInt("poupanca"));
                conta.setCodigo(rs.getInt("codigo"));
                conta.setSaldo(rs.getDouble("saldo"));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return conta;
    }
    
    public Conta getContaById(int id_destino){
        Conta conta = null;
        String sql = "select * from conta where codigo = ?";
        try(PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setInt(1, id_destino);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                conta = new ContaFactory().getConta(rs.getInt("poupanca"));
                conta.setCodigo(rs.getInt("codigo"));
                conta.setSaldo(rs.getDouble("saldo"));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return conta;
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
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void update(double valor, int codigo){
        String sql = "UPDATE conta SET saldo = ? WHERE codigo = ?";
        try(PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setDouble(1, valor);
            stmt.setInt(2, codigo);
            stmt.execute();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
   
}
