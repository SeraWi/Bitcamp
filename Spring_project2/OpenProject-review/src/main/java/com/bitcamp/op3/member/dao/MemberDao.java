package com.bitcamp.op3.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.bitcamp.op3.jdbc.JdbcUtil;
import com.bitcamp.op3.member.domain.Member;


@Repository 
public class MemberDao {
	

//	public int insertMember(Connection conn, RegisterRequest registerRequest) throws SQLException {
//
//		int resultCnt = 0;
//
//		PreparedStatement pstmt = null;
//
//		String sql1 = "insert into member (memberid,password,membername) values (?, ?, ?)";
//		String sql2 = "insert into member (memberid,password,membername,memberphoto) values (?, ?, ?,?)";
//		try {
//			
//			if(registerRequest.getMemberphoto() == null) {
//				//사진 안 넣었을 때
//				pstmt = conn.prepareStatement(sql1);
//				pstmt.setString(1, registerRequest.getMemberid());
//				pstmt.setString(2, registerRequest.getPassword());
//				pstmt.setString(3, registerRequest.getMembername());
//								
//			}else {
//				//사진 넣었을 때
//				pstmt = conn.prepareStatement(sql2);
//				pstmt.setString(1, registerRequest.getMemberid());
//				pstmt.setString(2, registerRequest.getPassword());
//				pstmt.setString(3, registerRequest.getMembername());
//				pstmt.setString(4, registerRequest.getMemberphoto().getOriginalFilename());
//			}
//			
//			resultCnt = pstmt.executeUpdate();
//		}finally {
//			JdbcUtil.close(pstmt);
//		}
//
//		return resultCnt;
//	}

	
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
	
	
	public Member selectByIdPw(Connection conn, String id, String pw) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member where memberid =? and password = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setIdx(rs.getInt("idx"));
				member.setMemberid(rs.getString("memberid"));
				member.setPassword(rs.getString("password"));
				member.setMembername(rs.getString("membername"));
				member.setRegdate(rs.getTimestamp("regdate"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return member;
	}
	
	
//	// 아이디 중복 여부를 확인하는 메서드
//	// id값 전달 받아서 db에서 확인한후 결과를 int로 반환한다.
//	public int selectById(Connection conn, String memberid) throws SQLException {
//		int cnt = 0;
//		PreparedStatement pstmt = null;
//		ResultSet rs =null;
//		
//		//멤버아이디로 select 
//		String sql = "select count(*) from member where memberid =?;";
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1,memberid);
//			
//			rs=pstmt.executeQuery();
//			
//			if(rs.next()) {
//				cnt = rs.getInt(1);
//			}
//		}finally {
//			JdbcUtil.close(rs);
//			JdbcUtil.close(pstmt);
//		}
//		return cnt;
//	}

}