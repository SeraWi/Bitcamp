<%@page import="service.IdCheckService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%
	String memberId = request.getParameter("mid");
	request.setAttribute("result", IdCheckService.getInstance().idCheck(memberId));
	//result 값은 N 또는 Y를 가진다
%>
${result}