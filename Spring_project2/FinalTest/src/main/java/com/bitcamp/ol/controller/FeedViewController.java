package com.bitcamp.ol.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.bitcamp.orl.feed.domain.*;
import com.bitcamp.orl.feed.service.*;
import com.bitcamp.orl.member.domain.MemberVo;

@Controller
@RequestMapping("/feed/feedview/{memberIdx}&{boardIdx}")
public class FeedViewController {
	
	// 피드 상세보기 컨트롤러

	@Autowired
	FeedViewService viewService;

	@RequestMapping(method = RequestMethod.GET)
	public String getFeedView(
			@PathVariable("memberIdx") int memberIdx,
			@PathVariable("boardIdx") int boardIdx,
			HttpServletRequest request,
			Model model
			) {

		// 피드 상세보기
		FeedView feedview = viewService.getFeedView(boardIdx);
		model.addAttribute("selectFeedView", viewService.getFeedView(boardIdx));
		System.out.println(feedview);
		
		
		// session에 있는 나의 memberIdx 필요
	     int myIdx = ((MemberVo) request.getSession().getAttribute("memberVo")).getMemberIdx();
	    //1. 첫 요청에 하트의 결과를  보여줘야한다. 내가 이 게시물을 좋아요 하는지 안 하는지!
	     int likeStatus = viewService.getLikeStatus(myIdx,boardIdx);
	    //모델에 저장
	    model.addAttribute("likeStatus",likeStatus);
	    
	    
	    // 2. 첫 요청에 좋아요 갯수를 보여준다.
	    int totalLikeCount = viewService.getTotalLikeCount(boardIdx);
	    // 모델에 저장
	    model.addAttribute("totalLikeCount",totalLikeCount);
	    
	    
		

		return "/feed/feedview";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String getFeedView2() {
		return "feed/feedview";
	}

}

//member -> memberIdx, memberNickname
//boardPhoto -> boardIdx, boardPhoto