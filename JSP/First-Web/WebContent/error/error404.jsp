<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage ="true" %>
<!--에러를 표현하는 페이지  -->

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

	<h1>요청하신 경로의 파일이 존재하지 않습니다.<br>
	다시 확인하시고 요청해주세요.</h1>
	<h3>
		
		
	</h3>
	<p>
		<% exception.printStackTrace(); %>
	</p>
</body>
</html>