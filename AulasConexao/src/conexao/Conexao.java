package conexao;
import java.sql.Connection;
import java.sql.DriverManager;


public class Conexao {
	private Connection connect = null;
	
	final private String host = "localhost";
	final private String user = "root";
	final private String passwd = "";

	
	public Connection getConexao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/bancoteste?" + "user=" + user + "&password=" + passwd);
            return connect; 
            
		}catch(Exception e){
			System.out.println("Problema jdbc driver" + e);
            return null;
		}
	}
}
