<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 쿠키: 문자열 데이터를 사용자의 브라우저에 저장
	// 쿠키 생성 ->reponse.add(C)
	
	//Cookie cookie =new Cookie("cname", "test"); //쿠키 객체 생성//String ,String
	//쿠키를 브라우저로 응답: 쿠키 굽는다
	//response.addCookie(cookie);
	//response.addCookie(new Cookie("number","7"));
	
	//cookiebox이용하기
	response.addCookie(CookieBox.makeCookie("name","손흥민"));
	response.addCookie(CookieBox.makeCookie("number","7","/",5));
	
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
	<h1>쿠키 저장</h1>
	<a href="viewCookie.jsp">쿠키 보기</a>
</body>
</html>