package com.bitcamp.orl.member.dao;

import org.apache.ibatis.annotations.Param;

import com.bitcamp.orl.member.domain.Member;

public interface Dao {
	
	//회원가입
	int insertMember(Member member);
	
	//로그인
	Member selectByIdPw(@Param("memberId")String memberId, @Param("memberPw")String memberPw);

}
