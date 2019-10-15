package dev.ranieri.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dev.ranieri.entities.Student;
import dev.ranieri.services.StudentService;
import dev.ranieri.services.StudentServiceImpl;

public class StudentController {
	
	// student service should be a singleton
	private static StudentService ss = new StudentServiceImpl();
	
	public static void getAllStudents(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Set<Student> students = ss.getAllStudents();		
		PrintWriter pw = response.getWriter();	
		
		Gson gson = new Gson();
		String json = gson.toJson(students);

		pw.append(json);		
		
	}
	
	public static void loginStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Student student = ss.loginStudent(username, password);
		
		Gson gson = new Gson();
		String json = gson.toJson(student);
		
		// when someone logs in we can store their information in a session for easy access
		HttpSession sess = request.getSession(); 
		sess.setAttribute("student", student);
		
		// store information on client side
		Cookie cookie = new Cookie("user",student.getUsername());
		response.addCookie(cookie);
		
		PrintWriter pw = response.getWriter();
		pw.append(json);
		
	}

	public static void addStudent(HttpServletRequest request, HttpServletResponse response) {
		
		String json = request.getParameter("student");
		
		Gson gson = new Gson();		
		Student student = gson.fromJson(json, Student.class);
		
		ss.enrollStudent(student);		
		
	}
	
	// will return user information stored in the session
	public static void getSessionInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Student student = (Student) request.getSession().getAttribute("student");	
		response.getWriter().append(student.getUsername());
		
	}
	
	// will add a cookie to the browser
	public static void giveCookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Cookie cookie = new Cookie("choco","chip");
		response.addCookie(cookie);
		response.getWriter().append("Added cookie to your browser");
		
	}
	

}
