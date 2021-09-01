package com.bitcamp.orl.feed.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.orl.feed.domain.FollowList;
import com.bitcamp.orl.feed.service.UserFeedService;
import com.bitcamp.orl.member.domain.Member;

@RestController
public class FollowController {
	
	
	@Autowired
	UserFeedService feedService;
		
		//팔로잉 리스트 출력 : 내 피드
//		@RequestMapping("/feed/followingList")
//		public List<FollowList> getFollowingList(
//				HttpServletRequest request,
//				Model model
//				) {
//			Member member = (Member) request.getSession().getAttribute("member");
//			
//			//팔로잉 리스트 가져오기
//			List<FollowList> followingList =feedService.getFollowingList(member.getMemberIdx());
//			//System.out.println(followingList); 
//			
//			
//			//비동기 통신의 결과 데이터 json
//			return followingList;
//		}
//		
		//팔로워 리스트 출력: 내 피드
//		@RequestMapping("/feed/followerList")
//		public List<FollowList> getFollowerList(
//				HttpServletRequest request,
//				Model model
//				) {
//			Member member = (Member) request.getSession().getAttribute("member");
//			
//			//팔로잉 리스트 가져오기
//			List<FollowList> followerList =feedService.getFollowerList(member.getMemberIdx());
//			System.out.println(followerList); //확인!
//			
//			return followerList;
//		}
	
	
	
		@RequestMapping("/feed/followerList/{memberIdx}")
		public List<FollowList> getFollowerList(
				@PathVariable("memberIdx") int memberIdx,
				Model model
				) {
			
			//팔로잉 리스트 가져오기
			List<FollowList> followerList =feedService.getFollowerList(memberIdx);
			System.out.println(followerList); //확인!
			
			return followerList;
		}
		
		
		//팔로잉 리스트 출력: 내 피드 이던 남 피드 이던 memberIdx로 팔로잉 리스트 찾기
		@RequestMapping("/feed/followingList/{memberIdx}")
		public List<FollowList> getFollowingList(
				@PathVariable("memberIdx") int memberIdx,
				Model model
				) {
			
			//팔로잉 리스트 가져오기
			List<FollowList> followingList =feedService.getFollowingList(memberIdx);
			System.out.println(followingList); 
			
			
			//비동기 통신의 결과 데이터 json
			return followingList;
		}
	
	
}
