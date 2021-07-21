<%@page import="dept.domain.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Dept dept = (Dept) request.getAttribute("dept");

%>
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
	<h1>부서 정보 수정</h1>
	<hr>
	
	<form action="editDept.jsp" method="post">
		<table>
			<tr>
				<td>부서번호</td>
				<!-- 받아온 데이터로 화면에 세팅해주기 -->
				<td><input type="number" name="deptno" value="<%= dept.getDeptno() %>" readonly></td>
			</tr>
			
			<tr>
				<td>부서이름</td>
				<!-- 받아온 데이터로 화면에 세팅해주기 -->
				<td><input type="text" name="dname" value="<%= dept.getDname() %>"></td>
			</tr>
		
			<tr>
				<td>위치</td>
				<td><input type="text" name="loc" value="<%= dept.getLoc() %>"></td>
			</tr>
			
			<tr>
				<td></td>
				<td>
					<input type="submit" value="등록">
					<input type="reset">
				</td>
			</tr>
		
		</table>
	
	
	</form>

</body>
</html>