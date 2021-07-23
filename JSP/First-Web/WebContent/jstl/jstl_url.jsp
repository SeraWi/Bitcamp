<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>

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
	<h3>
		<c:url value="index.jsp" var="urlIndex"/>
		${urlIndex} <br>
		<!-- var 안에 url속성을 담는다 그리고 출력 -->
		<c:url value="index.jsp"/> <br>
		
		<!-- url사용하기 -->
		<a href="<c:url value="/index.jsp"/>">홈으로 가기</a>
		<br>
		<!-- 파라미터 보낼수있다 -->
		<c:url value="/index.jsp" var="homeUrl">
			<c:param name="type">main</c:param>
			<c:param name="index">1</c:param>
		</c:url>
		${homeUrl}
		<br>
		<a href="${homeUrl}">${homeUrl}</a>
	</h3>
	
</body>
</html>