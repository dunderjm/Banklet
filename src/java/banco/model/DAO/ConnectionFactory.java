package banco.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection(){
        try{
            try{
                Class.forName("org.sqlite.JDBC");
            }catch(Exception e){
                throw new RuntimeException(e);
            }
            return DriverManager.getConnection("jdbc:sqlite:/home/krt/Documentos/git/Banklet/banco.sqlite3");
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
