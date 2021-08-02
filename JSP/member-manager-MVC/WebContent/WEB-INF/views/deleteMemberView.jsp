<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


	<c:if test="${result eq 1}">
		<script>
			alert('삭제되었습니다.');
			//삭제 후 회원리스트에 다시 돌아가기
			location.href='<c:url value="/memberList.do"/>';
		</script>
	</c:if>
	
	<c:if test="${result eq 0}">
		<script>
			alert('오류로 삭제되지 않았습니다.');
			//삭제 실패 후 회원리스트에 다시 돌아가기
			location.href='<c:url value="/index.do"/>';
			
		</script>
	</c:if>