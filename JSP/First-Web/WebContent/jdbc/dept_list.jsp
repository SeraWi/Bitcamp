<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="dept.dao.DeptDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	

	//dept_list.jsp의 역할 ->사용자 요청 들어오면 요청을 받고 Dao로 가서 결과데이터를 가져와서, 속성에 정의,공유하기
	//	-> 그다음 forward로 보내기, view 지정하기
	//핵심 처리다!!!!!
	
	//1.드라이버 로드
	//2. DB 연결
	//3. statement 
	//4. resultset
	//5. list<Dept> -> 결과
	//6. 결과 데이터를 request의 속성에 저장 ->데이터 공유(전달)
	
	
/* 	//1.드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver"); */
	
	//2. DB 연결
	Connection conn = null; //초기화
/* 	Statement stmt= null; //Dao class 안에 있다
	ResultSet rs = null; */
	
	DeptDao dao = DeptDao.getInstance(); 
	
	//jdbcUrl
/* 	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
	String user = "bit";
	String pw = "1234"; */
	
	//conn = DriverManager.getConnection(jdbcUrl, user, pw);
	try{
		//jdbcUrl 
		conn= ConnectionProvider.getConnection();

		//6. 결과 데이터를 request의 속성에 저장 ->데이터 공유(전달)
		//request.setAttribute("result",deptList);
		request.setAttribute("result",dao.getDeptList(conn));
		
		
	}catch(SQLException e){
		e.printStackTrace();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		JdbcUtil.close(conn);
	}
	
	
	/* //3. statement 
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
	
	out.println(deptList); */
	
	
	
%>
<jsp:forward page="list_view.jsp"/> <!--view의 역할만  -->
