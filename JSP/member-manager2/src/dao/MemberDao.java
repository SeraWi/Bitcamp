package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Member;
import util.JdbcUtil;

public class MemberDao {
	//싱글톤
	
	private MemberDao() {
		
	}
	
	private static MemberDao dao = new MemberDao();
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	//member추가하기
	public int insetMember(Connection conn, Member member) {
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "insert into member (memberid,password,membername) values(?,?,?)";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			//세팅
			pstmt.setString(1,member.getMemberid());
			pstmt.setString(2,member.getPassword());
			pstmt.setString(3,member.getMembername());
			
			//실행
			resultCnt = pstmt.executeUpdate();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		
		return resultCnt;
	}
	
	//멤버 리스트 출력
	public List<Member> selectList(Connection conn){
		List<Member> list = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from member";
			
			rs = stmt.executeQuery(sql);
			
			list = new ArrayList<Member>();
			
			while(rs.next()) {
				list.add(new Member(
						//index, id, password, name, regdate순서로 가져온다.
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getTimestamp(6)
						));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
		return list;
	}
	
	//아이디와 패스워드를 비교해서 특정 회원 단 한명 정보를 가져오기
	
	public Member selectByIdPw(Connection conn, String id, String pw) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member where memberid =? and password =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,pw);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				member= new Member();
				member.setIdx(rs.getInt("idx"));
				member.setMemberid(rs.getString("memberid"));
				member.setPassword(rs.getString("password"));
				member.setMembername(rs.getString("membername"));
				member.setRegdate(rs.getTimestamp("regdate"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return member;
	}
	
}
