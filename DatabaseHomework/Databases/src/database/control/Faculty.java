package database.control;

import java.sql.Connection;

public class Faculty {
	private int id;
	private String name;
	
	private Connection conn;
	
	public Faculty(Connection conn) {
		this.conn = conn;
	}
	
	public void create(String name) {
		
	}
	
	public void all() {
		
	}
	
	public void update(String name, String newName) {
		
	}
	
	public void delete(String name) {
		
	}
}
