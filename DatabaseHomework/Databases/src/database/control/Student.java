package database.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
	private int id;
	private String name;
	private int facultyName;
	private int age;

	private Connection conn;

	public Student(Connection conn) {
		this.conn = conn;
	}

	public void create(String name, int age, int facultyId) {

	}

	public void all() throws SQLException {
		PreparedStatement prepareStatement = null;

		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM student");
			ResultSet executeQuery = prepareStatement.executeQuery();
			while (executeQuery.next()) {
				System.out.println(
						executeQuery.getString(1) + " " + executeQuery.getString(2) + " " + executeQuery.getString(3));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void update(String name, int age, int facultyId, String newName, int newAge, int newFacultyId) {

	}

	public void delete(String name, int age, int facultyId) {

	}
}
