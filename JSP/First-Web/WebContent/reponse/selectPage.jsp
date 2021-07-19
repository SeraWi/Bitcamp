<!-- 2021.07.19 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
</script>
</head>
<body>

	<!-- foward 액션과 response의 sendredirect의 차이 -->
	<form action="resultPage.jsp">
		<select name ="select">
			<option value ="0">forward</option>
			<option value ="1">sendRedirect</option>
		</select>
		
		<br>
		<input type ="submit">
	</form>
</body>
</html>