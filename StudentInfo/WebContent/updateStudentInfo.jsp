<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改学生信息</title>
</head>
<body style="text-align: center;">
	<h1>修改学生信息</h1>
	<form
		action="${pageContext.request.contextPath }/UpdateStudentInfoServlet"
		method="POST">
		<input type="hidden" name="id" value="${student.id }">
		<table border="1" width="50%" align="center">
			<tr>
				<td>学生姓名：</td>
				<td><input type="text" name="name" value="${student.name }" /></td>
			</tr>
			<tr>
				<td>学生性别：</td>
				<td><input type="radio" name="gender" value="男"
					<c:if test="${student.gender=='男' }">checked='checked'</c:if> />男
					<input type="radio" name="gender" value="女"
					<c:if test="${student.gender=='女' }">checked='checked'</c:if> />女</td>
			</tr>
			<tr>
				<td>学生年龄：</td>
				<td><input type="text" name="age" value="${student.age }" /></td>
			</tr>
			<tr>
				<td colspan="6"><input type="submit" value="修改"></td>
			</tr>
		</table>
	</form>
</body>
</html>