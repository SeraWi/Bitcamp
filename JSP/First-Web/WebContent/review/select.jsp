<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//사용자로부터 파라미터를 받아 응답을 분기해주는 처리
	//select.jsp?sel=aa -- 파라미터 aa
	String sel = request.getParameter("sel");
	if(sel!= null){
		if(sel.equals("AA")){
			%>
			<jsp:forward page="AA.jsp"/>
			<% 
		}else if(sel.equals("BB")){
			%>
			<jsp:forward page="BB.jsp"/>
			<% 
		}
	}
%>
잘못된 요청입니다.