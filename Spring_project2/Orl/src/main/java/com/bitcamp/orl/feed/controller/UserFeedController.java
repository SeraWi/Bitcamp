package com.bitcamp.orl.feed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserFeedController {
	
	
	   
	   @RequestMapping("/feed/userFeed")
	   public String getIndexPage() {
	      return "feed/userFeed";
	   }
	   

}
