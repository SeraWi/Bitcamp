<%@page import="domain.LoginInfo"%>
<%@page import="domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	
	//세션에 저장한 멤버 객체 가져오기
	LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");
	
	if(loginInfo ==null){
		//멤버 객체 없다 -> 로그인 상태 아님 -> 로그인 페이지로 보내기
		%>
	<script>
		alert('로그인이 필요한 페이지입니다. \n 로그인 후 사용해주세요!!');
		location.href = '<%= request.getContextPath()%>/loginForm.jsp';
	</script>
		<% 
	} else{
		//멤버 객체 있다->로그인 상태 맞음
	}
	
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
	<%=loginInfo %>
	
	로그인 정보는 idx, 아이디와 이름만 필요하다 ->loginInfo로 따로 저장하자
	password는 개인정보라 세션으로 계속가져 가는거 위험
</body>
</html>