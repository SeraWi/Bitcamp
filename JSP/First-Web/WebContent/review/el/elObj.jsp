<%@page import="domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setAttribute("name", "손흥민");
	session.setAttribute("name", "위세라");
	application.setAttribute("name","메시");
	
	Member member= new Member();
	member.setId("cool");
	member.setName("COOL");
	member.setPw("12345");
	
	session.setAttribute("member", member);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language 문법</title>
<style>
</style>
<script>
</script>
</head>
<body>
	<!-- 표현식  -->
	
	표현식: <%= request.getAttribute("name") %> //값이 없으면 null
	<br>
	
	표현언어: ${requestScope.name}<br>
	
	내장객체의 표현식이 생략되었을 때 규칙<br>
	1.pageScope의 속성을 찾고 <br>
	2.requestScope의 속성을 찾고 <br>
	3.sessionScope의 속성을 찾고 <br>
	4.applicationScope의 속성을 찾는다 <br>
	따라서 유일한 식별자 이름을 쓴다면 간단하게 작성할 수 있다. <br>
	
	포현언어2: ${name} <br>
	표현언어3 : ${sessionScope.name} <br>
	
	표현언어4: ${applicationScope.name} <br>
	
	<hr>
	표현식: null, 표현언어: 공백 <br>
	표현식, pageContext: <%= request.getParameter("code") %> <br>
	표현언어, param.code : ${param.code} <br>
	<hr>
	
	표현식,pageContext: <%=pageContext.getRequest().getServletContext().getContextPath() %><br>
	표현언어
	${pageContext.request.requestURL}<br>
	${pageContext.request.requestURI} <br>
	${pageContext.request.contextPath} <br>
	<%=request.getContextPath() %> <br>
	
	<hr>
	표현식 <%= member %> <br>
	
	<%= session.getAttribute("member") %> <br>
	<%= ((Member)session.getAttribute("member")).getId()%> <br>
	
	표현언어
	${member} <br>
	${member.id}
	
	
</body>
</html>