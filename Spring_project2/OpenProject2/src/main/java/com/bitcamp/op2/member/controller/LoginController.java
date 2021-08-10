package com.bitcamp.op2.member.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op2.member.service.LoginService;

@Controller
@RequestMapping("/member/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String loginForm(
			@RequestHeader(value="referer", required=false) String redirectUri,
			Model model
			) {
		//header값 받기 (이전페이지 정보를 알기위해)
		
		//header값 전달하기 ->model에 저장!
		model.addAttribute("redirectUri",redirectUri);
		
		return "member/loginForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(
			@RequestParam("memberid") String memberid,
			@RequestParam("password") String password,
			@RequestParam(value="reid", required=false) String reid,
			@RequestParam(value="redirectUri",required=false)String redirectUri,
			HttpSession session,
			HttpServletResponse response,
			Model model
			) {
		// 사용자가 입력한 id,password,reid를 받아서 (사용자 요청 받는 방법 3가지 있다.)
		// id,password, reid ->커맨드 객체 이용해도 된다!
		// reid는 null이 들어와도 상관없다, 에러가 아니다->required=false
		// 세션을 이용하기!
		// 결과 저장하기 위해 model 필요
		
		
		// 서비스에 전달하고 로그인 처리해준다!
		boolean loginChk = loginService.login(memberid,password,reid,session,response);
		model.addAttribute("loginChk",loginChk);
		
		String view = "member/login";
		
		//로그인 된 상태라면 ->redirectUri로 넘어간다. 
		if(redirectUri != null && loginChk) {
			view = "redirect:"+redirectUri;
		}
		
		//return "member/login";
		return view;
	}
}
