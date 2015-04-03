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
 * Servlet implementation class UpdateStudentInfoServlet
 */
@WebServlet("/UpdateStudentInfoServlet")
public class UpdateStudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService studentService = StudentFactory.getStudentFactory().getInstance(StudentService.class);
		request.setCharacterEncoding("utf-8");
		Student stu = new Student();
		stu.setId(Integer.valueOf(request.getParameter("id")));
		stu.setName(request.getParameter("name"));
		stu.setGender(request.getParameter("gender"));
		stu.setAge(Integer.valueOf(request.getParameter("age")));
		studentService.update(stu);
		request.getRequestDispatcher("/ShowStudentListServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
