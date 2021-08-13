package com.bitcamp.op2.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op2.member.dao.Dao;
import com.bitcamp.op2.member.domain.Member;
import com.bitcamp.op2.member.domain.SearchType;

@Service
public class MemberListService {

	private Dao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public List<Member> getMemberList(){
		return template.getMapper(Dao.class).selectAll();
	}
	
	
	//메서드 오버로딩
	public List<Member> getMemberList(SearchType searchType){
		return template.getMapper(Dao.class).selectMember(searchType);
	}
}