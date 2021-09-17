package com.bitcamp.orl.member.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.orl.member.domain.MemberRequest;
import com.bitcamp.orl.member.service.RegService;

@Controller
@RequestMapping("/member/reg")
public class RegController {
	
	@Autowired
	private RegService regService;
	
	@RequestMapping(method=RequestMethod.GET)
	private String regForm() {
		return  "member/regForm";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	private String reg(
			MemberRequest memberRequest,
			Model model
			) {
		int result = regService.reg(memberRequest);
		model.addAttribute("result",result);
		
		return "member/reg";
	}
	
}
