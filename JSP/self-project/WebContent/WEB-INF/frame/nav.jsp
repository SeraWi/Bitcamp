<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	//Object loginObj = session.getAttribute("member");
	  Object loginObj = session.getAttribute("loginInfo");

%>

	<nav>
		<ul>
			<% if(loginObj == null) { %>
			<!--로그인 상태 아닐 떄 회원가입과 로그인 보여주기  -->
			<li><a href="<%= request.getContextPath() %>/regForm.jsp">회원가입</a></li>
			<li><a href="<%= request.getContextPath() %>/loginForm.jsp">로그인</a></li>
			<%}  else {%>
			<!-- 로그인 상태일 때 로그아웃과 mypage보여주기 -->
			<li><a href="<%= request.getContextPath() %>/logout.jsp">로그아웃</a></li>
			<li><a href="<%= request.getContextPath() %>/member_list.jsp">회원리스트</a></li>
			<% } %>
			
			<li><a href="<%= request.getContextPath() %>/myPage.jsp">MyPage</a></li>
		</ul>
	</nav>
