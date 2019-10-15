package dev.ranieri.services;


import java.util.Set;

import dev.ranieri.entities.Student;

public interface StudentService {
	
	Student enrollStudent(Student student);
	
	Student loginStudent(Student student);
	Student loginStudent(String username, String password);
	
	Set<Student> getAllStudents();
	
}
