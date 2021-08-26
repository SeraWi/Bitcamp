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
		//XML파일 조작하기
		
		$.ajax({
			url:'data.xml',
			success:function(data){
				
				$(data).find('product').each(function(){
						//this=각각의 product객체
					var pname =$(this).find('name').text();
					var price =$(this).find('price').text();
					var html='<h3>이름:'+pname+',가격:'+price+' </h3>';
					$('body').append(html);
				});
			} // success end
		});/*ajax end */
		
	});/* ready 끝 */
</script>
</head>
<body>
	TEST
</body>
</html>