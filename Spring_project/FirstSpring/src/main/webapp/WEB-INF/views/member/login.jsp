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
	<h1>Login Request Data</h1>
	<hr>
	
	<!-- action 에 대한 속성이 없으면 submit하면 다시 자기 자신으로 돌아온다. 
		actoin="contextpath/member/login"
		post로 보내기!
		
		보낸 데이터 받아오기
	-->
		<table>
			<tr>
				<td>아이디</td>
				<td>${id}, ${uid}, ${loginRequest.id}</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>${pw}, ${upw}, ${loginReg.pw}</td>
			</tr>
		
		</table>
	
	
</body>
</html>