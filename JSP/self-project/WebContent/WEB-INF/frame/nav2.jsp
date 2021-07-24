<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<nav>
		<ul>
			<li><a href="<%= request.getContextPath() %>/regForm.jsp">회원가입</a></li>
			<li><a href="<%= request.getContextPath() %>/loginForm.jsp">로그인</a></li>
			<li><a href="<%= request.getContextPath() %>/logout.jsp">로그아웃</a></li>
			<li><a href="<%= request.getContextPath() %>/member_list.jsp">회원리스트</a></li>
			<li><a href="<%= request.getContextPath() %>/mypage.jsp">MyPage</a></li>
		</ul>
	</nav>
	
	<div id ="banner">
        <img src="images/window1.jpg">
        <img src="images/window2.jpg">
        <img src="images/photo.jpg">
    </div>