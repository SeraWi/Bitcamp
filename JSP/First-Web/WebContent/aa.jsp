<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>AAA</h1>
</body>
</html>
<!-- bb.jsp로 넘어간다  화면에 AAA가 아니라 BBB나온다-->
<%-- <jsp:forward page="bb.jsp"/> --%>

<jsp:forward  page="footer.jsp">
		<jsp:param name ="email" value ="test@gmail.com"/>
		<jsp:param name="tel" value="010-0000-0000"/>
</jsp:forward>