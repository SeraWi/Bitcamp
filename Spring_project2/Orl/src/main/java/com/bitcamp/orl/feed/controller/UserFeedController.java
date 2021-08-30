package com.bitcamp.orl.feed.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.orl.feed.service.UserFeedService;
import com.bitcamp.orl.member.domain.Member;

@Controller
public class UserFeedController {
	
		@Autowired
		UserFeedService feedService;
	
	
	   //피드 보여주기 (세션에 저장된 idx 필요)
	   @RequestMapping("/feed/userFeed")
	   public String getUserFeed(
			   HttpServletRequest request,
			   Model model
			   ) {
		   
		   //로그인 세션에 저장된 member객체 가져오기
		  Member member = (Member) request.getSession().getAttribute("member");
		  
		  // 로그인 세션에 저장된 member객체에서 idx 뽑아서
		  // follow table에서 idx에 해당하는 팔로워와 팔로우수 구해서 가져오기 -> 전달
		  int followerCount = feedService.getFollowerCount(member.getMemberIdx());
		  
		  int followingCount = feedService.getFollowingCount(member.getMemberIdx());
		  
		  //member 객체 전달
		  model.addAttribute("member",member);
		  model.addAttribute("followerCount",followerCount);
		  model.addAttribute("followingCount",followingCount);
		  
	      return "feed/userFeed";
	   }
	   
	   //피드올리기
	   @RequestMapping("/feed/createFeed")
	   public String getCreateFeed() {
		   return "feed/createFeed";
	   }
	   
	   
	   //팔로워: 나를 팔로우하는 사람
	   @RequestMapping("/feed/follower")
	   public String gerFollower() {
		   return "feed/follower";
	   }
	   
	   //팔로잉: 내가 팔로우하는 사람
	   @RequestMapping("/feed/following")
	   public String gerFollowing() {
		   return "feed/following";
	   }
	   
	   
	   @RequestMapping("/feed/feedview")
	   public String gerFeedView() {
		   return "feed/feedview";
	   }

}
