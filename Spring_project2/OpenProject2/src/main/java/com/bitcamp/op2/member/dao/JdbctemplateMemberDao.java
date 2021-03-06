package com.bitcamp.op2.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bitcamp.op2.jdbc.JdbcUtil;
import com.bitcamp.op2.member.domain.Member;


//자동 빈 등록!
@Repository 
public class JdbctemplateMemberDao {

	@Autowired
	private JdbcTemplate template;
	
	
	public int insertMember(Member member) throws SQLException {
		int resultCnt =0;
		String sql1 = "insert into member (memberid,password,membername) values (?, ?, ?)";
		String sql2 = "insert into member (memberid,password,membername,memberphoto) values (?, ?, ?,?)";
		
		if(member.getMemberphoto()!=null) {
			resultCnt = template.update(
					sql2, 
					member.getMemberid(),
					member.getPassword(),
					member.getMembername(),
					member.getMemberphoto());
		}else {
			resultCnt = template.update(
					sql1,
					member.getMemberid(),
					member.getPassword(),
					member.getMembername());
		}
		
		return resultCnt;
		
	}
	
	public int insertMember1(final Member member) throws SQLException {

		int resultCnt = 0;
		
		// 자동 증가한 컬럼의 값을 저장할 객체
		KeyHolder holder = new GeneratedKeyHolder();
		
		resultCnt = template.update(
				new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						String sql2 = "insert into member (memberid,password,membername, memberphoto) values (?, ?, ?,?)";
						PreparedStatement pstmt = con.prepareStatement(sql2, new String[] {"idx"});
						pstmt.setString(1, member.getMemberid());
						pstmt.setString(2, member.getPassword());
						pstmt.setString(3, member.getMembername());
						pstmt.setNString(4, member.getMemberphoto());
						return pstmt;
					}
				}
				, holder);
		
		Number idx = holder.getKey();
		member.setIdx(idx.intValue());
		
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


	public Member selectByIdPw( String id, String pw) {
		
		//String sql = "select * from member where memberid =? and password = ?";
		//List<Member> list= template.query(sql,new MemberRowMapper(), id, pw);
		List<Member> list= template.query(
				"select * from member where memberid =? and password = ?",
				new MemberRowMapper(), 
				id, pw);
		//Member member = list.isEmpty()? null:list.get(0);
		
		return list.isEmpty()? null:list.get(0);
	}


	// 아이디 중복 여부를 확인하는 메서드
	// id값 전달 받아서 db에서 확인한후 결과를 int로 반환한다.
	// ID 중복여부 확인을 위한 id 값으로 검색 -> 개수 반환
	public int selectById(String memberId) throws SQLException {
		
		//String sql = "select count(*) from member where memberid = ?";
		//int cnt = template.queryForObject(sql,Integer.class,memberId);
		
		//queryForObject : 행 1개만 가져올 때
		
		return template.queryForObject("select count(*) from member where memberid = ?",Integer.class,memberId);
		
	}

}