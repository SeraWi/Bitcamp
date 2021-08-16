package com.bitcamp.op3.member.service;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op3.member.dao.Dao;
import com.bitcamp.op3.member.dao.jdbcTemplateMemberDao;
import com.bitcamp.op3.member.dao.mybatisMemberDao;

@Service
public class IdCheckService {
	
//	@Autowired
//	MemberDao dao;
	
//	@Autowired
//	private jdbcTemplateMemberDao dao;
	
//	@Autowired
//	private mybatisMemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	private Dao dao;
	
	public String idCheck(String id){
		String result="Y";
		
		
		dao=template.getMapper(Dao.class);
		System.out.println("인터페이스 매퍼 Dao  생성");
		
		if(dao.selectById(id)>0) {
			result="N";
		}
		
		return result;
	}
}
