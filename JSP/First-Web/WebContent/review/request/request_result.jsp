<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	//한글로 받아오기
	request.setCharacterEncoding("utf-8");
	//정보 가져오기
	String userName =request.getParameter("username"); 
	String job =request.getParameter("job");
	
	//여러 데잍 가져오기
	//배열로 받아오기
	String[] interests = request.getParameterValues("interest");
	
	//속성정의
	request.setAttribute("userName", userName);
	request.setAttribute("job", job);
	request.setAttribute("age", 30); //autoboxing


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
</script>
</head>
<body>
<h1>request Form Test</h1>
	<hr>
	
	
		<table border="1">
			<tr>
				<td>이름</td>
				<td>
					<%=userName %>
				</td>
				
				
			</tr>

			<tr>
				<td>직업</td>
				<td>
					<%=job %>
				</td>
			</tr>

			<tr>
				<td>관심사항</td>
				<td>
					<%
					if(interests != null && interests.length>0){
						for(int i= 0; i<interests.length; i++){
							out.println(interests[i]+"<br>");
						}
					}
					
					%>
				</td>
				
			</tr>
			
			<tr>
				<td><jsp:include page="view.jsp"/></td>
				
			</tr>

		</table>

</body>
</html>