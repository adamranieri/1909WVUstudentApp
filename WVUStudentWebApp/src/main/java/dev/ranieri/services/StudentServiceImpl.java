package dev.ranieri.services;

import java.util.Set;

import dev.ranieri.daos.StudentDAO;
import dev.ranieri.daos.StudentDAOlocal;
import dev.ranieri.entities.Student;

public class StudentServiceImpl implements StudentService{

	public static StudentDAO sdao = StudentDAOlocal.getStudentDAOlocal();	
	
	@Override
	public Student enrollStudent(Student student) {
		
		sdao.createStudent(student);
		student = sdao.getStudentByUsername(student.getUsername());
		return student;
	}

	@Override
	public Student loginStudent(Student student) {
		
		
		Student stu = sdao.getStudentByUsername(student.getUsername());
		
		if(student.getPassword().equals(stu.getPassword())) {
			return stu;
		}
		
		return null;
	}

	@Override
	public Student loginStudent(String username, String password) {
		
		Student student = new Student(0,username,password);
		student = this.loginStudent(student);
		
		return student;
	}

	@Override
	public Set<Student> getAllStudents() {
		Set<Student> students  = sdao.getAllStudents();
		return students;
	}
	
}
