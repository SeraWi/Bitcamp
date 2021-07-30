package service;

import javax.servlet.http.HttpServletRequest;

public interface Command {
	
	//command인터페이스
	//모든 메서드가 추성메서드
	String getPage(HttpServletRequest request);
}
