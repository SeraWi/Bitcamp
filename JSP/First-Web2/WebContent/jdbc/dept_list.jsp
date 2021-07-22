<%@page import="java.sql.SQLException"%>
<%@page import="dept.dao.DeptDao"%>
<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="dept.domain.Dept"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// dept_list.jsp역할 : 드라이버 요청하고 DB에서 select해서 가져오기
	
	Connection conn = null;
	DeptDao dao = DeptDao.getInstance();
	
	try{
	conn = ConnectionProvider.getConnection();
	
	request.setAttribute("result", dao.getDeptList(conn));
	
	}catch(SQLException e){
		e.printStackTrace();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		JdbcUtil.close(conn);
	}
%>

 <jsp:forward page="list_view.jsp"/> 