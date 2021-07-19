<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//데이터 받아오기
	String[]players = (String[]) request.getAttribute("players");
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
	<h1>선수 리스트</h1>
	
	<%
		for(int i= 0; i< players.length ; i++){
			out.println(players[i] +"<br>");
		}
	
	
	%>
</body>
</html>