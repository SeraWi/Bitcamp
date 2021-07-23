<%@page import="java.sql.SQLException"%>
<%@page import="util.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class="domain.Member"/>
<jsp:setProperty property="*" name="member" />

<% 

	out.println(member);
	int result =0;
	Connection conn = null;
	MemberDao dao = null;
	
	try{
		conn = ConnectionProvider.getConnection();
		dao = MemberDao.getInstance();
		result = dao.insertMember(conn, member);
	
	
	} catch(SQLException e){
		e.printStackTrace();
	}
	
	if(result >0){
%>		

<script>

	alert('등록되었습니다.');
	/* 등록되면 첫화면으로 돌아가기 */
	location.href ='<%= request.getContextPath()%>/main.jsp';
	

</script>
<% 
	}else{
	
%>

<script>
	alert('오류 발생으로 등록되지 않았습니다.\n 입력페이지로 다시 이동합니다.');
	window.history.go(-1);
</script>
<%
	}
%>
