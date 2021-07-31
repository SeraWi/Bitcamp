<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<nav>
		<ul>
		
			<c:if test="${loginInfo eq null}">
			<li><a  href='<c:url value="/regForm.do"/>'>회원가입</a></li>
			<li><a href='<c:url value="/loginForm.do"/>'>로그인</a></li>
			</c:if>
			
			<c:if test="${loginInfo ne null}">
			<li><a href='<c:url value="/logout.do"/>'>로그아웃</a></li>
			<li><a href='<c:url value="/memberList.do"/>'>회원리스트</a></li>
			</c:if>
			
			<!--로그인 상태이든 아니든 마이페이지 볼 수 있다.  -->
			<li><a href='<c:url value="/myPage.do"/>'>MyPage</a></li>
			<li><a href='<c:url value="/message.do"/>'>Message</a></li>
		</ul>
	</nav>
