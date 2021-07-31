<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<link rel="stylesheet" href="<c:url value="/css/default.css"/>"> 
<style>
	td {
		text-align: center;
		padding: 5px 10px;
	}


</style>


<c:if test="${loginInfo eq null}">
	<script>
		alert('로그인 후 이용 가능 합니다. \n로그인 페이지로 이동합니다.');
		location.href='<c:url value="/loginForm.do"/>';
	</script>
</c:if>
</head>
<body>
<%@ include file="/WEB-INF/frame/header.jsp" %>

<%@ include file="/WEB-INF/frame/nav.jsp" %>

	
	<div class="contents">
		<h2>내 정보 보기 </h2>

		<hr>
		
		<table border=1>
			<tr>
				<th>ID</th>
				<td>${loginInfo.memberId}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${loginInfo.memberName}</td>
			</tr>			
			<tr>
				<th>프로필 사진</th>
				<td>
				<img src="<c:url value="/upload/${loginInfo.memberphoto}"/>" style="width: 100px">
				</td>
			</tr>			
		
		</table>
	</div>
	${loginInfo}

</body>
</html>