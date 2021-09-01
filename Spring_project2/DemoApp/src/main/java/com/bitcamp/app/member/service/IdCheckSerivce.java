package com.bitcamp.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.app.member.mapper.MemberMapper;


@Service
public class IdCheckSerivce {

//	@Autowired
//	MemberDao dao;
	
//	@Autowired
//	private JdbctemplateMemberDao dao;
	
//	@Autowired
//	private MybatisMemberDao dao;
	
	
	@Autowired
	SqlSessionTemplate template;
	private MemberMapper dao;
	
	public String idCheck(String id) {
		String result = "Y";
		
		//인터페이스의 멤퍼Dao생성
		dao = template.getMapper(MemberMapper.class);
		

		if(dao.selectById(id)>0) {
			result="N";
		}
		return result;


	}
}
