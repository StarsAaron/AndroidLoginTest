package com.ruipeng.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruipeng.student.bean.Student;
import com.ruipeng.student.factory.StudentFactory;
import com.ruipeng.student.service.StudentService;

/**
 * Servlet implementation class AddStudentInfoServlrt
 */
@WebServlet("/AddStudentInfoServlet")
public class AddStudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		StudentService studentService = StudentFactory.getStudentFactory().getInstance(StudentService.class);
		
		Student stu = new Student();
		stu.setName(request.getParameter("name"));
		stu.setGender(request.getParameter("gender"));
		stu.setAge(Integer.parseInt(request.getParameter("age")));
		studentService.insert(stu);
		response.sendRedirect(request.getContextPath()+"/ShowStudentListServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
