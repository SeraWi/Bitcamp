package com.bitcamp.op3.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.op3.member.domain.MemberRegRequest;
import com.bitcamp.op3.member.service.MemberRegService;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {
	
	@Autowired
	MemberRegService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String regFom() {
		
		return "member/regForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String reg(
			@ModelAttribute("regRequest")MemberRegRequest regRequest,
			HttpServletRequest request,
			Model model
			) {
		System.out.println(regRequest);
		int result =service.memberReg(regRequest, request);
		
		model.addAttribute("result",result);
		
		String view ="member/reg";
		
		if(result==1) {
			//로그인 되면 인덱스 페이지로 리다이렉트!
			//리다이렉트 == 새로운 요청!! model정보가 parameter로 uri에 남는다. 
			view ="redirect:/index";
		}
		
		return view;
	}
	
}
