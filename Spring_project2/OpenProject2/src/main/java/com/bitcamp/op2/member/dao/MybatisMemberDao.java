package com.bitcamp.op2.member.dao;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitcamp.op2.member.domain.Member;
import com.bitcamp.op2.member.domain.SearchIdPw;


//자동 빈 등록!
@Repository 
public class MybatisMemberDao {

	@Autowired
	private SqlSessionTemplate template;
	private final String NAME_SPACE ="com.bitcamp.op2.member.dao.mapper.memberMapper";
	
	
	public int insertMember(Member member) throws SQLException {
		return template.update(NAME_SPACE+".insertMember", member);
	}
	
//	public int insertMember1(final Member member) throws SQLException {
//
//		int resultCnt = 0;
//		
//		// 자동 증가한 컬럼의 값을 저장할 객체
//		KeyHolder holder = new GeneratedKeyHolder();
//		
//		resultCnt = template.update(
//				new PreparedStatementCreator() {
//					
//					@Override
//					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//						String sql2 = "insert into member (memberid,password,membername, memberphoto) values (?, ?, ?,?)";
//						PreparedStatement pstmt = con.prepareStatement(sql2, new String[] {"idx"});
//						pstmt.setString(1, member.getMemberid());
//						pstmt.setString(2, member.getPassword());
//						pstmt.setString(3, member.getMembername());
//						pstmt.setNString(4, member.getMemberphoto());
//						return pstmt;
//					}
//				}
//				, holder);
//		
//		Number idx = holder.getKey();
//		member.setIdx(idx.intValue());
//		
//		return resultCnt;
//
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


	public Member selectByIdPw(String id, String pw) {
		
		return template.selectOne(NAME_SPACE+".selectByIdPw",new SearchIdPw(id, pw));
	}


	// 아이디 중복 여부를 확인하는 메서드
	// id값 전달 받아서 db에서 확인한후 결과를 int로 반환한다.
	// ID 중복여부 확인을 위한 id 값으로 검색 -> 개수 반환
	public int selectById(String memberId) throws SQLException {
		
		
		return template.selectOne(NAME_SPACE+".selectById", memberId);
	}

}