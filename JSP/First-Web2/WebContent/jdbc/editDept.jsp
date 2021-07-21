<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");

	String deptno = request.getParameter("deptno");
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");	
	
	int resultCnt = 0;
	
	//드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn= null;
	
	
	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
	String user ="bit";
	String pw ="1234";
	
	try{
	//db 연결
	conn = DriverManager.getConnection(jdbcUrl,user,pw);
	
	PreparedStatement pstmt = null;
	//sql 작성
	String sqlUpdate ="update dept set dname=?, loc =? where deptno =?";
	pstmt = conn.prepareStatement(sqlUpdate);
	
	pstmt.setString(1,dname);
	pstmt.setString(2,loc);
	pstmt.setInt(3,Integer.parseInt(deptno));
	
	//실행
	resultCnt = pstmt.executeUpdate();
	
	}catch(Exception e){
		e.printStackTrace();
		
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