package connection;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.xdevapi.Statement;
import com.sun.jdi.connect.spi.Connection;
import java.sql.ResultSet;


public class ConnectionFactory {
	// Controle do banco de dados, gerenciar conexao, gerencia consultar e armazenamento das consultar.
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultset = null;
	
	//Criando metodo para conecatar no banco de dados
	public static java.sql.Connection conectar () {
		
		String servidor = "jdbc:mysql://localhost:3306/controleestoque";
		String usuario = "root";
		String senha = "";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			
			Class.forName(driver);
			connection = (Connection) DriverManager.getConnection(servidor,usuario,senha);
			statement = (Statement) ((java.sql.Connection) connection).createStatement();
		} catch (ClassNotFoundException | SQLException ex) {
			throw new RuntimeException ("Erro na conexão: ",ex);
		}
		return null;
					
	}
	//Verificar se está realmente conectado
	public static boolean testarConexao () {
		if (connection != null) {
			return true;
	} else {
		return false;
	}
		
	}
	
}
