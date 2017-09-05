package database.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Context {
	private Connection conn;
	
	public Faculty faculty;
	public Student student;
	public Course course;
	public StudentCourse sc;
	
	public Context() throws SQLException {
		String url = "jdbc:postgresql://localhost/camp-test";
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "z8x5n4c1f2");
		this.conn = DriverManager.getConnection(url, props);
	}	
	
	public Connection connection() {
		return this.conn;
	}
	
	public void closeConnection() throws SQLException {
		this.conn.close();
	}
}
