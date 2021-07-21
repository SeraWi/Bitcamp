<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String deptno = request.getParameter("deptno");
	int resultCnt = 0;
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= null;
	PreparedStatement pstmt = null;
	
	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
	String user ="bit";
	String pw ="1234";
	
	try{
	
	conn = DriverManager.getConnection(jdbcUrl,user,pw);
	String sqlDelete = "delete from dept where deptno =?";  
	pstmt = conn.prepareStatement(sqlDelete);
	pstmt.setInt(1,Integer.parseInt(deptno));
	
	resultCnt = pstmt.executeUpdate();
	
	}catch(Exception e){
		e.printStackTrace();
	}
	
	if(resultCnt > 0){
		%>
		<script>
			alert('삭제되었습니다.');
			location.href='dept_list.jsp';
		</script>
			
		
		<%
	}else{
		%>
		
		<script>
		
			alert('해당 데이터를 찾지 못했습니다.');
			location.href='dept_list.jsp';
		</script>
		
		<%
	}
	
	
%>