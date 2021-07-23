<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="member.Member" scope ="request"/> 
<!--member 패키지 안에 Member class  -->
<!-- 1. request 속성에 member라는 속성을 찾는다.  
	 2. member가 member.Member 타입의 객체인지 확인!
	 3.1 있다면 request.getAttribute("member")
	 3.2 없다면 new member.Member()생성 ->request.setAttribute("member",new member.Member());

-->

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
	<%= member %>
	<br>
	<%= member.getName() %>
</body>
</html>