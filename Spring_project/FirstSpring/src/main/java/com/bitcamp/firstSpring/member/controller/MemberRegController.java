package com.bitcamp.firstSpring.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.firstSpring.member.domain.RegisterRequest;

@Controller
@RequestMapping("/member/register")
public class MemberRegController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String getRegForm() {
		return "member/memberRegForm";
	}
	
	
	//사용자의 파라미터 받기
	@RequestMapping(method=RequestMethod.POST)
	public String register(
			@RequestParam("memberid") String memberid,
			@RequestParam("password") String password,
			@RequestParam("membername") String membername,
			HttpServletRequest request,
			RegisterRequest regRequest,
			Model model
			) {
		
		//1
		System.out.println(memberid +":"+ password+":"+membername);
		model.addAttribute("id", memberid);
		model.addAttribute("pw", password);
		model.addAttribute("name", membername);
		
		
		//2. 
		String mid = request.getParameter("memberid");
		String mpw = request.getParameter("password");
		String mname = request.getParameter("membername");
		model.addAttribute("mid", mid);
		model.addAttribute("mpw",mpw);
		model.addAttribute("mname",mname);
		System.out.println(mid +":"+mpw+":"+mname);
		
		//3.
		System.out.println(regRequest);
		
		return "member/memberReg";
	}
}
