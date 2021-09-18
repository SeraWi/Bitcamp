package com.bitcamp.orl.feed.service;

import java.util.*;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.bitcamp.orl.feed.domain.*;
import com.bitcamp.orl.feed.mapper.*;

@Service
public class FeedManageService {
	
	FeedDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	//피드 삭제
	public int deleteFeed(int memberIdx, int boardIdx) {
			
		int result = 0;		
		
		dao = template.getMapper(FeedDao.class);
		result = dao.deleteFeed(memberIdx, boardIdx);
		
		return result;
	}
	
	//피드 댓글 삭제
	public int deleteComment(int boardCommentIdx) {
			
		int result = 0;
			
		dao = template.getMapper(FeedDao.class);
		result = dao.deleteComment(boardCommentIdx);
			
		return result;
	}
	
	//피드 리스트 (최신순)
	public List<NewFeedList> selectNewFeed(){
		
		System.out.println("FeedManageService - New Feed List");
		List<NewFeedList> newList = null;
		
		dao = template.getMapper(FeedDao.class);
		newList = dao.selectNewFeed();
		
		System.out.println("manage service load");
		
		return newList;
		
	}
	
	//댓글 리스트
	public List<FeedComment> selectFeedComment(int boardIdx) {
		
		System.out.println("FeedManageService - selectFeedComment in");
		List<FeedComment> feedComments = null;
		
		dao = template.getMapper(FeedDao.class);
		feedComments = dao.selectFeedComment(boardIdx);
		
		System.out.println("manage service load");
		
		return feedComments;
	}
	
	

    // 산별 피드보기 (용민 작성)
    public List<NewFeedList> getNewFeedByMountain(String mName) {
		System.out.println("FeedManageService - New Feed List");
		List<NewFeedList> newList = null;

		dao = template.getMapper(FeedDao.class);
		newList = dao.selectNewFeedByMountain(mName);

		System.out.println("manage service load");

		return newList;

	}
}
