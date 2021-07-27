<%@page import="domain.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	LoginInfo loginInfo =(LoginInfo) session.getAttribute("loginInfo");

	if(loginInfo ==null){
			//로그인 상태 아님
			%>
			<script>
				alert('로그인이 필요한 페이지 입니다.\로그인 후 사용해 주세요.');
				location.href='<%= request.getContextPath()%>/loginForm.jsp';
			</script>
		<%
	}else{
		//로그인 상태
	
	
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
<%@ include file="/WEB-INF/frame/header.jsp" %>

<%@ include file="/WEB-INF/frame/nav.jsp" %>

	<div class="contents">
		<h1>MyPage</h1>
		<%= loginInfo %>
	
	
	</div>
</body>
</html>



<%}%>