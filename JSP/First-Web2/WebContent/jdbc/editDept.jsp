<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="dept.domain.Dept"%>
<%@page import="dept.dao.DeptDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");

	//데이터 받기
	String deptno = request.getParameter("deptno");
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");

	int resultCnt = 0;
	
	
	Connection conn= null;
	DeptDao dao;
	
	try{
	//db 연결
		conn = ConnectionProvider.getConnection();
		dao =DeptDao.getInstance();
		resultCnt = dao.updateDept(conn, new Dept(Integer.parseInt(deptno),dname,loc));
	
	
	}catch(Exception e){
		e.printStackTrace();
		
	} finally{
		JdbcUtil.close(conn);
	}
	
	
	if(resultCnt > 0){
		%>
		<script>
			alert('수정되었습니다.');
			location.href ='dept_list.jsp';
		</script>

		<%
	}else{
		%>
		<script>
			alert('해당 데이터를 찾지 못했습니다.');
			location.href ='dept_list.jsp';
		</script>


		<%
	}
	
%>