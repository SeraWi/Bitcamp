<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>

	$(document).ready(function(){
		//alert("ready");
		$('#btn').click(function(){
			
			//객체로 표현하기
			$.ajax({
				//보내줘야 하는 경로
				url:'parameter.jsp',
				type:'get', //http method get,post, put, delete
				data :{
					pname:$('#pname').val(),
					price:$('#price').val()
				},  //문자열 형식 ?name=test&price=1000, 객체형식으로도 가능
				success:function(data){
					//alert(data);
					$('#menu').append(data);
				}
			});
		});
	});
</script>
</head>
<body>

 	<h1>제품 등록</h1>
 	<hr>
 	제품이름: <input type="text" id="pname"><br>
 	제품가격: <input tpye="number" id="price"><br>
 	<input id="btn" type="submit">
 	<hr>
 	<div id="menu">
 		<h3>메뉴표</h3>
 		<hr>
 		
 		
 		
 	</div>
 	
</body>
</html>