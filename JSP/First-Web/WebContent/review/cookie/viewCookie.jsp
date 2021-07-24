<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//Cookie[] cookies = request.getCookies();
	
	//cookieBox이용하기
	CookieBox cBox = new CookieBox(request); 
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
	<%-- <%
		if (cookies != null && cookies.length > 0) {
		for (int i = 0; i < cookies.length; i++) {
			//쿠키의 이름 반환 : getName()
			String name = cookies[i].getName();
			//쿠키의 값을 반환 : getValue()
			String value = cookies[i].getValue();

			out.println("<h1>" + name + "=" + value + "</h1>");
		}
	}
	%> --%>
	
	<!-- cookieBox이용 -->
	name =<%= cBox.getValue("name") %><br>
	number=<%= cBox.getValue("number") %><br>
	age=<%= cBox.getValue("age") %>
	
	<a href="editCookie.jsp">쿠키 수정</a>
	<a href="deleteCookie.jsp">쿠키 삭제</a>
	
</body>
</html>