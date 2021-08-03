<%@page import="guest.service.WriteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<!-- 결과를 jsp로 가져오기 -->
<jsp:useBean id="messageRequest" class="guest.domain.MessageRequest"></jsp:useBean>
<jsp:setProperty property="*" name="messageRequest"/>
<%
	// writemessage servie의 service 인스턴스를 가지고 온뒤 -> 메서드 호출
	int result = WriteMessageService.getInstance().writeMessage(messageRequest);
	request.setAttribute("result", result);
	

%>

<jsp:forward page="write_view.jsp"/>