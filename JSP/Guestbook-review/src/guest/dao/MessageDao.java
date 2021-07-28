package guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import guest.domain.Message;
import guest.jdbc.JdbcUtil;

public class MessageDao {
	//싱글톤

	private MessageDao() {}
	private static MessageDao dao = new MessageDao();
	public static MessageDao getInstance() {
		return dao;
	}

	//전체 게시물의 개수를 가져오는 메서드
	public int selectAllCount(Connection conn) throws SQLException {
		int totalCount =0;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "select count(*) from guestbook_message"; //결과가 단일행
			rs= stmt.executeQuery(sql);

			if(rs.next()) {
				totalCount =rs.getInt(1);
			}


		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}

		return totalCount;
	}


	//요청 페이지에 표현할 메시지 리스트 가져오기 : 파라미터와 index와 개수를 받아온다
	public List<Message> selectMessageList(Connection conn, int firstRow, int messageCountPage) throws SQLException {
		List<Message> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		String sql = "select * from project.guestbook_message order by regdate desc limit ?,?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, messageCountPage);

			rs= pstmt.executeQuery();

			list= new ArrayList<Message>();

			while(rs.next()) {
				list.add(new Message(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getTimestamp(5)
						));
			}

		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		return list;
	}


	//message객체를 파라미터러 받아서 db에 insert한다
	public int writeMessage(Connection conn, Message message) throws SQLException {
		int resultCnt = 0;
		PreparedStatement pstmt = null;

		String sql = "insert into guestbook_message(guestname, password, message) values(?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,message.getGuestname());
			pstmt.setString(2,message.getPassword());
			pstmt.setString(3,message.getMessage());

			resultCnt = pstmt.executeUpdate();

		}finally {
			JdbcUtil.close(pstmt);

		}
		return resultCnt;
	}
	//id를 받아서 메시지 아이디에 해당하는 게시물이 존재하는지 확인 ->쿼리 반환
	public Message selectByMid(Connection conn, int mid) throws SQLException {
		Message message =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;


		try {
			String sql ="select * from project.guestbook_message where messageid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);

			rs= pstmt.executeQuery();

			if(rs.next()) {
				message= new Message();
				message.setMessageid(rs.getInt(1));
				message.setGuestname(rs.getString(2));
				message.setPassword(rs.getString(3));
				message.setMessage(rs.getString(4));
				message.setRegdate(rs.getTimestamp(5));

			}

		}finally {

			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}

		return message;
	}
	//db에 메세지 아이디를 찾아서 행을 삭제한다.
	public int deleteMessage(Connection conn, int mid) throws SQLException {
		int resultCnt =0;
		PreparedStatement pstmt = null;
		
		String sql ="delete from guestbook_message where messageid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mid);
			resultCnt = pstmt.executeUpdate();	
		
		}finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}

	
	


}
