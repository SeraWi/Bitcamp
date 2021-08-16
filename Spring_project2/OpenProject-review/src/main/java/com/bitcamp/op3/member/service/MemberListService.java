package com.bitcamp.op3.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op3.member.dao.Dao;
import com.bitcamp.op3.member.domain.Member;
import com.bitcamp.op3.member.domain.SearchType;

@Service
public class MemberListService {
	
	@Autowired
	private SqlSessionTemplate template;
	private Dao dao;
	
	//검색어 없을 떄-> 전체 보여주기
	public List<Member> getMemberList(){
		return template.getMapper(Dao.class).selectAll();
	}
	
	//오버로딩 ->검색어 있을 때
	public List<Member> getMemberList(SearchType searchType){
		return template.getMapper(Dao.class).selectMember(searchType);
	}
	
}
