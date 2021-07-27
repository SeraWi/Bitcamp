package guest.domain;

import java.util.List;

public class MessageListView {
	
	private List<Message> messageList;	//게시물 message 객체 3개
	private int messageTotalCount;		//전체 게시물의 개수-> 전체 페이지 개수 알 수 있다.
	private int currentPagenumber;		//현재 페이지 번호
	private int pageTotalCount;			//페이지의 개수
	private int messageCountPerpage;	//한 페이지에 표현할 메시지의 개수
	private int firstRow;				//DB 게시물의 시작 index, 위치
	private int endRow;					//마지막 위치
	
	//생성자 : 초기화하기
	public MessageListView(List<Message> messageList, int messageTotalCount, int currentPagenumber,
		int messageCountPerpage, int firstRow, int endRow) {
		this.messageList = messageList;
		this.messageTotalCount = messageTotalCount;
		this.currentPagenumber = currentPagenumber;
		this.messageCountPerpage = messageCountPerpage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		calpageTotalCount();
		
	}

	private void calpageTotalCount() {
		
		
		if(this.messageTotalCount == 0) {
			this.pageTotalCount = 0; // 메세지 개수가 0이면 페이지 개수 0
		}else {
			
			this.pageTotalCount = this.messageTotalCount /this.messageCountPerpage; 
			//총 페이지 갯수 = 총 메세지 갯수 / 한페이지당 메세지 갯수
			// 10%3이 0보다 크면 한페이지 증가 
			if(this.messageTotalCount % this.messageCountPerpage >0) {
				this.pageTotalCount++;
			}
		}
	}
	
	//getter만!!!

	public List<Message> getMessageList() {
		return messageList;
	}

	public int getMessageTotalCount() {
		return messageTotalCount;
	}

	public int getCurrentPagenumber() {
		return currentPagenumber;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getMessageCountPerpage() {
		return messageCountPerpage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getEndRow() {
		return endRow;
	}

	@Override
	public String toString() {
		return "MessageListView [messageList=" + messageList + ", messageTotalCount=" + messageTotalCount
				+ ", currentPagenumber=" + currentPagenumber + ", pageTotalCount=" + pageTotalCount
				+ ", messageCountPerpage=" + messageCountPerpage + ", firstRow=" + firstRow + ", endRow=" + endRow
				+ "]";
	}
	
	
	
	
	
}
