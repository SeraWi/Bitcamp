package com.bitcamp.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.domain.RegisterRequest;

@Service
public class MemberRegService {
	@Autowired
	MemberDao dao;
	
	
	public int register(
			RegisterRequest registerRequest
			) {
		int resultCnt = 0;
		
		Connection conn = null;
		try {
			conn= ConnectionProvider.getConnection();
			//전달받은 registerRequest를 db에 저장하고 결과값 가져오기
			resultCnt = dao.insertMember(conn, registerRequest);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return resultCnt;
	}
}
