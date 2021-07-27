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
	private DeleteMessageService(){}
	private static DeleteMessageService service =new DeleteMessageService();
	public static DeleteMessageService getInstance() {
		return service;
	}
	
	
	public int deleteMessage(int mid, String password) throws SQLException, MessageNotFoundException, InvalidPasswordException {
		int resultCnt = 0;
		
		Connection conn= null;
		MessageDao dao= null;
		
		try {
			conn= ConnectionProvider.getConnection();
			dao = MessageDao.getInstance();
			//트렌젝션 처리
			conn.setAutoCommit(false);
			
			// 전달받은 mid로 게시물을 검색해서(select) message객체 가져오기
			Message message = dao.selectByMid(conn,mid);
			
			if(message == null) {
				//게시물이 존재하지 않다
				//throw new Exception("게시물이 존재하지 않습니다.");
				throw new MessageNotFoundException(mid);
				//예외를 던지면(트라이 캐치 하지 않고) 메소드 호출한 messageDelete.jsp 에서 처리하게 된다. 
			}else{
				// 가져온 message객체의 패스워드가 사용자가 입력한 패스워드랑 같다면
				// 삭제 처리 해준다
				if(message.getPassword().equals(password)) {
					//삭제한다. ->dao로 가서 mid가 일치하는 게시물 삭제하기
					resultCnt = dao.deleteMessage(conn,mid);
					conn.commit(); //문제 없이 실행 ->커밋하기!, 트렌젝션 성공!
				}else{
					//비밀번호가 일치하지 않으므로 예외 발생
					throw new InvalidPasswordException();
				}
			}
			
		}catch(SQLException e) { 
			e.printStackTrace();
			JdbcUtil.rollback(conn); //롤백시키고
			throw e; // 다시 예외 던지면 jsp파일에 예외 전달 (jsp에서 예외를 확인하고자)
		
		} catch (MessageNotFoundException e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw e;
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw e;
		}finally {
			JdbcUtil.close(conn);
		}
		return resultCnt;
	}
	
}
