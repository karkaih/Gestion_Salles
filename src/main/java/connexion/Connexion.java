package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connexion {
	private static Connection connection;
	private static String login = "root";
	private static String password = "";
	private static String url = "jdbc:mysql://localhost:3306/reservation";

	public Connexion() {
		connect();
	}

	public static void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, login, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		if (connection != null)
		{
			return connection;
		}else connect();
		return connection;
	}

	public static PreparedStatement PreparedSQLStatement(String sql_stmt) {
		try {
			return getConnection().prepareStatement(sql_stmt);
		} catch (SQLException ex) {
			System.out.println("The following error has occured: " + ex.getMessage());
		}
		return null;
	}

}
