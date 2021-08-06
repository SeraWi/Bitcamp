package com.bitcamp.firstSpring.member.intercepter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckIntercepter extends HandlerInterceptorAdapter {

	
	@Override
	public boolean preHandle(
			HttpServletRequest request,
			HttpServletResponse reponse,
			Object handler
			) throws IOException {
		
		System.out.println("AuthCheckInterceptor prehandle() 진입");
		
		
		//1. 로그인 여부 확인
		//2. 로그인 상태에 따라 true/ false로 리턴
		//3. 로그인 상태가 아니라면 로그인 페이지로 redirect
		
		
		//로그인 상태 확인
		HttpSession session = request.getSession(false);
		
		if(session !=null && session.getAttribute("loginInfo") !=null) {
			return true;
		}
		
		reponse.sendRedirect(request.getContextPath()+"/member/login");
		return false;
	}
	
	
}
