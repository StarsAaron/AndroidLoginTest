package com.ruipeng.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruipeng.student.bean.User;
import com.ruipeng.student.factory.StudentFactory;
import com.ruipeng.student.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		UserService userService = StudentFactory.getStudentFactory().getInstance(UserService.class);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		String str = userService.login(user);
		response.setContentType("utf-8");
		response.getWriter().print(str);;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
