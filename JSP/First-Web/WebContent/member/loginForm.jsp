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
	<hr><%-- <c:url value="/member/Login.jsp"/> --%> <!--/First-WEb/member/mypage/login.jsp  -->
	
	<form action="<c:url value="/member/login.jsp"/>">  <!--/First-WEb/member/mypage/mypage.jsp  -->
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