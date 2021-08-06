package com.bitcamp.firstSpring.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.firstSpring.member.domain.LoginInfo;
import com.bitcamp.firstSpring.member.domain.LoginRequest;

@Controller
@RequestMapping("/member/login") //브라우저에서 사용하는 URL http://localhost:8080/firstSpring/member/login
public class LoginController {

	//@RequestMapping("/member/loginForm")
	//@RequestMapping(value="/member/login", method =RequestMethod.GET)
	@RequestMapping(method=RequestMethod.GET)
	public String getLoginForm(
			@RequestParam(value ="page" , defaultValue="1") int page
			) {
		//System.out.println(page+1);
		return "member/loginForm";  //   /WEB-INF/views/member/loginForm.jsp -->뷰이름
	}
	
	
	
	//사용자의 파라미터 데이터를 받는 방법
	// 1. HttpServlterRequest 이용하기
	// 2. @RequestParam("파라미터 이름 param name")
	// 3. 커맨드 객체(Beans) 이용
	//@RequestMapping(value="/member/login",method=RequestMethod.POST)
	@RequestMapping(method=RequestMethod.POST)
	public String login(
			@RequestParam("id") String id,
			@RequestParam("pw")String pw,
			HttpServletRequest request,
			@ModelAttribute("loginReg") LoginRequest loginRequest,
			Model model
			) {
		System.out.println(id +":" + pw);
		
		//view에 전달할 데이터 저장: Model 객체를 이용 (반환을 String = view만 할 때), 같이 공유한 데이터 전달하려면 Model쓰자)
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		///---------------------------------------
		String uid = request.getParameter("id");
		String upw = request.getParameter("pw");
		System.out.println(uid +":"+ upw); //@requestParma 사용
		
		model.addAttribute("uid",uid);
		model.addAttribute("upw",upw);
		
		///---------------------------------------
		System.out.println(loginRequest); //bean 사용
		//model에 자동 저장된다.
		
		//8/6일 추가
		//세션의 속성에 loginInfo등록
		request.getSession(false).setAttribute("loginInfo", new LoginInfo());
		
		return "member/login"; // /WEB-INF/views/member/login.jsp
	}
	
}
