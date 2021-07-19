<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<%
	
/* 	String[] str ={"a","b"};
	out.println(str[5]); //500에러  */
	
	String str = request.getParameter("id");
	String str1 = str.toUpperCase(); //nullpointer에러
	
	

	
	%>
</body>
</html>