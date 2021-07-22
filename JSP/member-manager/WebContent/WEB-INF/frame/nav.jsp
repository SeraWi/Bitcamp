<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Object loginObj = session.getAttribute("member");
	Object loginObj = session.getAttribute("loginInfo");

%>
	<nav>
		<ul>
			<% if(loginObj == null) { %>
			<!--로그인하지 않았을 경우 회원가입과 로그인만 보여주기  -->
			<li><a href="<%= request.getContextPath() %>/regForm.jsp">회원가입</a></li>
			<li><a href="<%= request.getContextPath() %>/loginForm.jsp">로그인</a></li>
			<%}  else {%>
			<!--로그인하면 로그아웃과 회원리스트만 보여주기 -->
			<li><a href="<%= request.getContextPath() %>/logout.jsp">로그아웃</a></li>
			<li><a href="<%= request.getContextPath()%>/member_list.jsp">회원리스트</a></li>
			<% } %>
			
			<!--로그인 상태이든 아니든 마이페이지 볼 수 있다.  -->
			<li><a href="<%= request.getContextPath()%>/mypage.jsp">MyPage</a></li>
			
		</ul>
	</nav>
