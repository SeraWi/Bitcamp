package com.bitcamp.orl.feed.dao;

import java.util.List;

import com.bitcamp.orl.feed.domain.FollowList;

public interface FeedDao {
	
	//follower수 가져오기
	int selectFollowerCount(int MemberIdx);
	
	
	//following 수 가져오기
	int selectFollowingCount(int MemberIdx);
	
	
	//follower 리스트 가져오기
	List<FollowList> selectFollowerList(int MemberIdx);

	
	//follwing 리스트 가져오기
	List<FollowList> selectFollowingList(int memberIdx);

	// 게시물 갯수 가져오기
	int selectFeedCount(int memberIdx);
}
