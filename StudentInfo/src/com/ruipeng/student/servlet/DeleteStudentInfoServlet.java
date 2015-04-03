package com.ruipeng.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruipeng.student.factory.StudentFactory;
import com.ruipeng.student.service.StudentService;

/**
 * Servlet implementation class DeleteStudentInfoServlet
 */
@WebServlet("/DeleteStudentInfoServlet")
public class DeleteStudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService studentService = StudentFactory.getStudentFactory().getInstance(StudentService.class);
		String str = request.getParameter("id");
		studentService.deleteById(str);
		request.getRequestDispatcher("/ShowStudentListServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
