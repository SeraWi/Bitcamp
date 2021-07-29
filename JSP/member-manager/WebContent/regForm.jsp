<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value='/css/default.css'/>">
<style>
	.display_none {
		display: none;
	}
	.color_blue {
		color : blue;
	}
	.color_red {
		color : red;
	}
	#loadingimg {
		height : 20px;
	}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- <script>
	$(document).ready(function(){
		//입력창에 포커스 들어왔을 때 이벤트
		$('#memberid')focusin(function(){
			//메세지는 보여지지 않게
			$('#msg').addClass('display_none');
			//컬러 설정 삭제
			$('#msg').removeClass('color_blue');
			$('#msg').removeClass('color_red');
			//이벤트가 발생한 곳
			//커서가 들어가면 입력창에 적었던거 지워진다.
			$(this).val('');
		});
		
		//포커스 아웃
		$('#memberid').focusout(function(){
			//ajax 비동기 통신 -> id를 서버로 보내고 사용 가능 유무의 응답 코드를 받는다. ->화면에 메시지 출력
			$.ajax({
				url:'idcheck.jsp',
				type:'post',
				data: {
					//this==현재 발생 이벤트 memberid의 value(입력값)캐스팅
					mid : $(this).val()
					},
				//보내기전
				beforeSend : function(){
					//서버 통신 전 로딩이미지 보여주기
					$('#loadingimg').removeClass('display_none');
				},
				//통신하고 성공시
				success: function(data){
					//data : Y 또는 N을 서버에서 내보낸다.
					if(data == 'Y'){
						//사용가능한 아이디 입니다 ==Y, 글자색 blue, display를 보여주도록
						$('#msg').html('사용가능');
						$('#msg').addClass('color_blue');
						//디스플레이 안보이도록하는 클래스 제거 -> 화면에 보인다.
						$('#msg').removeClass('display_none');
					}else{
						//사용 불가능한 아이디 입니다 ==N, 글자색 red, display를 보여주도록
						$('#msg').html('사용불가능');
						$('#msg').addClass('color_red');
						//디스플레이 안보이도록하는 클래스 제거 -> 화면에 보인다.
						$('#msg').removeClass('display_none');
					}
				},
				
				// 에러
				error : function(request, status, error){
					alert('서버 통신에 문제가 발생했습니다. 다시 실행해주세요.');
					console.log(request);
					console.log(status);
					console.log(error);
				},
				complete : function(){
					//로딩 완료되면 로딩되는 이미지 보이지 않도록
					$('#loadingimg').addClass('display_none');
				}
			});
			
		});
		
	});
</script> -->
<script>
	
	$(document).ready(function(){
		
		$('#memberid').focusin(function(){
			$('#msg').addClass('display_none');
			$('#msg').removeClass('color_blue');
			$('#msg').removeClass('color_red');
			
			$(this).val('');
		});
		
		$('#memberid').focusout(function(){
			// ajax 비동기 통신 > id를 서버로 보내고 사용 가능 유무의 응답 코드를 받는다 -> 화면에 메시지 출력
			
			$.ajax({
				url : 'idcheck.jsp',
				type : 'post',
				data : {
					//this==현재 발생 이벤트 memberid의 value(입력값)캐스팅
					mid : $(this).val()
				},
				beforeSend : function(){
					$('#loadingimg').removeClass('display_none');
				} ,
				success : function(data){
					// data : Y / N
					if(data == 'Y'){
						$('#msg').html('사용가능');
						$('#msg').addClass('color_blue');
						$('#msg').removeClass('display_none');
					} else {
						$('#msg').html('사용 불가능');
						$('#msg').addClass('color_red');
						$('#msg').removeClass('display_none');
					}
				},
				error : function(request, status, error){
					alert('서버 통신에 문제가 발생했습니다. 다시 실행해주세요.');
					console.log(request);
					console.log(status);
					console.log(error);
				},
				complete : function(){
					$('#loadingimg').addClass('display_none');
				}
			});
			
		});
		
	});
	
</script>
</head>
<body>

	<%@ include file="/WEB-INF/frame/header.jsp"%>

	<%@ include file="/WEB-INF/frame/nav.jsp"%>

	<div class="contents">

		<h2>회원가입</h2>
		<hr>
		<form action="memberReg.jsp" method="post"  enctype="multipart/form-data"> 
			<table>
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="memberid" id="memberid">
						<span id="msg" class="display_none"></span>
						<img id="loadingimg" class="display_none" alt="loading" src="<c:url value="/image/loading.gif"/>"> 
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="membername"></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="photo"></td>
				</tr>				
				<tr>
					<td></td>
					<td>
						<input type="submit">
						<input type="reset" >
					</td>
				</tr>
			</table>
		</form>


	</div>


</body>
</html>
