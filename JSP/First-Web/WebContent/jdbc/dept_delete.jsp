<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="dept.dao.DeptDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	

	//역할 : deptno 받고 -> 실행 -> 결과
	//사용자가 전달하는 deptno를 받고
	//DB에 있는 deptno를 찾아가서
	//데이터 삭제하기!
	//실행 결과에 맞는 응답하기

	
	//사용자가 전달하는 deptno를 받고
	String deptno = request.getParameter("deptno");
	//DB에 있는 deptno를 찾아가서
	//데이터 삭제하기!
	
	int resultCnt = 0;

	//2.DB처리  :delete
	
/* 	//데이터 베이스 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver"); */
	
	
	Connection conn = null;
	//PreparedStatement pstmt = null;
	DeptDao dao = DeptDao.getInstance();
	
/* 	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
	String user ="bit";
	String pw ="1234"; */
	
	//conn = DriverManager.getConnection(jdbcUrl,user,pw);
	try{
	conn =ConnectionProvider.getConnection();
	resultCnt = dao.deleteDept(conn, Integer.parseInt(deptno)); //deptno 전달해주기, nullpointer 예외 발생가능
	
	}catch(SQLException e){
		e.printStackTrace();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		JdbcUtil.close(conn);
	}
	
	
/* 	String sqlDelete = "delete from dept where deptno =?";  -->dao안 메서드 사용
	pstmt = conn.prepareStatement(sqlDelete);
	pstmt.setInt(1,Integer.parseInt(deptno));
	
	
	//실행 결과에 맞는 응답하기
	
	resultCnt = pstmt.executeUpdate(); */
	
	
	if(resultCnt > 0){
		%>
		<script>
			alert('삭제되었습니다.');
			location.href = 'dept_list.jsp';
		</script>
		<%
	}else{
		%>
		<script>
			alert('해당 데이터를 찾지 못했습니다.');
			location.href= 'dept_list.jsp';
		</script>
		<%
		
	}
	
%>







