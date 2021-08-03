<%@page import="guest.domain.MessageListView"%>
<%@page import="guest.service.MessageListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//사용자로부터 페이지 번호를 받는다. ->파라미터로 저장
	//list.jsp?page=1
	String pageNumStr = request.getParameter("page");
	
	int pageNum =1; //디폴트로 1페이지(null == 요청이 들어오지 않음)
	if(pageNumStr != null){
		//1이 아니라면 
		pageNum =Integer.parseInt(pageNumStr);
	}
	
	MessageListView listView = MessageListService.getInstance().getMessageList(pageNum);
	
	request.setAttribute("listView", listView);
		
%>
<jsp:forward page="list_view.jsp"/>