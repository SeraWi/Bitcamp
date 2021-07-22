<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 쿠키의 수정은 같은 이름의 쿠키를 만들어서 설정
	// 새로운 쿠키 생성
	//Cookie c = new Cookie("cname","king");
	//response.addCookie(c);
	
	
	//쿠키박스 이용
	response.addCookie(CookieBox.makeCookie("name","이강인"));

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
	<h1>쿠키 값이 변경되었습니다.</h1>
	<a href ="viewCookie.jsp">쿠키보기</a>
</body>
</html>