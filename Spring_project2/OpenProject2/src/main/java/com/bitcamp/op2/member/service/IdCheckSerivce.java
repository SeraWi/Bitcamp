package com.bitcamp.op2.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bitcamp.op2.jdbc.ConnectionProvider;
import com.bitcamp.op2.member.dao.MemberDao;

@Service
public class IdCheckSerivce {

	@Autowired
	MemberDao dao;

	public String idCheck(String id) {
		String result = "Y";
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			if(dao.selectById(conn, id)>0) {
				result="N";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;


	}
}
