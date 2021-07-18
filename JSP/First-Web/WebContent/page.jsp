<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  지시어 include -->
	<!-- header를 외부 파일에서 가져오기  --> 
	<%@ include file="include/header.jsp"  %>
	<!-- 웹인프에 있는 파일도 가져올 수 는 있지만 웹인프를 직접 url로 들어가서 볼 수 는 없다 -->
	<!-- <%@ include file="WEB-INF/header.jsp"  %> --> 
	
<hr>
	<%@ include file="include/nav.jsp" %>

<div id="wrap">
	
	<%@ include file ="include/news.jsp" %>
	<%@ include file ="include/shopping.jsp" %>
	
</div>
		<!-- 액션  include -->

	<jsp:include page="footer.jsp">
	<!-- 실행된 JSP ->html(text)결과를 가져온다.  -->
	<!-- 파라미터 전달 param -->
		<jsp:param name ="email" value ="test@gmail.com"/>
		<jsp:param name="tel" value="010-0000-0000"/>
	</jsp:include>	
	
	
</body>
</html>