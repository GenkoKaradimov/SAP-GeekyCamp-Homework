-- run commands one by one
CREATE TABLE faculties (
    faculty_id INT PRIMARY KEY,
    faculty_name VARCHAR(100)
);

CREATE TABLE students (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(100),
	student_faculty INT,
	student_age INT,
	FOREIGN KEY (student_faculty) REFERENCES faculties(faculty_id)
);

CREATE TABLE courses (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(100),
    lecturer_name VARCHAR(100)
);

-- mapping table
CREATE TABLE StudentCourses (
    id INT PRIMARY KEY,
    course_id INT,
    student_id INT,
	FOREIGN KEY (course_id) REFERENCES courses(course_id),
	FOREIGN KEY (student_id) REFERENCES students(student_id)
);