package com.bitcamp.orl.feed.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.bitcamp.orl.feed.domain.*;
import com.bitcamp.orl.feed.service.*;
import com.bitcamp.orl.member.domain.MemberDto;

@Controller
public class FeedViewController {

	// 피드 상세보기 컨트롤러

	@Autowired
	private FeedViewService viewService;

	@Autowired
	private FeedCommentingService commentingService;


	// 피드 상세보기 처음 요청
	@RequestMapping("/feed/feedview/{memberIdx}&{boardIdx}")
	public String getFeedView(
			@PathVariable("memberIdx") int memberIdx,
			@PathVariable("boardIdx") int boardIdx,
			HttpServletRequest request,
			Model model
			) {

		// 1) 피드 상세  정보
		FeedView feedview = viewService.getFeedView(boardIdx);
		//System.out.println("feedview controller => "+feedview);

		// 2) 하트의 상태(좋아요 상태인지 아닌지)
		// session에 있는 나의 memberIdx 필요
		int myIdx = ((MemberDto) request.getSession().getAttribute("memberVo")).getMemberIdx();
		int likeStatus = viewService.getLikeStatus(myIdx,boardIdx);

		// 3) 하트의 갯수
		int totalLikeCount = viewService.getTotalLikeCount(boardIdx);

		// 모델에 저장
		model.addAttribute("selectFeedView", viewService.getFeedView(boardIdx));
		model.addAttribute("likeStatus",likeStatus);
		model.addAttribute("totalLikeCount",totalLikeCount);

		return "/feed/feedview";
	}

	// 댓글 작성용 
	@RequestMapping(value="/feed/feedview/{memberIdx}&{boardIdx}", method = RequestMethod.POST)
	public String postFeedView(
			@PathVariable("boardIdx") int boardIdx,
			@PathVariable("memberIdx") int memberIdx,
			FeedCommentRequest commentRequest,
			HttpServletRequest request,
			Model model
			) {

		// 1) 피드 상세 정보
		FeedView feedview = viewService.getFeedView(boardIdx);
		//System.out.println("feedview controller => "+feedview);

		// 2) 댓글 작성 insert
		commentingService.insertComment(commentRequest, request);

		// session에 있는 나의 memberIdx 필요
		int myIdx = ((MemberDto) request.getSession().getAttribute("memberVo")).getMemberIdx();

		// 3) 하트 상태
		int likeStatus = viewService.getLikeStatus(myIdx,boardIdx);

		// 4) 하트 갯수
		int totalLikeCount = viewService.getTotalLikeCount(boardIdx);

		//모델에 저장
		model.addAttribute("selectFeedView", viewService.getFeedView(boardIdx));
		model.addAttribute("boardCommentIdx", commentRequest.getBoardCommentIdx());
		model.addAttribute("comment", commentRequest.getComment());
		model.addAttribute("boardIdx", commentRequest.getBoardIdx());
		model.addAttribute("memberIdx", commentRequest.getMemberIdx());
		model.addAttribute("likeStatus",likeStatus);
		model.addAttribute("totalLikeCount",totalLikeCount);

		return "redirect:/feed/feedview/"+memberIdx+"&"+boardIdx;
	}



	// 피드 수정
	@RequestMapping(value = "/feed/feedview/editfeed/{memberIdx}&{boardIdx}", method = RequestMethod.POST)
	public String postEditFeed(
			@PathVariable("boardIdx") int boardIdx,
			FeedEdit feedEdit,
			HttpServletRequest request,
			Model model) {

		int result = viewService.editFeed(boardIdx, feedEdit, request);
		
		//모델에 저장
		model.addAttribute("boardDiscription", feedEdit.getBoardDiscription());
		model.addAttribute("hashtag", feedEdit.getHashtag());
		model.addAttribute("tag", feedEdit.getTag());

		return "/feed/feedview";
		
	}

}
