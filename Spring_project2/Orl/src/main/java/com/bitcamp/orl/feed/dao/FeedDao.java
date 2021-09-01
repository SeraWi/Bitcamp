package com.bitcamp.orl.feed.dao;

import java.util.List;

import com.bitcamp.orl.feed.domain.FollowList;
import com.bitcamp.orl.member.domain.Member;

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
	
	
	// 남피드 출력 위해 필요한 member 객체 가져오기(한행)
	Member selectOneMember(int memberIdx);
	
}
