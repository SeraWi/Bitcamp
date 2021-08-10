package com.bitcamp.op2.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op2.member.service.IdCheckSerivce;

@Controller
public class IdCheckController {
	
	@Autowired
	private IdCheckSerivce checkService;
	
	@RequestMapping(value="/member/idCheck",method=RequestMethod.POST)
	public String idCheck(
			@RequestParam("mid") String uid,
			Model model
			) {
		//서비스로 mid 넘겨서  중복되는지 확인하고 결과를 가져온다.
		
		model.addAttribute("result",checkService.idCheck(uid));
		
		
		return "member/idcheck";
	}
}
