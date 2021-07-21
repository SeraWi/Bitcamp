<%@page import="member.domain.Member"%>
<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	
	//입력데이터의 한글 처리
	request.setCharacterEncoding("utf-8");
	
	//데이터 받기
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String regdate = request.getParameter("regdate");
	int resultCnt = 0;
	

	
	//connenction 연결
	Connection conn = null;
	MemberDao dao = MemberDao.getInstance();
	
	
	try{
		conn = ConnectionProvider.getConnection();
		resultCnt = dao.insertMember(conn, new Member(id,pw,name,regdate));
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		JdbcUtil.close(conn);
	}
	
	
	if(resultCnt > 0){
		%>

		<script>
			alert('등록되었습니다.');
			location.href = 'member_list.jsp'; 
		</script>

	<%
	}else{
		//등록이 안되면 
		%>

		<script>
			alert('오류 발생으로 등록되지 않았습니다. \n 입력페이지로 돌아갑니다.');
			location.href = 'member_regForm.jsp';
			
			window.history.go(-1); //입력 페이지 돌아가지 않고 그대로 머무르기
			
		</script>
		<%
	}
%>
