package portoDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
	
public class ConnectionFactory {

	public Connection obterConexao() {
    
		String urlDeConexao = "jdbc:h2:./banco/db";
		String login = "sa";
		String senha = "";

        try {
            return DriverManager.getConnection(urlDeConexao, login, senha);

        } catch(SQLException e) {
        	throw new RuntimeException(e);	  
        }
    }
}