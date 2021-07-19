<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* 핵심처리 */
	String[]list = {"손흥민","이강인","황의조","박지성","위세라"};

	//view 페이지에 선수리스트를 공유
	request.setAttribute("players", list);
%>

<jsp:forward page ="list_view.jsp"></jsp:forward>