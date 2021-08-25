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
		
		
		//객체로 표현하기
		$.ajax({
			url:'parameter.jsp',
			type:'get', //http method get,post, put, delete
			data :{
				pname:'우유',
				price:1000
			},  //문자열 형식 ?name=test&price=1000, 객체형식으로도 가능
			success:function(data){
				alert(data);
				$('body').html(data);
			}
			
			
		});
		
		
	});
</script>
</head>
<body>
	ajax.-2.jsp
</body>
</html>