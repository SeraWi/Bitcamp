<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> test-module page</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/default2.css">
<script src="https://code.jquery.com/jquery-1.12.4.js" 
    integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU=" 
    crossorigin="anonymous">
</script>
<script>
	//3초마다 위로 올라가기
	$(document).ready(function() {

		setInterval(function() {
			$('#banner>img').first().appendTo('#banner');
		}, 3000);

	});
</script>

</head>
<body>
<%@ include file="/WEB-INF/frame/header.jsp" %>

<%@ include file="/WEB-INF/frame/nav2.jsp" %>




</body>
</html>