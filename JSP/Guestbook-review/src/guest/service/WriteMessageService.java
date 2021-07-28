package guest.service;

import java.sql.Connection;
import java.sql.SQLException;

import guest.dao.MessageDao;
import guest.domain.Message;
import guest.domain.MessageRequest;

public class WriteMessageService {
	private WriteMessageService() {}
	private static WriteMessageService service = new WriteMessageService();
	public static WriteMessageService getInstance() {
		return service;
	}
	
	public int writeMessage(MessageRequest requestMessage) {
		int resultCnt = 0;
		
		Connection conn= null;
		MessageDao dao = null;
		try {
			conn.setAutoCommit(false);

			//메세지 폼 정보를 담은 requestMessage를 message객체로 만들고
			//db로 전달해서 insert 한다.
			Message message = requestMessage.toMessage();
			resultCnt = dao.writeMessage(conn,message);
			
			//정상적으로 트랜젝션 완료후 커밋
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultCnt;
	}
	
}
