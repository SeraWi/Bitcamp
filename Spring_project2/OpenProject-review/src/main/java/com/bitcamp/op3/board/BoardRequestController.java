package com.bitcamp.op3.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardRequestController {
	
	
	@RequestMapping("/board/list")
	public String getList() {
		return "board/list";
	}
}
