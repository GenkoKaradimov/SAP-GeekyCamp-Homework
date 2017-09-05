package database.control;

import java.sql.Connection;

public class Faculty {
	private int id;
	private String name;
	
	private Connection conn;
	
	public Faculty(Connection conn) {
		this.conn = conn;
	}
	
	public String create(String name) {
		return "todo faculti create";
	}
	
	public String all() {
		return "todo faculty all";
	}
	
	public String update(String name, String newName) {
		return "todo faculti update";
	}
	
	public String delete(String name) {
		return "todo faculty del";
	}
}
