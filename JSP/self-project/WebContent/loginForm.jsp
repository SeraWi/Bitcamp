<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	CookieBox cBox = new CookieBox(request);
	String rememberId =cBox.exists("rememberId") ?cBox.getValue("rememberId"):"";
	String checked =cBox.exists("rememberId") ? "checked" :"";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 Login</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/default.css">
<style>

.contents{
	margin: 10px;
	padding:10px;
}

.contents>h2 {
	margin : 5px;
}



</style>
<script>
</script>
</head>
<body>
<%@ include file="/WEB-INF/frame/header.jsp" %>

<%@ include file="/WEB-INF/frame/nav.jsp" %>


<div class="contents">

		<h2>Login</h2>
	

		<form action="login.jsp" method="post">
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" name="memberId" value="<%=rememberId %>" ></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="checkbox" name="rememberId" value="on" <%=checked%>> 아이디 기억하기</td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit"></td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>