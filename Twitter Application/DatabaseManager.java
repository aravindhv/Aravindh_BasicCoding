import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
	private static final String user = "root";
	private static final String password = "test";
	private static final String url = "jdbc:mysql://localhost/TWITTER_DATABASE";
	private static Connection connection;
	
	static {
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}

}
