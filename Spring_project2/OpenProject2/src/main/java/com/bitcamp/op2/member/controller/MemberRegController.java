package com.bitcamp.op2.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.op2.member.domain.MemberRegRequest;
import com.bitcamp.op2.member.service.MemberRegService;


@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {
	
	@Autowired
	private MemberRegService regService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String regForm() {
		return "member/regForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String reg(
			@ModelAttribute("regRequest") MemberRegRequest regRequest,
			HttpServletRequest request,
			Model model
			) {
		
		//System.out.println(regRequest);
		
		int result =  regService.memberReg(regRequest, request);
		
		//결과 받고 model에 저장해서 뷰에 전달
		model.addAttribute("result",result);

		String view = "member/reg";
		//result값에 따라 다른 뷰 보여주기
		
		if(result ==1) {
			//회원가입 성공 -> 첫페이지로 리다이렉트
			view="redirect:/index";
		} 
				
		return view;
	}
	
}