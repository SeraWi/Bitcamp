package com.bitcamp.op2.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op2.member.dao.Dao;
import com.bitcamp.op2.member.domain.Member;

@Service
public class MemberRestService {
	
	@Autowired
	private SqlSessionTemplate template;
	private Dao dao;
	
	
	public Member getMember(int idx) {
		
		Member member= null;
		dao = template.getMapper(Dao.class);
		
		return member;
	}
}
