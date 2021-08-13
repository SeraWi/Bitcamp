package com.bitcamp.op2.member.dao;

import java.util.List;

import com.bitcamp.op2.member.domain.Member;
import com.bitcamp.op2.member.domain.SearchType;

public interface Dao {
	
	//로그인
	Member selectByIdPw(String id, String pw);
	//아이디체크
	int selectById(String memberId); 
	//회원가입
	int insertMember(Member member);
	//회원정보 수정
	int updateMember(Member member);
	//회원 정보 삭제
	int deleteMember(int idx);
	
	
	//회원 리스트
	List<Member> selectAll(); 
	
	//회원리스트 위에 있는 검색
	//검색을 통한 회원 리스트
	List<Member> selectMember(SearchType searchType);
	
	
	//페이징 처리가 가능한 리스트
	List<Member> selectList(int startRow, int count); 
	//전체 회원의 수
	int selectTotalCount();
}
