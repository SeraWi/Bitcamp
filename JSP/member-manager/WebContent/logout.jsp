
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//현재 세션 객체 소멸 ->메모리에서 사라진다.
	session.invalidate(); //로그아웃
%>

<script>
	alert('로그아웃 되었습니다.');
	location.href ='<%= request.getContextPath()%>';
</script>
	
