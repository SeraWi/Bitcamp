<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- header를 외부 파일에서 가져오기  --> 
	<%@ include file="include/header.jsp"  %>
	<!-- 웹인프에 있는 파일도 가져올 수 는 있지만 웹인프를 직접 url로 들어가서 볼 수 는 없다 -->
	<!-- <%@ include file="WEB-INF/header.jsp"  %> --> 
	
<hr>
	<%@ include file="include/nav.jsp" %>

<div id="wrap">
	
	<%@ include file ="include/news.jsp" %>
	<%@ include file ="include/shopping.jsp" %>
	
</div>

</body>
</html>