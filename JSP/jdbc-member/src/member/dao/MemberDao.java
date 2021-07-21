package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.util.JdbcUtil;
import member.domain.Member;

public class MemberDao {
	//싱글톤 패턴
	private MemberDao() {}
	
	private static MemberDao dao = new MemberDao();
	
	public static MemberDao getInstance(){
		return dao;
	}
	
	public List<Member> getMemberList(Connection conn){
		List<Member> memberList = null;
		Statement stmt = null;
		ResultSet rs =null;
		
		try {
			stmt = conn.createStatement();
			
			//sql작성
			String sql ="select * from member";
			
			//쿼리로 받아오기
			rs = stmt.executeQuery(sql);
			memberList = new ArrayList<Member>();
			
			//쿼리에서 받은 데이터 member객체로 생성 ->배열에 넣기
			while(rs.next()) {
				memberList.add(new Member(rs.getNString(1),rs.getNString(2),rs.getNString(3),rs.getNString(4)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
			JdbcUtil.close(rs);
		}
		
		
		return memberList;
		
	}
	
	public int insertMember(Connection conn, Member member) {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sql = "insert into member values(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			//세팅해주기
			pstmt.setString(1,member.getId());
			pstmt.setString(2,member.getPw());
			pstmt.setString(3,member.getName());
			pstmt.setString(4,member.getRegdate());
			
			//실행 후 반환
			resultCnt = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return resultCnt;
	}
}
