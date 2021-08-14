<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OPEN PROJECT</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp" %>

</head>
<body>
<%@ include file="/WEB-INF/views/frame/header.jsp" %>	
<%@ include file="/WEB-INF/views/frame/nav.jsp" %>	
	
	
	
	<div id="content">
		<h2>Content : 로그인</h2>
		<hr>

		<form method="post">

			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" name="memberid" value="${cookie.reid.value}"></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="checkbox" name="reid" value="on"
						${cookie.reid ne null? 'checked' :''}> 아이디 기억하기
						<input type="text" name="redirectUri" value="${redirectUri ne null? redirectUri: ''}"> 
					</td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit"></td>
				</tr>
			</table>

		</form>
	</div>

</body>
</html>