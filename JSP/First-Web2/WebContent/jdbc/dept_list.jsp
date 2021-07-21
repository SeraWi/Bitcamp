<%@page import="java.util.List"%>
<%@page import="dept.domain.Dept"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// dept_list.jsp역할 : 드라이버 요청하고 DB에서 select해서 가져오기
	
	// 1. 드라이버 로드
	
	Class.forName("com.mysql.cj.jdbc.Driver");

	//2. DB 연결
	Connection conn = null; //초기화
	Statement stmt= null;
	ResultSet rs = null;
	
	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
	String user = "bit";
	String pw ="1234";
	
	conn = DriverManager.getConnection(jdbcUrl,user,pw);
	
	//3. statement
	stmt = conn.createStatement();
	//sql
	String sqlSelect = "select * from dept";
	
	//4. ResultSEt
	rs = stmt.executeQuery(sqlSelect);
	
	//5.  list<Dept>에 결과 저장
	
	List<Dept> deptList = new ArrayList<Dept>();
	
	while(rs.next()){
		deptList.add(new Dept(
				rs.getInt("deptno"),
				rs.getString("dname"),
				rs.getString("loc")
				));
	}
	
	out.println(deptList);
	
	//6.결과 데이터를 request의 속성에 저장->데이터 공유, 전달
	request.setAttribute("result", deptList);
	
	
%>

 <jsp:forward page="list_view.jsp"/> 