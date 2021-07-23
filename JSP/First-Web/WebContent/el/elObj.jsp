<%@page import="domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setAttribute("name", "손흥민");
	session.setAttribute("name","위세라");
	application.setAttribute("name", "메시");
	
	Member member = new Member();
	member.setId("cool");
	member.setName("COOL");
	member.setPw("1234");
	
	session.setAttribute("member",member);
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
	<!-- 2021-07-23  -->
	표현식 : <span><%= request.getAttribute("name") %></span> <br> //값이 없으면 null 반환
	
	<!--화면에 : 손흥민 표현 -->
	
	표현언어1: <span>${requestScope.name} </span> <br> //값 없으면 공백 반환
	
	내장객체의 표현식이 생략되었을 때 규칙 <br>
	1. pageScope의 속성을 찾는다. ->
	2. requestScope의 속성을 찾는다. ->
	3. sessionScope의 속성을 찾는다. ->
	4. applicationScope의 속성을 찾는다. <br>
	유일한 식별자를 쓴다면 간단하게 작성할 수 있다. (sessionScope...이런거 안붙이고!)
	
	표현언어2: <span>${name} </span> <br>
	
	표현언어3: <span>${sessionScope.name} </span> <br>
	
	표현언어4: <span>${applicationScope.name} </span> <br>
	
	<hr>
	표현식, param.code :<%=request.getParameter("code") %> //값이 없으면 null나온다 <br>
	표현언어, param.code : ${param.code} // 값이 없으면 공백이 나온다.
	
	<hr>
	
	표현식, pageContext : <%= pageContext.getRequest().getServletContext().getContextPath() %>
	
	<br>
	표현언어 ,contextpath찾으려면 길다
	${pageContext.request.requestURL} <br>
	${pageContext.request.requestURI} <br>
	${pageContext.request.contextPath} <br>
	<%=request.getContextPath()%> //이게 더 간단할 지도
	
	<hr>
	${true} / ${false} /${100} /
	${'손흥민'} /
	${null} //null이 들어오면 아무것도 출력되지 않는다.
	
	
	<hr>
	표현식 <%= member %> <br>
		<%= session.getAttribute("member") %> <br>
		<!-- session 객체에서 member 객체 가지고 오고 메소드 호출해서 id값 가져오기-->
		<%= ((Member)session.getAttribute("member")).getId()%>	<br>
	
	표현언어 ${member} 
		<!--호출하는게 member.getId()라면 get빼고 id만 쓰면 된다.(소문자로)  -->	<br>
		  ${member.id}
	
	
	
	
</body>
</html>