package com.bitcamp.op2.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.op2.member.domain.Member;

@Controller
public class MemberRestController {
	
	
	@RequestMapping("/members/{id}")
	public Member getMember(
			@PathVariable("id")int idx
		) {
		
		Member member = null;
		 
		return member; 
	}
}
