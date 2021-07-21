<%@page import="dept.domain.Dept"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- editForm : deptno 를 받고 db연결해서 deptno에 맞는 부서 정보를 가져오고
에딧폼이 보여지는 화면으로 속성을 전달하면
에딧폼에 수정전 정보가 세팅되도록한다. -->

<%
	String deptno = request.getParameter("deptno");
	out.println(deptno);
	
	
	//1.드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
		
	//2. DB 연결
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//jdbcUrl
 	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
	String user = "bit";
	String pw = "1234"; 
	
	conn = DriverManager.getConnection(jdbcUrl, user, pw);
	Dept dept = null;
	
	
	String sqlSelect ="select * from dept where deptno =?";
	pstmt = conn.prepareStatement(sqlSelect);
	pstmt.setInt(1,Integer.parseInt(deptno));
	
	rs=pstmt.executeQuery();
	
	if(rs.next()){
		dept = new Dept();
		dept.setDeptno(rs.getInt("deptno"));
		dept.setDname(rs.getString("dname"));
		dept.setLoc(rs.getString("loc"));
	}
	
	out.println(dept);
	
	request.setAttribute("dept",dept);
	
		
%>
<jsp:forward page ="editForm_view.jsp"/>