package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}
	
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 사용자의 요청 분석: type파라미터의 값을 분석
		
		String type =request.getParameter("type");
		
		//결과 Data
		Object resultObj = null;
		//view 페이지 
		String viewPage = "/WEB-INF/views/default.jsp";
		
		//2.요청을 처리: 모델 선택 실행 ->요청을 처리할 수 있는 Service를 선택
		if(type == null || type.equals("greeting")) {
			resultObj="안녕하세요";
			viewPage="/WEB-INF/views/greeting.jsp";
		}else if(type.equals("date")){
			resultObj = new Date();
			viewPage="/WEB-INF/views/date.jsp";
		}else {
			resultObj = "invliad";
		}
		
		//3.결과 데이터를 공유(전달)
		request.setAttribute("result", resultObj);
		
		//4.viewpgage로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
	
}
