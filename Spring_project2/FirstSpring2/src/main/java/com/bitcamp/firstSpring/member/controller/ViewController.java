package com.bitcamp.firstSpring.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	
	@RequestMapping("/view/view1")
	public void getPage() {
	}
}
