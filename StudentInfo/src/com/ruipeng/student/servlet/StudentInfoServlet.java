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

@WebServlet("/StudentInfoServlet")
public class StudentInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentService studentService = StudentFactory.getStudentFactory().getInstance(StudentService.class);
		String id = request.getParameter("id");
		Student student = studentService.selectById(id);
		if(student == null){
			throw new RuntimeException("id为空");
		}
		request.setAttribute("student", student);
		request.getRequestDispatcher("/updateStudentInfo.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
