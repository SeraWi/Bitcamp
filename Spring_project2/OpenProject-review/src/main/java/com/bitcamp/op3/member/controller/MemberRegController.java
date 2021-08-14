package com.bitcamp.op3.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.op3.member.domain.MemberRegRequest;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String regFom() {
		
		return "member/regForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String reg(
			@ModelAttribute("regRequest")MemberRegRequest regRequest
			) {
		System.out.println(regRequest);
		return "member/reg";
	}
	
}
