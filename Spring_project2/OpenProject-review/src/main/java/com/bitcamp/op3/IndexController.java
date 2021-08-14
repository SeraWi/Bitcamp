package com.bitcamp.op3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/index")
	public void index() {
		//return "index";
	}
	
	@RequestMapping("/")
	public String index1(){
		return "redirect:/index";
	}
}
