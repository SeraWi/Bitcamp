<%@page import="guest.service.MessageListService"%>
<%@page import="guest.domain.MessageListView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//사용자 요청 페이지 번호
	String pageNumstr = request.getParameter("page");	

 	int pageNum=1; //디폴트는 1페이지

	if(pageNumstr !=null){
		//1이 아니라면
		pageNum =Integer.parseInt(pageNumstr);
	}
	//사용자 요청 페이지 번호에 해당하는 게시물 받아와서 listView에 담기
 	MessageListView listView = MessageListService.getInstance().getMessageList(pageNum);
	
	request.setAttribute("listView", listView);
%>

<jsp:forward page="list_view.jsp"/>