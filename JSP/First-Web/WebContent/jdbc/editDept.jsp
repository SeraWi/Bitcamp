<%@page import="dept.domain.Dept"%>
<%@page import="java.sql.SQLException"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="dept.dao.DeptDao"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	

	//사용자가 직접 입력한 new 정보 박고 ->처리
	
	
	//1.사용자가 입력한 데이터를 받고
	//입력데이터의 한글 처리!
	request.setCharacterEncoding("utf-8");
	
	//데이터 받기
	String deptno = request.getParameter("deptno");
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	
	int resultCnt = 0;

	//2.DB처리 :update
	
/* 	//데이터 베이스 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver"); */
	
	
	Connection conn = null;
	DeptDao dao = null;
	
	try{
		conn = ConnectionProvider.getConnection();
		dao = DeptDao.getInstance();
		
		//결과
		resultCnt = dao.updateDept(conn, new Dept(Integer.parseInt(deptno),dname,loc)); //new 정보를 객체로 만들어서 전달
		
		
	}catch(SQLException e){
		e.printStackTrace();
		
	}	
	
	
	/* PreparedStatement pstmt = null; -->dao, 메서드로 만들기
	
	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
	String user ="bit";
	String pw ="1234";
	
	
	conn = DriverManager.getConnection(jdbcUrl,user,pw);
	
	String sqlUpdate ="update dept set dname=?, loc =? where deptno =?";
	pstmt = conn.prepareStatement(sqlUpdate);
	
	pstmt.setString(1,dname);
	pstmt.setString(2,loc);
	pstmt.setInt(3,Integer.parseInt(deptno));
	
	resultCnt = pstmt.executeUpdate(); //업데이트 되면 1 반환 */
	
	
	if(resultCnt > 0){
		%>
		<script>
			alert('수정되었습니다.');
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
    