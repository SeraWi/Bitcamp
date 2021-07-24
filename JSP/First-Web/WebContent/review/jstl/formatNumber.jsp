<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<c:set var="number" value="1000000"/>
	
	${number} <br>
	
	<fmt:formatNumber value="1000000"/><br>
	<fmt:formatNumber value="1000000" groupingUsed ="false"/><br>
	<fmt:formatNumber value="${number}"/><br>
	<fmt:formatNumber value="${number}" type="number"/><br>
	<fmt:formatNumber value="${number/10000}" type="percent"/><br>
	<fmt:formatNumber value="${number}" type="currency" currencySymbol="$"/><br>
	<fmt:formatNumber value="${number*2000}" pattern ="000,000.00"/><br>
</body>
</html>