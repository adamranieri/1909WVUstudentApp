package dev.ranieri.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.ranieri.controller.StudentController;

public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MasterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		switch(uri) {
		
		case "/WVUStudentWebApp/getAllStudents.do" : {StudentController.getAllStudents(request, response);} break;
		case "/WVUStudentWebApp/loginStudent.do" : {StudentController.loginStudent(request, response);} break;
		case "/WVUStudentWebApp/addStudent.do" : {StudentController.addStudent(request, response);}break;
		case "/WVUStudentWebApp/sessInfo.do" :{StudentController.getSessionInfo(request, response);}break;
		case "/WVUStudentWebApp/giveCookie.do" : {StudentController.giveCookie(request, response);}break;
		
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
