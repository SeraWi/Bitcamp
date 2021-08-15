package com.bitcamp.op3.member.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.op3.member.domain.Member;


@Repository 
public class jdbcTemplateMemberDao {
	
	@Autowired
	private JdbcTemplate template;
	

	public int insertMember( Member member) throws SQLException {

		
		int resultCnt = 0;
		String sql1 = "insert into member (memberid,password,membername) values (?, ?, ?)";
		String sql2 = "insert into member (memberid,password,membername,memberphoto) values (?, ?, ?,?)";
		
		if(member.getMemberphoto() != null) {
			resultCnt = template.update(
					sql2,
					member.getMemberid(),
					member.getPassword(),
					member.getMembername(),
					member.getMemberphoto()
					);
		}else {
			resultCnt = template.update(
					sql1,
					member.getMemberid(),
					member.getPassword(),
					member.getMembername()
					);
			
		}
		
		return resultCnt;
	}

	
//	public List<Member> selectList(Connection conn) {
//
//		List<Member> list = null;
//
//		Statement stmt = null;
//		ResultSet rs = null;
//
//		try {
//			stmt = conn.createStatement();
//
//			String sql = "select * from member";
//
//			rs = stmt.executeQuery(sql);
//
//			list = new ArrayList<Member>();
//
//			while (rs.next()) {
//				list.add(new Member(
//						rs.getInt(1), 
//						rs.getString(2), 
//						rs.getString(3), 
//						rs.getString(4),
//						rs.getString(5),
//						rs.getTimestamp(6)));
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			JdbcUtil.close(rs);
//			JdbcUtil.close(stmt);
//		}
//
//		return list;
//
//	}
	
	
	public Member selectByIdPw(String id, String pw) {


		
		Member member = null;
		String sql= "select * from member where memberid =? and password = ?";
		List<Member> list = template.query(
				sql,
				new MemberRowMapper(),
				id, pw
				);
		
		member = list.isEmpty()? null: list.get(0);
		
		return member;
	}
	
	
//	// 아이디 중복 여부를 확인하는 메서드
//	// id값 전달 받아서 db에서 확인한후 결과를 int로 반환한다.
	public int selectById(String memberid) throws SQLException {
		String sql = "select count(*) from member where memberid =?;";
		int cnt = template.queryForObject(sql, Integer.class, memberid);
		
		return cnt;
	}

}