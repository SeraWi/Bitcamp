<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//쿠키의 삭제: 쿠키 유지 시간을 0으로 설정하기
	
	//Cookie c = new Cookie("cname","");
	
	//c.setMaxAge(60*60*24);
	//c.setMaxAge(0);
	
	//response.addCookie(c);
	
	//cookieBox이용
	response.addCookie(CookieBox.makeCookie("name","","/First-Web/cookie",0));

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
	<h1>쿠키가 삭제되었습니다.</h1>
	<a href="viewCookie.jsp">쿠키 보기</a>
</body>
</html>