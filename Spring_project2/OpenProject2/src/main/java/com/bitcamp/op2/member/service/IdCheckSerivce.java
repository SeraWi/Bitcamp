package com.bitcamp.op2.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bitcamp.op2.jdbc.ConnectionProvider;
import com.bitcamp.op2.member.dao.Dao;
import com.bitcamp.op2.member.dao.JdbctemplateMemberDao;
import com.bitcamp.op2.member.dao.MemberDao;
import com.bitcamp.op2.member.dao.MybatisMemberDao;

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
	private Dao dao;
	
	public String idCheck(String id) {
		String result = "Y";
		
		//인터페이스의 멤퍼Dao생성
		dao = template.getMapper(Dao.class);
		

		if(dao.selectById(id)>0) {
			result="N";
		}
		return result;


	}
}
