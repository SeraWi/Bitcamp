<%@page import="java.sql.SQLException"%>
<%@page import="util.ConnectionProvider"%>
<%@page import="dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//	request.setCharacterEncoding("utf-8");
	// filter 사용
%>
<jsp:useBean id="member" class="domain.Member" />
<jsp:setProperty property="*" name="member" />
<!-- 표현식 -->
<%-- <%
	out.println(member);
	int result = 0;
	Connection conn = null;
	MemberDao dao = null;
	try {
		conn = ConnectionProvider.getConnection();
		dao = MemberDao.getInstance();
		result = dao.insertMember(conn, member);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	//out.println(result);
	if (result > 0) {
%>
<script>
	alert('등록되었습니다.');
	location.href = '<%= request.getContextPath()%>/index.jsp';
</script>
<%
	} else {
%>
<script>
	alert('오류 발생으로 등록되지 않았습니다.\n입력페이지로 다시 이동합니다.');
	//location.href = 'dept_regForm.jsp';
	window.history.go(-1);
</script>
<%
	}
%> --%>


<!-- el +jstl -->
<% 
	out.println(member);
	int result = 0;
	Connection conn = null;
	MemberDao dao = null;
	try {
		conn = ConnectionProvider.getConnection();
		dao = MemberDao.getInstance();
		result = dao.insertMember(conn, member);
		request.setAttribute("result",result);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	//out.println(result);
%>

<c:choose>
 	<c:when test="${!result.equals(0)}">
 		<script>
		alert('등록되었습니다.');
		location.href = '<c:url value="index.jsp"/>';
		</script>
 	</c:when>
 	
 	<c:when test="${result.equals(0)}">
 		<script>
		alert('오류 발생으로 등록되지 않았습니다.\n입력페이지로 다시 이동합니다.');
		//location.href = 'dept_regForm.jsp';
		window.history.go(-1);
		</script>
 	</c:when>
</c:choose>
