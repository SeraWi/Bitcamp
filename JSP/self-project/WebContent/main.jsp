<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 티켓 파크에 오신걸 환영합니다</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/default.css">
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

<%@ include file="/WEB-INF/frame/nav.jsp" %>

    <div id ="banner">
        <img src="images/window1.jpg">
        <img src="images/window2.jpg">
        <img src="images/photo.jpg">
        <img src="images/window3.jpg">
        <img src="images/window4.png">
    </div>
</body>
</html>