package com.bitcamp.orl.feed.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.feed.dao.FeedDao;

@Service
public class UserFeedService {
	
	private FeedDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	// 팔로워 수 가져오기
	public int getFollowerCount(int memberIdx) {
		int followerCount = 0;
		
		dao = template.getMapper(FeedDao.class);
		followerCount = dao.selectFollowerCount(memberIdx);
		
		return followerCount;
	}
	
	
	// 팔로잉 수 가져오기
	public int getFollowingCount(int memberIdx){
		
		int followingCount = 0;
		
		dao=template.getMapper(FeedDao.class);
		followingCount = dao.selectFollowingCount(memberIdx);
		
		return followingCount;
		
	}
	
	
	// 팔로워 리스트 가져오기
		// 팔로잉 리스트 가져오기
	
	
	
	
}
