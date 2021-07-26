package filter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;

public class LoginCheckFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//필터를 이용한 응답 데이터 처리 : response
		//요청의 필터 처리: request
		// 회원의 로그인 여부 확인!! : session의 속성에 회원의 로그인 정보를 가지고 있는지 
		
		
		//1. session객체를 구한다. request.getSession(false)메서드 이용
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		// getSession(true) : 세션이 존재하면 현재 세션을 반환, 세션 객체가 없다면 새로운 세션 생성
		// getSession(false) :세션 객체가 없으면 null반환, 현재 세션 있으면 현재 세션 반환
		// getSession() :현재 세션 아이디와 같은 세션을 반환, 없으면 null 반환
		
		//세션 객체에 userName 속성이 있다면 원래 요청 처리를 진행
		// 없다면 로그인 처리해야한다. -> 로그인 폼으로 이동하기 (로그인단계로 이동시키기)
		
		if(session !=null && session.getAttribute("userName") !=null) {
			// 로그인되어 있는 상태!!!
			chain.doFilter(request,response); // 다음 필터를 실행, 현재 필터가 마지막 필터일 경우 실제 요청을 처리(해당 서블릿으로 보낸다)
			
		} else {
			//로그인 되어 있지 않으면 로그인 폼(view 페이지)으로 보내기 
			String viewPage = "/member/loginForm.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request,response);
		}
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
