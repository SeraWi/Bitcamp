package com.bitcamp.firstSpring.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
	
	private String str;
	
	@RequestMapping("error/error")
	public String getPage() {
		//주입이 정상적으로 되지 않으면 nullpointerException 발생
		System.out.println(str.charAt(0));
		
		return "index";
	}
	
	//기본적으로 예외처리 해주는 거 좋다 (잘못 주입했을 때 nullpointer자주 발생)
	
	@ExceptionHandler(NullPointerException.class)
	public String handelNullPointerException(NullPointerException e) {
		return "error/nullPointer";
	}
}
