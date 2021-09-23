package com.bitcamp.orl.admin.controller;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.bitcamp.orl.admin.service.*;

@Controller
public class AdminFeedDeleteController {

	
	@Autowired
	private AdminFeedService service;
	
	@RequestMapping("admin/feed/delete")
	public String CrewDelete(HttpServletRequest request, Model model) {
		
		model.addAttribute("idx",request.getParameter("boardIdx"));
		int boardIdx=Integer.parseInt(request.getParameter("boardIdx"));
		int result = service.getDeleteFeed(boardIdx);
		model.addAttribute("result", result);
		return "admin/admin_feedDelete";
	}
}
