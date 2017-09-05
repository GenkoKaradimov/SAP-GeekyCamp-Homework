package database.control;

import java.sql.Connection;

public class Student {
	private int id;
	private String name;
	private int facultyName;
	private int age;

	private Connection conn;

	public Student(Connection conn) {
		this.conn = conn;
	}
	
	public String create(String name, int age, int facultyId) {
		return "todo faculty create";
	}
	
	public String all() {
		return "todo faculty all";
	}
	
	public String update(String name, int age, int facultyId, String newName, int newAge, int newFacultyId) {
		return "todo faculty update";
	}
	
	public String delete(String name, int age, int facultyId) {
		return "todo faculty del";
	}
}
