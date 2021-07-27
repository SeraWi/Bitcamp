package guest.service;

import java.sql.Connection;
import java.sql.SQLException;

import guest.dao.MessageDao;
import guest.domain.Message;
import guest.domain.MessageRequest;
import guest.jdbc.ConnectionProvider;
import guest.jdbc.JdbcUtil;

public class WriteMessageService {
	//싱글통
	
	private WriteMessageService() {}
	private static WriteMessageService service = new WriteMessageService();
	public static WriteMessageService getInstance() {
		return service;
	}
	
	
	
	//메시지를 db에 쓰고 처리된 결과 생성 insert
	public int writeMessage(MessageRequest requestMessage) {
		int resultCnt = 0;
		
		// 트렌젝션 처리를 위해서 생성
		Connection conn = null;
		MessageDao dao = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MessageDao.getInstance();
			conn.setAutoCommit(false);
			// AutoCommit의 기본값이true ->자동커밋
			//프로그래머가 Java Jdbc에서 트랜젝션을 컨트롤 ->conn.setAutoCommit(false);
			
			
			//Message를 전달한다. ->데이터 처리가 필요한 부분(사용자가 입력한 부분만)
			Message message = requestMessage.toMessage();
			resultCnt = dao.writeMessage(conn, message);
			
			
			conn.commit();
		} catch (SQLException e) {
			
			e.printStackTrace();
			JdbcUtil.close(conn);
		}
		
		
		return resultCnt;
		
	}
}
