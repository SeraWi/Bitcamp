<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	//사용자가 전달한 데이터
	request.setCharacterEncoding("utf-8");
	String id= request.getParameter("id");
	String pw =request.getParameter("pw");
	String name = request.getParameter("name");
	String birthyear =request.getParameter("birthyear");
	String birthmonth =request.getParameter("birthmonth");
	String birthday =request.getParameter("birthday");
	String sex = request.getParameter("sex");
	String email = request.getParameter("email");
	String countryCode = request.getParameter("countryCode");
	String tel = request.getParameter("tel");
	String checkNum = request.getParameter("checkNum");
	
	
/* 	request.setAttribute("id", name);
	request.setAttribute("pw", pw);
	request.setAttribute("name",name);
	request.setAttribute("birthyear", birthyear);
	request.setAttribute("birthmonth",birthmonth);
	request.setAttribute("birthday",birthday);
	request.setAttribute("sex",sex);
	request.setAttribute("email",email);
	request.setAttribute("countryCode",countryCode);
	request.setAttribute("tel",tel);
	request.setAttribute("checkNum",checkNum); */
	
%>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
<style>
</style>
<script>
</script>
</head>
<body>
	<h1>회원 정보 보기</h1>
	<hr>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><%=id %></td>
		</tr>

		<tr>
			<td>비밀번호</td>
			<td><%=pw %></td>
		</tr>

		<tr>
			<td>이름</td>
			<td><%=name %></td>
		</tr>

		<tr>
			<td>태어난 해</td>
			<td><%=birthyear %></td>
		</tr>

		<tr>
			<td>태어난 달</td>
			<td><%=birthmonth %></td>
		</tr>

		<tr>
			<td>태어난 달</td>
			<td><%=birthmonth %></td>
		</tr>

		<tr>
			<td>태어난 날</td>
			<td><%=birthday %></td>
		</tr>

		<tr>
			<td>이메일</td>
			<td><%=email %></td>
		</tr>

		<tr>
			<td>국가코드</td>
			<td><%=countryCode %></td>
		</tr>

		<tr>
			<td>전화번호</td>
			<td><%=tel %></td>
		</tr>

		<tr>
			<td>인증번호</td>
			<td><%=checkNum %></td>
		</tr>




	</table>
</body>
</html>


