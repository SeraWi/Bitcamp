<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage ="true" %>
<!--에러를 표현하는 페이지  -->

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

	<h1>요청하신 기능을 수행하는 중 에러가 발생했습니다.<br> 
	잠시후에 접속해주세요.</h1>
	<h3>
		<%= exception.getMessage() %> <br>
		<%= exception.getClass().getName().equals("java.lang.ArithmeticException")%><br>
		
	</h3>
	<p>
		<% exception.printStackTrace(); %>
	</p>
</body>
</html>