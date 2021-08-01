<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
	
	.display_none{
		display:none;
	}
	
	.display_block{
		display:block;
	}
</style>
<script>

	$(document).ready(function(){
		$('#idcheckBtn').click(function(){
			$.ajax({
				url:'idcheck.jsp',
				type:'post',
				data:{
					uid:$('#uid').val()
				},
				beforeSend : function(){
					console.log('beforesend');
					$('#loadingImg').removeClass('display_none');
				},
				success:function(){
				
				},
				error:function(){
					
				},
				complete:function(){
					
					setTimeout(function(){
						$('#loadingImg').addClass('display_none');
					},3000);
					
				}
				
				
			});
		});
	});
</script>
</head>
<body>
	id<input type="text" id="uid"><input type="button" id="idcheckBtn" value="아이디체크">
	<div id="msg"></div>
	<img id="loadingImg" class="display_none" alt ="loading" src="loding.gif">

</body>
</html>