package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 사용자의 요청 분석:uri를 추출해서 사용하기
		//String type = request.getParameter("type"); 
		String commandUri = request.getRequestURI();
		// http://localhost:8080/mvc/guest/list.do ->/mvc/guest/list.do ( -->URI )
		
		//contextpath제거하기
		if(commandUri.indexOf(request.getContextPath())==0) {
			//contextpath의 인덱스가 0이다 == contextpath로 시작한다.
			
			//substring(beginindex)
			commandUri = commandUri.substring(request.getContextPath().length());
		}
		
		//결과 data
		Object resultObj = null;
		
		//view 페이지
		//controller 통해서만 view페이지 볼 수 있다.
		String viewPage = "/WEB-INF/views/default.jsp";
		
		//2. 요청을 처리 : 모델 선택 실행 -> 요청을 처리할 수 있는 service
		if(commandUri==null || commandUri.equals("/greeting.do")) { //http://localhost:8080/mvc/greeting.do
			//처리할 수 있는 서비스의 메소드 실행
			resultObj = "안녕하세요";
			viewPage ="/WEB-INF/views/greeting.jsp";
			
		}else if(commandUri.equals("/date.do")) {
			resultObj = new Date();
			viewPage ="/WEB-INF/views/date.jsp";
			
		} else {
			resultObj = "Invalid Request";
		}
		
		//3.결과 데이터를 공유(전달)
		request.setAttribute("result", resultObj);
		
		//4.viewPage로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
}
