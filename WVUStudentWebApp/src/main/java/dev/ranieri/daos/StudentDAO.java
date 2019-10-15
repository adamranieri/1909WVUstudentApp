package dev.ranieri.daos;

import java.util.Set;

import dev.ranieri.entities.Student;

// Basic CRUD operations
public interface StudentDAO {
	
	//Create
	boolean createStudent(Student student);
	
	//Read
	Student getStudentById(int id);
	Student getStudentByUsername(String username);
	Set<Student> getAllStudents();
	
	//Update
	boolean updateStudent(Student student);
	
	//Delete
	boolean deleteStudent(Student student);
	

}
