package com.bitcamp.op3.member.service;

import java.sql.Connection;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op3.member.dao.Dao;
import com.bitcamp.op3.member.dao.jdbcTemplateMemberDao;
import com.bitcamp.op3.member.dao.mybatisMemberDao;
import com.bitcamp.op3.member.domain.Member;

@Service
public class LoginService {
	
//	@Autowired
//	MemberDao dao;
	
//	@Autowired
//	private jdbcTemplateMemberDao dao;
	
	
//	@Autowired
//	private mybatisMemberDao dao;
	
	
	@Autowired
	private SqlSessionTemplate template;
	private Dao dao;
	
	public boolean login(
			String id, 
			String pw,
			String reid, 
			HttpSession session,
			HttpServletResponse reponse
			){
		
		boolean loginChk = false;
		
		
		
		//인터페이스 Dao 구현체 Mapper
		dao = template.getMapper(Dao.class);
		System.out.println("인터페이스 매퍼 dao생성");
		
		Member member = dao.selectByIdPw(id, pw);
		
		//전달받은 id와 pw로 DB에서 검색
		//있다면 로그인 true, 없다면 false
		
		if(member != null) {
			//로그인 처리
			//로그인 정보 세션에 저장
			session.setAttribute("loginInfo",member.toLoginInfo());
			
			loginChk = true;
			
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
