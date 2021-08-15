package com.bitcamp.op3.member.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.op3.member.domain.Member;
import com.bitcamp.op3.member.domain.SearchIdPw;


@Repository 
public class mybatisMemberDao {
	
//	@Autowired
//	private JdbcTemplate template;
	
	@Autowired
	private SqlSessionTemplate template;
	
	private final String NAME_SPACE ="com.bitcamp.op3.member.dao.memberMapper";

	public int insertMember( Member member) throws SQLException {
		
		//DML모두 update메소드
		return template.update(NAME_SPACE+".insertMember",member);
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
	
	// 로그인하기
	public Member selectByIdPw(String id, String pw) {
		
		//selectone :select해서 하나만 받을 때
		
		Member member = template.selectOne(
								NAME_SPACE+".selectByIdPw",
								new SearchIdPw(id,pw));
		
		return member;
	}
	
	
//	// 아이디 중복 여부를 확인하는 메서드
//	// id값 전달 받아서 db에서 확인한후 결과를 int로 반환한다.
	public int selectById(String memberid) throws SQLException {
		//Integer 반환하면 오토박싱으로 int바뀐다.
		return template.selectOne(NAME_SPACE+".selectById",memberid);
	}

}