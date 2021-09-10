package com.bitcamp.orl.feed.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.feed.dao.FeedDao;
import com.bitcamp.orl.feed.domain.FeedView;

@Service
public class FeedViewService {
	
	FeedDao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	
	public FeedView getFeedView(int boardIdx) {

		FeedView feedview = null;

		dao = template.getMapper(FeedDao.class);
		feedview = dao.selectFeedView(boardIdx);

		System.out.println("feed view load");

		return feedview;

	}
	
	
	//  좋아요 상태인지 아닌지 확인
	public int getLikeStatus(int myIdx, int boardIdx) {
		int likeStatus =0;
		
		dao = template.getMapper(FeedDao.class);
		likeStatus = dao.selectLikeStatus(myIdx,boardIdx);
		
		
		return likeStatus;
	}

	// 좋아요 갯수 가져오기
	public int getTotalLikeCount(int boardIdx) {
		
		int totalLikeCount = 0;
		
		dao = template.getMapper(FeedDao.class);
		totalLikeCount = dao.selectTotalLikeCount(boardIdx);
		
		return totalLikeCount;
	}
	
}
