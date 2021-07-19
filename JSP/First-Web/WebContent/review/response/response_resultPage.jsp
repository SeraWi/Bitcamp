<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
</script>
</head>
<body>

	<%
		//파라미터 받아오기
		//getParameter -> string 반환
		String select = request.getParameter("select");
		int selNum =Integer.parseInt(select);
		
		if(selNum>0){
			out.println(selNum);
			response.sendRedirect("result.jsp");
			
		}else{
			out.println(selNum);
			%>
			<!-- resultPage.jsp응답아니라 result.jsp응답처리한다. -->
			<jsp:forward page ="result.jsp"/>;
			
			<% 
		}
	%>

	
	
	
</body>
</html>