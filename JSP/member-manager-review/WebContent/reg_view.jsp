<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:if test="${result==1}">
<script>

	alert('등록되었습니다.');
	/* 등록되면 첫화면으로 돌아가기 */
	location.href ='<c:url value="/main.jsp"/>';
	

</script>
</c:if>

<c:if test="${result==0}">
<script>
	alert('오류 발생으로 등록되지 않았습니다.\n 입력페이지로 다시 이동합니다.');
	window.history.go(-1);
</script>
</c:if>