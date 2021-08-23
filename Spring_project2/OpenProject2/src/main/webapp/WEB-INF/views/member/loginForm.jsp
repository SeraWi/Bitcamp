<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open Project : 로그인</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp" %>
</head>

<body>
	
<%-- <%@ include file="/WEB-INF/views/frame/header.jsp" %>	
<%@ include file="/WEB-INF/views/frame/nav.jsp" %>	 --%>	
	<%@include file="/WEB-INF/views/frame/bootstrap_header.jsp" %>
	
	
	<main role="main" class="container">


		<div class="my-3 p-3 bg-white rounded shadow-sm">
					<h2>Login</h2>
		<hr>

		<form method="post">

			<table>
				<tr>
					<th>ID</th>
					<td><input class="form-control m-2" type="text" name="memberid" value="${cookie.reid.value}"></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input class="form-control m-2" type="password" name="password"></td>
				</tr>
				<tr>
					<th></th>
					<td><input class="form-check-input" type="checkbox" name="reid" value="on"
						${cookie.reid ne null? 'checked' :''}> 아이디 기억하기
						<%-- <input type="text" name="redirectUri" value="${redirectUri ne null ? redirectUri:''}"> --%>
					</td>
				</tr>
				<tr>
					<th></th>
					<td><input class="form-control btn m-2" value="로그인"type="submit"></td>
				</tr>
			</table>

		</form>
		</div>


	</main>

<%@include file="/WEB-INF/views/frame/footer.jsp" %>	
</body>
</html>