import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class allMain {
	public static void Main(String[] args) throws SQLException {
		String url = "jdbc:postgresql://localhost/camp-test";
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "z8x5n4c1f2");
		Connection conn = DriverManager.getConnection(url, props);
		PreparedStatement prepareStatement = null;
		
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Student");
			ResultSet executeQuery = prepareStatement.executeQuery();
			while(executeQuery.next()) {
				System.out.println(executeQuery.getString(1) + " " + executeQuery.getString(2) + " " + executeQuery.getString(3));
			}
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			prepareStatement.close();
			conn.close();
		}
	}
}
