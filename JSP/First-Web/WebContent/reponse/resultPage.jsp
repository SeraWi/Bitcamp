<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		// 파라미터 받아오기
		// getParameter -> string 반환한다.
		String select = request.getParameter("select");
		// int로 바꾸기
		int selNum = Integer.parseInt(select);
		
		if(selNum>0){
			
			out.println(selNum);
			//sendRedirect(경로) -> 현재 페이지가 응답 처리되고 난 후에 경로의 페이지를 요청
			response.sendRedirect("result.jsp");
			
			
		}else{
			
			out.println(selNum);
			//forward 액션 처리
			
			%>
			<!-- 현재 페이지 resultPage.jsp 응답이 되는 것이 아니라 result.jsp파일의 결과를 응답처리한다.-->
			<jsp:forward page ="result.jsp"/>
			
			<%
			
		}
	
	
	
	%>
	
	
	
	
	
	
	
	
	
</body>
</html>