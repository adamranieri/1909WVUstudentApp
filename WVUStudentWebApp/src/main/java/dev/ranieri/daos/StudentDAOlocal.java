package dev.ranieri.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dev.ranieri.entities.Student;

public class StudentDAOlocal implements StudentDAO{
	
	// Emulate a table in a sql database
	public static final Map<Integer,Student> studenttable = new HashMap<Integer,Student>();
	
	//In most applications the id for an entity is determined in the database
	private static int idmaker = 1000;
	
	private static StudentDAO sdao;
	
	private StudentDAOlocal() {};
	
	static{
		Student jared = new Student(0,"jared101", "password");
		Student david = new Student(0,"davidb", "password");
		Student grant = new Student(0,"grantinator", "password");
		
		sdao = StudentDAOlocal.getStudentDAOlocal();
		sdao.createStudent(grant);
		sdao.createStudent(david);
		sdao.createStudent(jared);
		
	}
	
	public static StudentDAO getStudentDAOlocal() {
		
		if(sdao ==null) {
			sdao = new StudentDAOlocal();
		}
		return sdao;
		
	}
	

	public boolean createStudent(Student student) {
		
		idmaker++;
		student.setId(idmaker);
		try {
			studenttable.put(idmaker, student);
			return true;
			
		}catch(Exception e) {
			return false;
		}
		
		
	}

	public Student getStudentById(int id) {
		Student student = studenttable.get(id);
		return student;
	}

	public Student getStudentByUsername(String username) {
		
		List<Student> students = new ArrayList<Student>(studenttable.values());
		
		students.removeIf((student) ->{
			
			if(student.getUsername().equals(username)) {
				return false;
			}else {
				return true;
			}
						
		});
		
		return students.get(0);
	}

	public boolean updateStudent(Student student) {
		
		studenttable.put(student.getId(), student);		
		return true;
	}

	public boolean deleteStudent(Student student) {

		studenttable.remove(student.getId());
		return true;
	}


	@Override
	public Set<Student> getAllStudents() {
		Set<Student> students = new HashSet(studenttable.values());
		return students;
	}

}
