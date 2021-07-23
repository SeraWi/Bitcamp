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

	${members} <br>
	${members[0]} <br>
	${members[1]}/ 
	${members[1].name} // null이라 아무것도 안나온다.--> 치환할 수 있다. <br>
	
	<c:out value="${members[0].name}"/> <br> //데이터 출력 out
	
	
	
	<c:out value="${members[1].name}" escapeXml="false">
		<span style="color : red;">입력된 정보 없음.</span>
	</c:out><br>
	
	<c:out value="${members[1].name}" escapeXml="true">
		<span style="color : red;">입력된 정보 없음.</span>
	</c:out>
	
	
	

</body>
</html>