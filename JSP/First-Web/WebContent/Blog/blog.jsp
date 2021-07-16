<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My Blog</title>
<link rel="stylesheet" href="myBlog.css">
</head>
<body>
	<!-- 전체 레이아웃 -->
	<div id="main_wrap">

		<!-- header 시작 -->
		<%@ include file="../include/blogHeader.jsp"%>
		<!-- header 끝 -->


		<!-- nav 시작 -->
		<%@ include file="../include/blogNav.jsp"%>
		<!-- nav 끝 -->

		<!-- contents 시작 -->
		<div id="content_wrap">
			<%@ include file="../include/blogSection.jsp"%>
			<%@ include file="../include/blogAside.jsp"%>
		</div>
		<!-- contents 끝 -->

		<!-- footer 시작 -->
		<%@ include file="../include/blogFooter.jsp"%>
		<!-- footer 끝 -->
	</div>
</body>
</html>