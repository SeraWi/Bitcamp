package com.bitcamp.orl.feed.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.feed.domain.FollowList;
import com.bitcamp.orl.feed.service.UserFeedService;
import com.bitcamp.orl.member.domain.Member;

@RestController
public class FollowController {
	
	
	@Autowired
	UserFeedService feedService;
		
	//팔로우(팔로잉, 팔로워)리스트 보여주기 -- 클릭 했을 비동기 통신으로!
		// 매핑, 뷰지정, memberidx 넘겨서 서비스 연결
		@RequestMapping("/feed/followingList")
		public List<FollowList> getFollowingList(
				HttpServletRequest request,
				Model model
				) {
			Member member = (Member) request.getSession().getAttribute("member");
			
			//팔로잉 리스트 가져오기
			List<FollowList> followingList =feedService.getFollowingList(member.getMemberIdx());
			System.out.println(followingList); 
			
			
			//비동기 통신의 결과 데이터 json
			return followingList;
		}
		
		
		@RequestMapping("/feed/followerList")
		public List<FollowList> getFollowerList(
				HttpServletRequest request,
				Model model
				) {
			Member member = (Member) request.getSession().getAttribute("member");
			
			//팔로잉 리스트 가져오기
			List<FollowList> followerList =feedService.getFollowerList(member.getMemberIdx());
			System.out.println(followerList); //확인!
			
			return followerList;
		}

	
	
}
