package guest.service;

import java.sql.Connection;
import java.sql.SQLException;

import guest.dao.MessageDao;
import guest.domain.Message;
import guest.exception.InvalidPasswordException;
import guest.exception.MessageNotFoundException;
import guest.jdbc.ConnectionProvider;
import guest.jdbc.JdbcUtil;

public class DeleteMessageService {
	//싱글톤
	private DeleteMessageService(){}
	private static DeleteMessageService service = new DeleteMessageService();
	public static DeleteMessageService getInstance() {
		return service;
	}

	public int deleteMessage(int mid, String password) throws SQLException, MessageNotFoundException, InvalidPasswordException {
		int resultCnt =0;
		
		Connection conn= null;
		MessageDao dao = null;
		try {
			conn= ConnectionProvider.getConnection();
			dao= MessageDao.getInstance();

			conn.setAutoCommit(false);

			//전달받은mid로 게실물 검색하고 message객체로 가져오기
			Message message = dao.selectByMid(conn,mid);

			//전달받은 message객체의 password와 사용자가 입력한 password같은 확인한후 db에서 삭제

			if(message == null) {
				//null이면 아이디에 해당하는 게시물이 없다
				throw new MessageNotFoundException(mid);
			}else {
				//있다면 비밀번호 비교
				if(message.getPassword().equals(password)) {
					//mid전달해서 삭제하기
					resultCnt = dao.deleteMessage(conn, mid);
					//삭제후 커밋
					conn.commit();
				}else {
					//비밀번호 다르다면 예외 발생
					throw new InvalidPasswordException();
				}
			}


		}catch(SQLException e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);//롤백시키고
			throw e; //다시 예외 던디면 jsp파일에 예외전달되고 예외를 확인할 수 있다.
		}catch(MessageNotFoundException e){
			e.printStackTrace();
			JdbcUtil.close(conn);
			throw e;
			
		}catch(InvalidPasswordException e){
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
		return resultCnt;
	}
}
