<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello JSP</title>
<style>
</style>
<script>
</script>
</head>
<body>
	<%
		String name = "SON";
		
	%>
	안녕하세요 <%= name %>
	<%=request.getContextPath() %> 
	<!--first web -->
</body>
</html>