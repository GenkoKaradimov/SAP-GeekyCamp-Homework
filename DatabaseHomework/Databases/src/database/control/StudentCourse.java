package database.control;

import java.sql.Connection;

public class StudentCourse {
	private int id;
	private int courseId;
	private int studentId;
	private int mark;
	
	private Connection conn;

	public StudentCourse(Connection conn) {
		this.conn = conn;
	}
	
	public void getStudentCourses(String name, int age) {
		
	}
	
	public void addStudentToCourse(String studentName, int age, String courseName, String lecturerName) {
		
	}
	
	public void removeStudentFromCourse(String studentName, int age, String courseName, String lecturerName) {
		
	}
	
	public void getCourseStudents(String courseName, String lecturerName) {
		
	}
}
