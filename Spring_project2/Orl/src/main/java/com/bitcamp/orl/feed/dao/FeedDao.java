package com.bitcamp.orl.feed.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bitcamp.orl.feed.domain.Feed;
import com.bitcamp.orl.feed.domain.FeedGallery;
import com.bitcamp.orl.feed.domain.FeedLikeGallery;
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
	
	
	// 팔로우하기와 팔로우 끊기 버튼을 위해 나와 남이 팔로우 상태인지 체크하기
	int selectFollowRelation(int myIdx, int yourIdx);

	
	// 팔로우 시작하기
	int insertFollowMember(int myIdx, int yourIdx);
	
	
	// 팔로우 그만하기
	int deleteFollowMember(int myIdx, int yourIdx);

	
	// 내 피드 기본 정렬 가져오기
	List<FeedGallery> selectFeedGallery(@Param("memberIdx")int memberIdx);

	// 내 피드 좋아요 정렬 가져오기
	List<FeedLikeGallery> selectFeedLikeGallery(int memberIdx);
	
	//피드 작성 (우리언니)
	int createFeed(Feed feed);
	
	
	
	
}
