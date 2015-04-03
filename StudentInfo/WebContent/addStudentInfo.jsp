<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加学生信息</title>
</head>
<body style="text-align: center;">
	<h1>添加学生信息</h1>
	<form action="${pageContext.request.contextPath }/AddStudentInfoServlet" method="POST">
		<table border="1" width="50%" align="center">
			<tr>
				<td>学生姓名：</td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>学生性别：</td>
				<td>
					<input type="radio" name="gender" value="男"/>男
					<input type="radio" name="gender" value="女"/>女
				</td>
			</tr>
			<tr>
				<td>学生姓年龄：</td>
				<td><input type="text" name="age"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="添加">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>