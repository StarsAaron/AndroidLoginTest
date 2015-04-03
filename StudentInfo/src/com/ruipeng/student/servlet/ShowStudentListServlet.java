package com.ruipeng.student.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruipeng.student.bean.Student;
import com.ruipeng.student.dao.StudentDaoImpl;
import com.ruipeng.student.factory.StudentFactory;
import com.ruipeng.student.service.StudentService;

/**
 * Servlet implementation class ShowStudentListServlet
 */
@WebServlet("/ShowStudentListServlet")
public class ShowStudentListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取StudentServiceImpl实例对象
		StudentService studentService = StudentFactory.getStudentFactory().getInstance(StudentService.class);
		List<Student> list = studentService.selectAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/ShowStudentList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
