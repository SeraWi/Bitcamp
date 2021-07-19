<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
</script>
</head>
<body>
	<h1>에러가 발생했습니다. 메인페이지로 이동해주세요.</h1>
	<h3>
		<%= exception.getMessage() %><br>
		<%= exception.getClass() %>
	</h3>
	
	<p>
		<% exception.printStackTrace(); %>
	</p>
</body>
</html>