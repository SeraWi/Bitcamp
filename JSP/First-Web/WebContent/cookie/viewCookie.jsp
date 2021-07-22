<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	//Cookie[] cookies = request.getCookies();

	//cookiebox
	CookieBox cBox = new CookieBox(request);
	
	
	
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

	<!-- checkbox이용하기 쿠키 값 가져오기 -->  
	name = <%= cBox.getValue("name")%> <br>
	number = <%= cBox.getValue("number1") %> <br>
	age =<%= cBox.getValue("age") %> <br>
	


	<%
/* 		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				//쿠키의 이름 반환 : getName()
				String name = cookies[i].getName();
				//쿠키의 값을 반환 : getValue()
				String value = cookies[i].getValue();

				if (name.equals("cname")) { //특정 쿠키만 찾아서 화면에 보여주기
					out.println("<h1>" + name + "=" + value + "</h1>");
				}
			}
		} */

		
	%>

	<a href="editCookie.jsp">쿠키수정</a>
	<a href="deleteCookie.jsp">쿠키 삭제</a>
</body>
</html>