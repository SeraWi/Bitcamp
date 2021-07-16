<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="login.css">
<style>
</style>
<script>
</script>
</head>
<body>
	<div id="main_wrap">


		<!-- header 제목 -->
		<header>
			<h1>
				<a href="http://www.naver.com"> NAVER</a>
			</h1>
		</header>

		<!-- 로그인하는 창 -->
		<form action="login_result.jsp" method="post">
			<div class="login">
				<input type="text" name="id" placeholder="아이디"> <br> 
				<input type="text" name="pw" placeholder="비밀번호"> <br> 
				<input type="submit"  value="로그인">
			</idv>
		</form>
		

	</div>
</body>
</html>