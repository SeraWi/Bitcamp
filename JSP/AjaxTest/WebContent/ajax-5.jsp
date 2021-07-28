<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
<script src="http://code.jquery.com/jquery-1.12.4.min.js">
	
</script>

<script>
	$(document).ready(function() {
		//제이슨데이터를 받아서 html로 파싱하기
		$.getJSON('data.json',function(data){
			$.each(data, function(index, value){
				var html='<h3>이름: '+value.name+',가격:'+value.price+'</h3>';
				$('body').append(html);
			});
		});
	});
</script>


</head>
<body>


</body>
</html>