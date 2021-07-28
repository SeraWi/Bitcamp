<%@page import="guest.service.WriteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id ="messageRequest" class="guest.domain.MessageRequest"></jsp:useBean>
<jsp:setProperty property="*" name="messageRequest"/>

<%
	int result = WriteMessageService.getInstance().writeMessage(messageRequest);
	request.setAttribute("result", result);
	/* 쿼리문 실행후 리턴한 int값  */
%>
<jsp:forward page="write_view.jsp"/>