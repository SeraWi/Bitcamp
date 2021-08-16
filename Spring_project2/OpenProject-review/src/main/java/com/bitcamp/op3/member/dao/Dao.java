package com.bitcamp.op3.member.dao;

import java.util.List;

import com.bitcamp.op3.member.domain.Member;

public interface Dao {
	
	//로그인하기
	Member selectByIdPw(String id, String pw);
	//아이디 중복 체크
	int selectById(String memberId);
	//회원가입
	int insertMember(Member member);
	//회원 정보 수정
	int updateMember(Member member);
	//회원 정보 삭제
	int deleteMember(int idx);
	
	//회원  전체 리스트
	List<Member> selectAll();
	
	//페이징 처리가 가능한 리스트 ->첫번째 row, 한페이지에 몇개씩
	List<Member> selectList(int startRow, int count);
	
	//전체 회원의 수
	int selectTotalCount();
}
