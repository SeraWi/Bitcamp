package com.bitcamp.orl.feed.dao;

public interface FeedDao {
	
	//follower수 가져오기
	int selectFollowerCount(int MemberIdx);
	
	
	//following 수 가져오기
	int selectFollowingCount(int MemberIdx);
	
}
