package com.bitcamp.orl.feed.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.orl.feed.domain.Follow;
import com.bitcamp.orl.feed.domain.FollowList;
import com.bitcamp.orl.feed.service.UserFeedService;
import com.bitcamp.orl.member.domain.Member;

@Controller
public class UserFeedController {

	@Autowired
	UserFeedService feedService;


	//가장 첫번째 요청: 피드 보여주기 (세션에 저장된 idx 필요)
	// 1. 사용자 닉네임 --해결
	// 2. 게시물
	// 3. 팔로워 수, 팔로잉 수 -- 해결
	// 4. 내가 가입한 크루
	// 5. 내가 올린 사진 피드 전체
	@RequestMapping("/feed/userFeed")
	public String getUserFeed(
			HttpServletRequest request,
			Model model
			) {

		// 1.로그인 세션에 저장된 member객체 가져오기
		Member member = (Member) request.getSession().getAttribute("member");

		// 로그인 세션에 저장된 member객체에서 idx 뽑아서
		// follow table에서 idx에 해당하는 팔로워와 팔로우수 구해서 가져오기 -> 전달
		// 팔로워 수 구하기
		int followerCount = feedService.getFollowerCount(member.getMemberIdx());

		//팔로잉 수 구하기
		int followingCount = feedService.getFollowingCount(member.getMemberIdx());

		// 게시물 수 구하기


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

	//피드상세보기
	@RequestMapping("/feed/feedview")
	public String gerFeedView() {
		return "feed/feedview";
	}

}
