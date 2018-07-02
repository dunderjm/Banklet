package banco.model.DAO;

import banco.model.Cliente;
import banco.model.ClienteFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
    Connection con;
    public ClienteDAO(Connection con){
        this.con = con;
    }
    public void novoCliente(ClienteBean cliente){
        String sql = "INSERT INTO clientes "
                + "(nome, cadastroNacional, email, senha, admin, tipo)"
                + "VALUES(?,?,?,?,?,?)";
        try{
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1,cliente.getNome());
                stmt.setString(2, cliente.getCadastroNacional());
                stmt.setString(3, cliente.getEmail());
                stmt.setString(4, cliente.getSenha());
                stmt.setInt(5, cliente.getAdmin());
                stmt.setInt(6, cliente.getTipo());
                
                stmt.execute();
            }
       }
       catch(SQLException e){
           throw new RuntimeException(e);
       }
    }
    
    public Cliente getCliente(String email, String senha){
       try{
        String sql = "SELECT id, nome, tipo, cadastroNacional"
                   + " FROM clientes WHERE email = ? AND "
                + "senha = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, senha);
        
        ResultSet rs = stmt.executeQuery();
        int tipo = rs.getInt("tipo");
        Cliente cliente = new ClienteFactory().getCliente(tipo);
        while(rs.next()){
            cliente.setNome(rs.getString("nome"));
            cliente.setId(rs.getInt("id"));
            cliente.setCadastroNacional(rs.getString("cadastroNacional"));
        }
        new ContaDAO(con).getContasCliente(cliente);
        return cliente;
       }
       catch(SQLException e){
           throw new RuntimeException(e);
       }
    }
}
