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
	
	public String create(String name, String lecturerName) {
		return "todo create course";
	}
	
	public String all() {
		return "todo course all";
	}
	
	public String update(String name, String lecturerName, String newName, String newLecturerName) {
		return "todo course update";
	}
	
	public String delete(String name, String lecturerName) {
		return "todo course del";
	}
}
