<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生信息</title>
</head>
<body style="text-align: center;">
	<h1>学生信息列表</h1>
	<table border="1" width="100%">
		<tr>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<c:forEach items="${requestScope.list}" var="student">
			<tr>
				<td><c:out value="${student.name}" /></td>
				<td><c:out value="${student.gender}" /></td>
				<td><c:out value="${student.age}" /></td>
				<td><a href="${pageContext.request.contextPath }/StudentInfoServlet?id=${student.id }">修改</a></td>
				<td><a href="${pageContext.request.contextPath }/DeleteStudentInfoServlet?id=${student.id }">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6">
				<a href="${pageContext.request.contextPath }/addStudentInfo.jsp">增加</a>
			</td>
		</tr>
	</table>
</body>
</html>