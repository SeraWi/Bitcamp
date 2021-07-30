<%@page import="member.domain.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



	<c:if test="${loginInfo ne null}">
		<script>
			alert('로그인 성공!');
			//로그인 성공 후에 메인 페이지로 이동
			location.href='<c:url value="/index.do"/>';
		</script>
	</c:if>
	
	<c:if test="${loginInfo eq null }">
		<script>
			alert('로그인 실패!');
			//로그인 화면으로 다시 가기
			location.href='<c:url value="/loginForm.do"/>';
			
		</script>
	</c:if>
