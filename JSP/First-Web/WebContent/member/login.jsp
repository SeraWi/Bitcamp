<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//세션 생성
	session.setAttribute("userName",request.getParameter("id"));
	//로그인 하면 mypage로 이동시키기
	//   /first-web/member/mypage/mypage.jsp 경로가 이렇게 보인다.
	response.sendRedirect(request.getContentLength()+"/member/mypage/mypage.jsp");
	
%>