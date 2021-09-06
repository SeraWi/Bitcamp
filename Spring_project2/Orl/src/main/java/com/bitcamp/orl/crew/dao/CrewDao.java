package com.bitcamp.orl.crew.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bitcamp.orl.crew.domain.Crew;

public interface CrewDao {
	
	// 내가 가입한 크루(민주)
	List<Crew> selectMyCrewList(@Param("memberIdx")int memberIdx);
	
	// 내가 가입한 크루(세라 ->userFeed에 사용)
	List<Crew> selectMyCrewListinFeed(@Param("memberIdx")int memberIdx);
	
	// crew 하나의 정보 가져오기
	Crew selectCrew(@Param("crewIdx")int crewIdx);
	
	// 크루원의 수
	int selectCrewMemberNum(@Param("crewIdx")int crewIdx);
	
	// 크루 댓글 수
	int selectCrewCommentNum(@Param("crewIdx")int crewIdx);
	
	//크루....?
	int selectCountMemberToRegCrew(@Param("memberIdx")int memberIdx, @Param("crewIdx")int crewIdx);
}
