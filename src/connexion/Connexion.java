package connexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class Connexion {
    private static String login = "root";
	private static String password = "";
	private static String url = "jdbc:mysql://localhost:3306/gstock";
	private static Connection connection;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, login, password);	
		} catch (ClassNotFoundException e) {
			System.out.println("Impossible de charger le driver");
		} catch (Exception e) {
			System.out.println("Impossible d'�tablir la connexion");
		}
	}

	public static Connection getConnection() {
		return connection;
	}
	
    
}
