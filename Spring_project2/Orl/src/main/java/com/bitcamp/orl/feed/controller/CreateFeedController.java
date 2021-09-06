package com.bitcamp.orl.feed.controller;

import java.io.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import com.bitcamp.orl.feed.domain.*;
import com.bitcamp.orl.feed.service.*;

@Controller
@RequestMapping("/feed/")
public class CreateFeedController {

	@Autowired
	private CreateFeedService createService;

	@RequestMapping(value = "createfeed")
	public String getCreateFeedForm() {
		return "feed/createfeed";
	}

	@RequestMapping(method = RequestMethod.POST, value = "feedview")
	public String upload(FeedCreateRequest feedrequest, Model model, HttpServletRequest request)
			throws IllegalStateException, IOException {

		model.addAttribute("boardPhoto", feedrequest.getBoardPhoto());
		model.addAttribute("boardDiscription", feedrequest.getBoardDiscription());
		model.addAttribute("hashtag", feedrequest.getHashtag());
		model.addAttribute("tag", feedrequest.getTag());
//		model.addAttribute("photoname", feedrequest.getBoardPhoto().toString());
//		
		
		createService.insert(feedrequest, request);
		
//		Feed feed = null;

		return "feed/feedview";
	}



}
