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
	<!-- 세션에 저장한 members 배열 가져오기 -->
	${members}<br>
	${members[0]} <br>
	${members[1]} <Br>
	${members[1].name} <br>  <!-- null값이라서 아무것도 출력하지 않는다 -->
	<hr>
	<c:out value="${members[0].name}"/><br>
	
	<c:out value="${members[1].name}" escapeXml= "false">
		<span style="color: red">입력된 정보 없음 </span>
	</c:out>
	<br>
	<c:out value="${members[1].name}" escapeXml="true" >
		<span style="color: red">입력된 정보 없음 </span>
	</c:out>
</body>
</html>