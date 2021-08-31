package com.bitcamp.orl.feed.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.orl.feed.dao.FeedDao;
import com.bitcamp.orl.feed.domain.Follow;
import com.bitcamp.orl.feed.domain.FollowList;

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
	
	//팔로워 리스트 가져오기
	public List<FollowList> getFollowerList(int memberIdx) {
		List<FollowList> followerList = new ArrayList<>();
		
		dao = template.getMapper(FeedDao.class);
		followerList = dao.selectFollowerList(memberIdx);
		
		return followerList;
	}
	
	
	
	// 팔로잉 수 가져오기
	public int getFollowingCount(int memberIdx){
		
		int followingCount = 0;
		
		dao=template.getMapper(FeedDao.class);
		followingCount = dao.selectFollowingCount(memberIdx);
		
		return followingCount;
		
	}


	//팔로잉 리스트 가져오기
	public List<FollowList> getFollowingList(int memberIdx) {
		List<FollowList> followingList = new ArrayList<>();
		
		dao = template.getMapper(FeedDao.class);
		followingList = dao.selectFollowingList(memberIdx);
		
		
		return followingList;
	}



	
	// 팔로워 리스트 가져오기
		// 팔로잉 리스트 가져오기
	
	
	
	
}
