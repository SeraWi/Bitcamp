<%@page import="member.dao.MemberDao"%>
<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//member_list 역할 :
	// 사용자 요청 받고 Dao에서 결과 데이터 받아 오면 속성으로 공유 후 view 지정
	// 핵심 처리!

	Connection conn = null;
	MemberDao dao = MemberDao.getInstance();
	
	try{
	conn= ConnectionProvider.getConnection();
	
	//결과 데이터를 request의 속성에 저장 ->데이터 공유(전달)
	request.setAttribute("result",dao.getMemberList(conn));
	
	}catch(SQLException e){
		e.printStackTrace();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		JdbcUtil.close(conn);
	}
	
	
%>

<!--view 지정  -->
<jsp:forward page="list_view.jsp"/>
