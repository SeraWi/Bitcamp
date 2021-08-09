<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jstl/core" %>
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
	<h1>LoginForm</h1>
	<hr>
	
	<!-- action 에 대한 속성이 없으면 submit하면 다시 자기 자신으로 돌아온다. 
		actoin="contextpath/member/login"
		post로 보내기!
	-->
	<form method="post">  
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" ></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw" ></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"></td>
			</tr>
		
		</table>
	
	
	</form>
</body>
</html>