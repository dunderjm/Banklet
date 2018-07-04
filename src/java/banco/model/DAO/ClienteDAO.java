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
    
    public Cliente getClienteById(int id){
       try{
        Cliente cliente = null;
           String sql = "SELECT id, nome, tipo, cadastroNacional"
                   + " FROM clientes WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);       
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            int tipo = rs.getInt("tipo");
            cliente = new ClienteFactory().getCliente(tipo);
            cliente.setNome(rs.getString("nome"));
            cliente.setId(rs.getInt("id"));
            cliente.setCadastroNacional(rs.getString("cadastroNacional"));
            new ContaDAO().getContasCliente(cliente);
        }
        return cliente;
       }
       catch(SQLException e){
           throw new RuntimeException(e);
       }
    }
    
    public Cliente buscaEmaileSenha(String email, String senha){
        String sql = "SELECT nome, id, tipo, cadastroNacional"
                   + " FROM clientes WHERE email = ? AND "
                + "senha = ?";
        Cliente cliente = null;
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                cliente = new ClienteFactory().getCliente(rs.getInt("tipo"));
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCadastroNacional(rs.getString("cadastroNacional"));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
            
        }
        return cliente;
    }
}
