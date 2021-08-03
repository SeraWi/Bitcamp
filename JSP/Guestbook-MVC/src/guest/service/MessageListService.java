package guest.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import guest.dao.MessageDao;
import guest.domain.Message;
import guest.domain.MessageListView;
import guest.jdbc.ConnectionProvider;

public class MessageListService {
	
	//한 페이지에 표현할 메세지의 개수
	private final int messageCountPerPage = 3;
	
	//싱글톤
	private MessageListService() {}
	private static MessageListService service = new MessageListService();
	public static MessageListService getInstance() {
		return service;
	}
	
	
	public MessageListView getMessageList(int pageNumber) {
		MessageListView listView = null;
		
		Connection conn = null;
		MessageDao dao = null;
		
		
		try {
			//커넥션 연결
			conn= ConnectionProvider.getConnection();
			//dao 가져오기
			dao= MessageDao.getInstance();
			
			//전체 게시물의 개수
			int totalMessageCount = dao.selectAllCount(conn);
			System.out.println("totalMessageCount"+totalMessageCount);
			
			//페이지에 표현할 메시지 객체들 list<Message>
			List<Message> messageList = null; 
			
			//데이터 페이스 시작행의 위차값  --limit index, 개수 : index= firstRow
			//(요청페이지-1)* 표현할 개수(3)
			int firstRow = (pageNumber-1)*messageCountPerPage; //0,3,6,9...
			
			//dao로 전달하고 결과 가져오기
			messageList = dao.selectMessageList(conn, firstRow, messageCountPerPage); 
			
			System.out.println("messageList:"+messageList);
			
			listView= new MessageListView(
					messageList,
					totalMessageCount,
					pageNumber,
					messageCountPerPage,
					firstRow,
					0
					);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listView;
	}
}
