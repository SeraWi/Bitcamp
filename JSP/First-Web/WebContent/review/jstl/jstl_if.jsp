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
	<!-- test = 논리값 -->
	<c:if test="${true}">
		참일 때만 보여집니다.
	</c:if>
	<br>
	<c:if test="${10>0}">
		참일 때만 보여집니다.
	</c:if>
	<Br>
	
	
	<hr>
	이름: ${members[0].name} <br>
	
	<c:if test="${members[1].name eq null}">
		입력된 정보가 없습니다.
	</c:if> <br>
	
	
	<c:if test="${members[0].name eq 'cool00'}" var="result" scope="request"/>
	members[0].name == 'cool00':
	${result} 
</body>
</html>




