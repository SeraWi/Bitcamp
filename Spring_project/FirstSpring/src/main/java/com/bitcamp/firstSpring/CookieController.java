package com.bitcamp.firstSpring;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {

	
	//쿠키 생성해주는 요청 처리
	@RequestMapping(value="/cookie/make")
	public String makeCookie(HttpServletResponse response) {
		Cookie c = new Cookie("username","KING");
		response.addCookie(c);
		
		//Service.process(response);
		
		return "cookie/make";
	}
	
	@RequestMapping(value="/cookie/view")
	public String viewCookie(
			@CookieValue(value="usernames",defaultValue="SCOTT") String userName,
			Model model
			) {
		
		//쿠키 정보 가져오기 -> @CookieValue(쿠키 이름)
		//required=false :에러페이지 안나온다
		//required=true: 쿠키 정보 없는 경우 에러페이지 나온다
		// defaultValue :쿠키정보 없는 경우 기본값을 출력한다.
		
		//..받아온 Cookie정보를 이용해서 데이터 처리
		System.out.println(userName);
		
		//결과데이터 저장
		model.addAttribute("userName",userName);
		return "cookie/view";
	}
}
