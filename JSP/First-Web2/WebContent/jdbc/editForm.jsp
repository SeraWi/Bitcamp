<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="dept.dao.DeptDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="dept.domain.Dept"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- editForm : deptno 를 받고 db연결해서 deptno에 맞는 부서 정보를 가져오고
에딧폼이 보여지는 화면으로 속성을 전달하면
에딧폼에 수정전 정보가 세팅되도록한다. -->

<%
	String deptno = request.getParameter("deptno");
	out.println(deptno);
	
	Connection conn = null;
	DeptDao dao =null;
	
	try{
	conn = ConnectionProvider.getConnection();
	dao = DeptDao.getInstance();
	
	request.setAttribute("dept",dao.selectByDeptno(conn, Integer.parseInt(deptno)));
	
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		JdbcUtil.close(conn);
	}
		
%>
<jsp:forward page ="editForm_view.jsp"/>