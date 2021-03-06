<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.text_right {
		text-align: right;
	}
	
	.text_left {
		text-align: left;
	}
	.chattingBox {
		padding : 15px;
		border : 1px solid #AAA;
		margin: 10px 0;
	}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>


</head>
<body>

	<h1>Chatting Page (id: ${user})</h1>
	<br>
	<form>
		<div>
			<div>
				<input type="text" id="message" />
				<input type="submit" id="sendBtn" value="전송" />
			</div>
			<br>
			<div class="well" id="chatdata">
				<!-- User Session Info Hidden -->
				<input type="hidden" value='${user}' id="sessionuserid">
			</div>
		</div>
	</form>
</body>

<script>
	//websocket을 지정한 URL로 연결
	var sock = new SockJS("<c:url value="/echo"/>");
	//websocket 서버에서 메시지를 보내면 자동으로 실행된다.
	sock.onmessage = onMessage;
	//websocket 과 연결을 끊고 싶을때 실행하는 메소드
	sock.onclose = onClose;
	
	
	$(document).ready(function(){
		
		$("form").submit(function() {
			console.log('send message...');
			sendMessage();
			
			
			//메세지 전송 누르고 나면 입력칸 안쪽에 공백으로 만들기
			$('#message').val('');
			
			$('#message').focus();
			
			
			return false;
		});
		
	});
	
	$(function() {
	});

	function sendMessage() {
		//websocket으로 메시지를 보내기
		
		
		//객체
		var msg = {
			user : '${user}',
			to : 'jin', // 현재 페이지 작성자의 id를 작성
			articleId : '${articleId}',
			articleOwner : '${articleOwner}',
			message : $("#message").val()
		};
		
		//자바스크립트 객체를 제이슨으로 만들어서 보내기
		sock.send(JSON.stringify(msg));
	}

	//evt 파라미터는 websocket이 보내준 데이터다.
	function onMessage(evt) { //변수 안에 function자체를 넣음.
		var data = evt.data; // 전달 받은 데이터
		
		//alert(data);
		
		
		//parse: json 문자열을 javascript 객체로 바꿔준다. 
		msgData = JSON.parse(data); 
		
		var sessionid = null;
		var message = null;
		
		//current session id//
		var currentuser_session = $('#sessionuserid').val();
		console.log('current session id: ' + currentuser_session);
		
		var target = $('#chattingBox-1');
		
		if(target.length==0){
			$('<div id=\"chattingBox-1\" class=\"chattingBox\"></div>').html('<h3>${user} : 게시물 작성자-'+msgData.articleOwner+'</h3>').appendTo('body');
			$('#chattingBox-1').append('<hr>')
		}

			

		// 나와 상대방이 보낸 메세지를 구분하여 출력
		// 메세지 보낸 사람과 현재 세션의 아이디가 같다면(내가 쓴거임 -> 오른쪽으로!text_right)
		if (msgData.user == currentuser_session) {
			var printHTML = "<div class='well text_right'>";
			printHTML += "<div class='alert alert-info'>";
			printHTML += "<strong>[" + msgData.user + "] -> " + msgData.message
					+ "</strong>";
			printHTML += "</div>";
			printHTML += "</div>";
	
			
			//append:아래쪽으로 계속 쌓이도록 한다.
			$('#chattingBox-1').append(printHTML);
		} else {
			//남이 보냈을 떄는 왼쪽에 보여준기 ->text_left
			var printHTML = "<div class='well text_left'>";
			printHTML += "<div class='alert alert-warning'>";
			printHTML += "<strong>[" + msgData.user + "] -> " + msgData.message
					+ "</strong>";
			printHTML += "</div>";
			printHTML += "</div>";

			$('#chattingBox-1').append(printHTML);
		}

		console.log('chatting data: ' + data);

		/* sock.close(); */
	}

	function onClose(evt) {
		$("#data").append("연결 끊김");
	}
</script>
</html>