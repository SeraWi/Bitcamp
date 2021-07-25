<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/default.css">
<style>
</style>
<script>
</script>
</head>
<body>
	<%@ include file="/WEB-INF/frame/header.jsp"%>

	<%@ include file="/WEB-INF/frame/nav.jsp"%>
	
	<div class="contents">
	
	<h2>회원가입</h2>
	
	<form action="regMember.jsp" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="memberId"></td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			
			<tr>
				<td>이름</td>
				<td><input type="text" name="memberName"></td>
			</tr>
			
			<tr>
				<td></td>
				<td>
					<input type="submit">
					<input type="reset">
				</td>
			</tr>
		
		
		</table>
	
	
	
	</form>
	
	
	</div>
	
	
</body>
</html>