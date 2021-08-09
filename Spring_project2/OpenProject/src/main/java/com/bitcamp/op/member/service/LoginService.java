package com.bitcamp.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.domain.Member;

@Service
public class LoginService {
	
	@Autowired
	MemberDao dao;
	
	public boolean login(
			String id, 
			String pw, 
			String reid, 
			HttpSession session,
			HttpServletResponse reponse) {
		//파라미터: 사용자 id,pw,reid, session필요,reponse 객체(쿠키 객체 만들려면 필요)
		//반환 : 로그인 되었는지 안되었는지 ->boolean
		
		boolean loginChk = false;
		
		Connection conn= null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			// 1. 전달받은 id와 pw로 db에서 검색한다
			// 2. 있다면 로그인 처리 true return
			// 3. 없다면 false return
			
			Member member =dao.selectByIdPw(conn, id, pw);
			
			if(member !=null) {
				//member가 있다, 로그인 처리 하기
				
				//session에 저장해준다
				//저장해줄 때 loginInfo객체로 하기!
				session.setAttribute("loginInfo", member.toLoginInfo());
				
				loginChk = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		//쿠키쿠키!!
		if(reid!=null && reid.length()>0) {
			// 아이디 저장하기 위해서는 쿠키 저장해야한다.
			// 쿠키 만들기
			Cookie cookie = new Cookie("reid", id);
			
			//쿠키 설정: 쿠키의 경로
			cookie.setPath("/");
			//쿠키 설정: 쿠키의 생명주기 ->얼마나 오래 저장할건지/ 초단위임
			cookie.setMaxAge(60*60*24*365); //1년 저장
			
			//쿠키 저장하기
			reponse.addCookie(cookie);	
		}else {
			//아이디 기억하기 체크 풀렸거나 애초에 없거나
			Cookie cookie = new Cookie("reid", id);
			
			cookie.setPath("/");
			cookie.setMaxAge(0); //쿠키 삭제하기->0으로 만들기
			
			//쿠키 저장하기
			reponse.addCookie(cookie);	
		}
		
		
		
		return loginChk;
	}
}
