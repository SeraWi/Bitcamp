package com.bitcamp.op3.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op3.jdbc.ConnectionProvider;
import com.bitcamp.op3.member.dao.MemberDao;
import com.bitcamp.op3.member.domain.Member;

@Service
public class LoginService {
	
	@Autowired
	MemberDao dao;
	
	public boolean login(
			String id, 
			String pw,
			String reid, 
			HttpSession session,
			HttpServletResponse reponse
			){
		
		boolean loginChk = false;
		
		Connection conn = null;
				
		try {
			conn = ConnectionProvider.getConnection();
			Member member = dao.selectByIdPw(conn, id, pw);
			
			//전달받은 id와 pw로 DB에서 검색
			//있다면 로그인 true, 없다면 false
			
			if(member != null) {
				//로그인 처리
				//로그인 정보 세션에 저장
				session.setAttribute("loginInfo",member.toLoginInfo());
				
				loginChk = true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//아이디 저장을 위한 Cookie 설정------------------------------
		if(reid !=null && reid.length()>0) {
			//아이디 기억하기 체크하면
			Cookie cookie = new Cookie("reid",id);
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24*365); //1년저장
			
			reponse.addCookie(cookie);
		}else {
			//아이디 기억하기 체크 풀었을때
			Cookie cookie = new Cookie("reid",id);
			cookie.setPath("/");
			cookie.setMaxAge(0); //1년저장
			
			reponse.addCookie(cookie);
		}
	
		
		return loginChk;
	}
}
