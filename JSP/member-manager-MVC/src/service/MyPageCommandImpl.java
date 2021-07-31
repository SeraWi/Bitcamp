package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.domain.LoginInfo;

public class MyPageCommandImpl implements Command {
	
	
	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse reponse) {
		//세션에 저장된 로그인정보가 가져오기
		LoginInfo loginInfo = (LoginInfo) request.getSession().getAttribute("loginInfo");
		
		//request에 로그인 정보 공유
		request.setAttribute("loginInfo", loginInfo);
		return "/WEB-INF/views/myPageView.jsp";
	}

}
