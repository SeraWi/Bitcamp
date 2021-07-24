<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선택한 product출력</title>
<style>
</style>
<script>
</script>
</head>
<body>
	<h3>
		1.선택한 상품(표현언어): ${param.select} <br>
		2.선택한 상품(표현식): <%= (String)request.getParameter("select")%> <br>
		2.상품 설명: ${product.display}<br>
		3.첫번째 상품: ${product.productList[0]} <Br>
	
	</h3>

</body>
</html>