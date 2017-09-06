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
	FOREIGN KEY (student_faculty) REFERENCES faculties(faculty_id) ON DELETE RESTRICT
);

CREATE TABLE courses (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(100),
    course_description VARCHAR(100),
    course_credits INT
);

-- mapping table
CREATE TABLE StudentCourses (
    id INT PRIMARY KEY,
    course_id INT,
    student_id INT,
	FOREIGN KEY (course_id) REFERENCES courses(course_id),
	FOREIGN KEY (student_id) REFERENCES students(student_id)
);

-- controll commands -- faculties
INSERT INTO faculties VALUES (2, 'FMI'); -- create
SELECT * FROM faculties; -- read
UPDATE faculties SET faculty_id = 1, faculty_name = 'FF' WHERE faculty_id = 1; -- update
DELETE FROM faculties WHERE faculty_id = 1; -- delete

-- controll commands -- students
INSERT INTO students VALUES (1, 'Ivan Ivanov', 1, 19); -- create
SELECT * FROM students; -- read
UPDATE students SET student_name = 'Ivan Petrov' WHERE student_id = 1; -- update
DELETE FROM students WHERE faculty_id = 1; -- delete

-- comman controll -- courses
INSERT INTO courses VALUES (1, 'Java basic', 'descr...', 25); -- create
SELECT * FROM courses; -- read
UPDATE courses SET course_name = 'JAVA Basic and OOP' WHERE course_id = 1; -- update
DELETE FROM courses WHERE course_id = 1; -- delete

-- common controll -- add/remove student to/form courses