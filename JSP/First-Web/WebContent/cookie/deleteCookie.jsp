<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//쿠키의 삭제: 쿠키 유지 시간을 0으로 설정하기
	
	//Cookie c = new Cookie("cname","");
	//초단위
	//c.setMaxAge(60*60*24*7); 1주일유지
	
	//쿠키가 바로 소멸 : 삭제
	//c.setMaxAge(0);
	
	//응답주기
	//response.addCookie(c);
	
	
	//cookiebox
	response.addCookie(CookieBox.makeCookie("name","","/First-Web/cookie",0));


%>
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
	<h1>쿠키가 삭제되었습니다.</h1>
	<a href ="viewCookie.jsp">쿠키보기</a>
</body>
</html>