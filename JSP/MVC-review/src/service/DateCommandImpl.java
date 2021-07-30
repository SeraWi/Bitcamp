package service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DateCommandImpl implements Command{

	@Override
	public String getPage(HttpServletRequest request) {
		//1.결과 데이터 속성에 저장하고 전달
		//2. view 지정
		request.setAttribute("result", new Date());
		
		return "/WEB-INF/views/date.jsp";
	}
	
}
