package com.bitcamp.op.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardListContoller {
	
	
	@RequestMapping("/board/list")
	public String getList() {
		return "board/list";
	}
}
