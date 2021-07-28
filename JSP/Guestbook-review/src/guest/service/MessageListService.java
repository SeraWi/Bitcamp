package guest.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import guest.dao.MessageDao;
import guest.domain.Message;
import guest.domain.MessageListView;
import guest.domain.MessageRequest;
import guest.jdbc.ConnectionProvider;

public class MessageListService {
	//한 페이지에 표현할 메시지 개수
	private final int messageCountPage = 3;
	
	//싱글통
	private MessageListService() {
		
	}
	private static MessageListService service = new MessageListService();
	public static MessageListService getInstance() {
		return service;
	}
	
	//페이지 넘버에 해당하는 게시물 보여주기
	public MessageListView getMessageList(int pageNumber) {
		MessageListView listView = null;
		Connection conn= null;
		MessageDao dao = null;
		
		try {
			conn= ConnectionProvider.getConnection();
			dao= MessageDao.getInstance();
			
			//현재 전체 게시물의 개수를 가져온다
			int totalMessageCount = dao.selectAllCount(conn);
			
			//페이지에 표현할 메시지 객체를 list<Message>에 받기
			List<Message> messageList = null;
			
			//데이터 베이스 시작행의 위치값
			int firstRow = (pageNumber-1)*messageCountPage;
			
			//시작 위치값과 개수를 dao로 전달하고 결과를 배열로 받아온다
			messageList = dao.selectMessageList(conn,firstRow,messageCountPage);
			
			listView = new MessageListView(
					messageList,
					totalMessageCount,
					pageNumber,
					messageCountPage,
					firstRow,
					0
					);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listView;
	}
	
	
}
