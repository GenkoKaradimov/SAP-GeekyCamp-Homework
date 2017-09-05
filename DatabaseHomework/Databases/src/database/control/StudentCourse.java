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
	
	public String getStudentCourses(String name, int age) {
		return "todo get courses for student";
	}
	
	public String addStudentToCourse(String studentName, int age, String courseName, String lecturerName) {
		return "todo connect student and course";
	}
	
	public String removeStudentFromCourse(String studentName, int age, String courseName, String lecturerName) {
		return "todo disconect student and course";
	}
	
	public String getCourseStudents(String courseName, String lecturerName) {
		return "todo get students for course";
	}
}
