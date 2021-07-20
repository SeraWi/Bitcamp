<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1.사용자가 입력한 데이터를 받고
	//입력데이터의 한글 처리!
	request.setCharacterEncoding("utf-8");
	
	//데이터 받기
	String deptno = request.getParameter("deptno");
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	int resultCnt = 0;

	//2.DB처리 :insert
	
	//데이터 베이스 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	
	try{
		
	
	
	//connenction 연결
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	
/* 	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
	String user ="bit";
	String pw ="1234"; */
	
	
	//conn = DriverManager.getConnection(jdbcUrl,user,pw);
	conn =ConnectionProvider.getConnection();
	
	
	//PreparedStatement
	
	String sqlInsert = "insert into dept values(?,?,?)";
	pstmt = conn.prepareStatement(sqlInsert);
	pstmt.setInt(1, Integer.parseInt(deptno));
	pstmt.setString(2, dname);
	pstmt.setString(3, loc);
	
	//insert -> int반환
	resultCnt = pstmt.executeUpdate(); //업데이트 되면 1반환 안되면 0
	
	out.println(resultCnt);
	
	
	
	
	
	//3.끝나고 나면 dept_list.jsp(첫번째 페이지)로 돌아간다.
	//response.sendRedirect("dept_list.jsp");
	
	}catch(Exception e){
		
		
	}
	
	
	if(resultCnt > 0){
		%>
		
		<script>
			alert('등록되었습니다.');
			location.href = 'dept_list.jsp'; 
		</script>
		
		<%
	}else{
		//등록이 안되면 
		%>
		
		<script>
			alert('오류 발생으로 등록되지 않았습니다. \n 입력 페이지로 다시 이동합니다.');
			location.href = 'dept_regForm.jsp';
			
			window.history.go(-1); //입력 페이지 돌아가지 않고 그대로 머무르기
			
		</script>
		<% 
		
	}
%>












