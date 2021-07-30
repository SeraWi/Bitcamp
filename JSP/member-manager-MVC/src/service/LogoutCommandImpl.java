package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutCommandImpl implements Command {
	
	//로그아웃->세션 소멸시키기
	//view 지정
	
	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse reponse) {
		request.getSession().invalidate();
		return "/WEB-INF/views/logout_view.jsp";
	}

}
