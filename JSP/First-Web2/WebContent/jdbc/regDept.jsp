<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="dept.domain.Dept"%>
<%@page import="dept.dao.DeptDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- regDept : DB에 insert해준다 -->

<%
	//1. 사용자가 입력한 데이터 받고 입력데이터 한글 처리
	
	request.setCharacterEncoding("utf-8");
	

	String deptno= request.getParameter("deptno");
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	int resultCnt = 0;
	
	
	Connection conn = null;
	DeptDao dao = DeptDao.getInstance();

	
	try{
		conn =ConnectionProvider.getConnection();
		resultCnt = dao.insertDept(conn,new Dept(Integer.parseInt(deptno),dname,loc)); 
			
			
	}catch(Exception e ){
		
	} finally{
		JdbcUtil.close(conn);
		
	}
	
	if(resultCnt > 0){
		%>
		
		<script>
			alert('등록되었습니다.');
			location.href ='dept_list.jsp';
		</script>
		
		<%
	}else{
		%>
		
		<script>
		
			alert('오류발생으로 등록되지 않았습니다.');
			location.href ='regForm.jsp';
			
			window.history.go(-1);
		
		</script>
		<%
	}
			
			
			
			
			
			
%>