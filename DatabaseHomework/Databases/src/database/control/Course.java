package database.control;

import java.sql.Connection;

public class Course {
	private int id;
	private String Name;
	private String LecturerName;
	
	private Connection conn;

	public Course(Connection conn) {
		this.conn = conn;
	}
	
	public void create(String name, String lecturerName) {
		
	}
	
	public void all() {

	}
	
	public void update(String name, String lecturerName, String newName, String newLecturerName) {
		
	}
	
	public void delete(String name, String lecturerName) {
		
	}
}
