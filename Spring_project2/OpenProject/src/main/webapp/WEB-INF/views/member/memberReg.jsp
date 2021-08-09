<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${resultCnt==0}">
	<script>
		alert('회원가입에 실패했습니다.');
		history.go(-1);
	</script>
</c:if>

<c:if test="${resultCnt==1}">
	<script>
		alert('회원가입 되었습니다.');
	</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 정보</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/views/frame/header.jsp" %>	
<%@ include file="/WEB-INF/views/frame/nav.jsp" %>	

<div id="content">
	<h1>Member Register Data</h1>
	<hr>

		<table>
			<tr>
				<td>아이디</td>
				<td>${registerRequest.memberid}</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>${registerRequest.password}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${registerRequest.membername}</td>
			</tr>
			<tr>
				<td>사진</td>
				<td>
				<img src="<c:url value="/uploadfile/${registerRequest.memberphoto.originalFilename}"/>" style="width: 100px">
				</td>
			</tr>
		
		</table>
</div>	
</body>
</html>

</c:if>