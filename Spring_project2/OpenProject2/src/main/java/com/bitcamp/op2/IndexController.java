package com.bitcamp.op2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/index")
	public void index() {
		//void일 경우 @RequestMapping("/index")에서 index와 일치한 views아래 jsp파일 자동을 찾는다!
	}
	
	@RequestMapping("/index2")
	public void index2() {
		//void일 경우 @RequestMapping("/index")에서 index와 일치한 views아래 jsp파일 자동을 찾는다!
	}
	
	
	@RequestMapping("/")
	public String index1() {
		System.out.println("/진입");
		return "redirect:/index";
	}
}
