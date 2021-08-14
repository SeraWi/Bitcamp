package com.bitcamp.op3.member.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op3.member.service.LoginService;

@Controller
@RequestMapping("/member/login")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String loginForm(
			@RequestHeader(value="referer", required=false) String redirectUri,
			Model model
			) {
		//이전페이지 경로 model에 담아서 보내기
		model.addAttribute("redirectUri", redirectUri);
		return "member/loginForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String login(
			@RequestParam("memberid") String memberid,
			@RequestParam("password") String password,
			@RequestParam(value ="reid",required=false) String reid,
			@RequestParam(value="redirectUri", required=false)String redirectUri,
			HttpSession session,
			HttpServletResponse reponse,
			Model model
			) {
		
		//requestparam :form정보가져오기
		//httpsession : 세션에 저장하기 위해
		//httpServletResponse : 쿠키 생성하고 전달하기위해
		//required: 아이디 기억하기 체크안할 수도 있는데  안 했을 때 에러로 인식하지 않기 위해 required=false
		//기본값은 required= true임
		
		//사용자가 입력한 id와 pw서비스에 전달해서 로그인 처리
		
		boolean loginChk = loginService.login(memberid, password, reid, session, reponse);
		
		//로그인 결과 저장
		model.addAttribute("loginChk", loginChk);
		
		
		//방명록 눌렀을 떄 로그인 세션 정보 없으면 /member/login으로 보내짐
		//이때 방명록 페이지들렀던 redirectUri를 requestParam으로 가져와서
		//로그인 성공하게 되면 그 redirectUri로 보내버리기!
		String view ="member/login";
		
		if(redirectUri !=null && loginChk) {
			view ="redirect:"+redirectUri; //redirectUri: /board/list임!!
		}
		
		return view;
	}
	
//	private boolean chkURI(String uri) {
//		boolean chk= true;
//		if(!uri.startsWith("/op3")) {
//			chk=false;
//		}
//		return chk;
//	}
}
