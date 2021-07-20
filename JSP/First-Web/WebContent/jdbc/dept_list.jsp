<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="dept.domain.Dept"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	

	//dept_list.jsp의 역할 ->요청을 받고 처리하기
	
	//1.드라이버 로드
	//2. DB 연결
	//3. statement 
	//4. resultset
	//5. list<Dept> -> 결과
	//6. 결과 데이터를 request의 속성에 저장 ->데이터 공유(전달)
	
	
	//1.드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	//2. DB 연결
	Connection conn = null; //초기화
	Statement stmt= null;
	ResultSet rs = null;
	
	//jdbcUrl
/* 	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
	String user = "bit";
	String pw = "1234"; */
	
	//conn = DriverManager.getConnection(jdbcUrl, user, pw);
	conn= ConnectionProvider.getConnection();
	
	
	//3. statement 
	stmt = conn.createStatement();
	//sql
	String sqlSelect = "select * from dept";
	
	//4. resultSet
	rs = stmt.executeQuery(sqlSelect);
	
	//5. list<Dept> -> 결과
	
	List<Dept> deptList = new ArrayList<Dept>();
	
	while(rs.next()){
		// List에 객체 추가
		deptList.add(new Dept(
				rs.getInt("deptno"),
				rs.getString("dname"),
				rs.getString("loc")
					)
				);
	}
	
	out.println(deptList);
	
	
	//6. 결과 데이터를 request의 속성에 저장 ->데이터 공유(전달)
	request.setAttribute("result",deptList);
	
%>
<jsp:forward page="list_view.jsp"/> <!--view의 역할만  -->
