package com.aia.socket.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.aia.socket.domain.Message;
import com.google.gson.Gson;

public class EchoHandler extends TextWebSocketHandler {

	private static final Logger logger = LoggerFactory.getLogger(EchoHandler.class);
	
	
	//WebSocketSession: 클라이언트의 socket정보 가지는 객체 
	//소켓 서버에 접속한 모든 사용자에게 메시지를 전송할 때 사용
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	//특정 사용자에게 메시지를 전송 ->Map의 Key가 특정 사용자 의미
	private Map<String, WebSocketSession> sessionMap = new HashMap<String, WebSocketSession>();
	
	
	
	//client에서 접속을 요청하면 메소드가 실행
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		//사용자 정보 받고,Client의  WebSocketSession 을 저장
		// 사용자 id, WebSocketSession를 저장한다.
		// WebSocketSession + HttpSession 설정
		// 로그인 한 정보는 HttpSession이 가지고 있음
		
		String chatMember = (String) session.getAttributes().get("user");
		
		// 세션에 저장된 로그인 정보 전체인 loginInfo 객체를 가져와서 id 가져오기
		//String chatMember = ((LoginInfo) session.getAttributes().get("loginInfo")).getMemberId();

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>" + chatMember);

		sessionList.add(session);
		
		// 채탕 참여자의 아이디를 식별키(key)로  Map에 저장
		sessionMap.put(chatMember, session);

		logger.info("{} 연결되었습니다.", session.getId()+":"+chatMember);

		System.out.println("체팅 참여자 : " + chatMember);
	}
	
	
	//메세지 수신
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

		String chatMember = (String) session.getAttributes().get("user");
		
		//client가 전송한 데이터는json이다
		//json을 자바의 Object로 변경해줘야 한다. 
		logger.info("{}로 부터 {}를 전달 받았습니다.", chatMember, message.getPayload());
		Gson gson = new Gson();
		
		//.fromJson : json ->Java Object로 변경
		Message msg = gson.fromJson(message.getPayload(), Message.class);
		
		System.out.println(msg); //[user=cool, to=jin, articleId=12345, articleOwner=jin, message=test]
		

		// 전달 메시지
		TextMessage sendMsg = new TextMessage(gson.toJson(msg));
		
		//모든 사람에게 메세지 보내기
		for (WebSocketSession webSocketSession : sessionList) {
			// 상대방에게 메시지 전달
			webSocketSession.sendMessage(sendMsg);
			
		}
		
		//1:1메세지 보내기
		//받는 사람(특정대상) : sessionMap에서 대상 WebSocketSessoin찾기
		String to = msg.getTo();
		WebSocketSession toSession = sessionMap.get(to);
		
		//받는 사람이 있을 때 데이터, 메시지 전송
		if(toSession !=null) {
			toSession.sendMessage(sendMsg);
			
			//메세지 보내고 데이터 베이스에 저장하기
			
		}
		
		
		// 자신에게 메시지 전달
		//session.sendMessage(sendMsg); 
		
	}
	
	
	//접속 종료
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
		String chatMember = (String) session.getAttributes().get("user");
		//접속 종료 회워늬 websocketsession을 삭제
		sessionList.remove(session);
		logger.info("{} 연결이 끊김", session.getId()+chatMember);
		System.out.println("체팅 퇴장 : " + chatMember);
	}

}
