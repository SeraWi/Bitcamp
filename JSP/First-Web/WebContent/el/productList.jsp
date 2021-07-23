<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<jsp:useBean id="product" class="product.Product" scope="session"/>
<!-- 
<hr>
1. session 객체의 product 이름의 속성이 있는지 확인한다.
2. 있다  현재 product( id="product") 이름의 변수에 session 영역에 저장 되어 있는 객체를 저장
3. 없다 -> product.Product 클래스로 객체 생성하고 -> session 영역의 속성에 id=product 이름으로 객체 저장 

 자바코드로 흐름을 보면 
//있다면 그대로 쓴다.
Product p = session.getAttribute("product");

if(p !=null){
	//없다면 객체 만들어서 쓴다.
	p = new Product();
	session.setAttribute("product",p);
}
<hr>
<%= product %> //toString 출력 

 -->


	<h1>상품 리스트 : 원하시는 상품을 선택하세요</h1>
	<form action ="productSelect.jsp" method="post">
		<select name ="select">
			<%
				for(int i=0; i <product.getProductList().length; i++){
					out.println("<option>"+product.getProductList()[i]+"</option>");
				}
			%>
		</select>
		<input type="submit">
	</form>

</body>
</html>