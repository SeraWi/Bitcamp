<%@page import="member.domain.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//속성 받아오기 -> list에 저장하기
	List<Member> memberList = (List<Member>)request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1,h3{
	
		margin: 10px 40px;
	}
	table{
		margin: 20px 40px;
	
	}
	button{
		width: 200px;
		height: 45px;
		margin: 20px 40px;
		
		background-color: white;
		color: black;
		
		
	}
	td{
		/* 테이블 속 회원 정보 */
		text-align: center;
		padding: 7px 13px;
	
	}
	
	th{
		 /* 테이블 제목 */
		text-align: center;
		padding: 7px 13px;
		background-color: skyblue;
	}
</style>
<script>
</script>
</head>
<body>

	<h1>회원 정보 관리 프로그램</h1>
	<hr>
	
	<h3>새로운 회원 등록하기</h3>
	<button onclick ="location.href='member_regForm.jsp;'">회원 정보 등록</button>
	<hr>
	<table border ="1">
		<h3>회원 리스트</h3>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>가입일시</th>
		</tr>
	<%
	 if(memberList !=null){
		 for(int i= 0; i<memberList.size(); i++){
			 %>
		<tr>
			<td><%= memberList.get(i).getId() %></td>
			<td><%= memberList.get(i).getPw() %></td>
			<td><%= memberList.get(i).getName() %></td>
			<td><%= memberList.get(i).getRegdate() %></td>
		</tr>	 
		 	<% 
		 }
	 }
	
	%>
	</table>
		
	
</body>
</html>