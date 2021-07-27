package guest.domain;

import java.util.List;

public class MessageListView {
	private List<Message> messageList;
	private int messageTotalCount; //전체 게시물 개수
	private int currentPagenumber; // 현재 페이지 번호
	private int pageTotalCount;		// 총 페이지 개수
	private int messageCountPerpage;
	private int firstRow;
	private int endRow;
	
	//생성자 :초기화 하기
	public MessageListView(List<Message> messageList, int messageTotalCount, int currentPagenumber,
			int messageCountPerpage, int firstRow, int endRow) {
		super();
		this.messageList = messageList;
		this.messageTotalCount = messageTotalCount;
		this.currentPagenumber = currentPagenumber;
		this.messageCountPerpage = messageCountPerpage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		calPageTotalCount();
	}
	//총 페이지 개수 구하는 메서드
	private void calPageTotalCount() {
		
		
		if(this.messageTotalCount ==0) {
			//현재 메시지 개수가 0이면 페이지 개수 0
			this.messageTotalCount =0;
		}else {
			this.pageTotalCount =this.messageTotalCount /this.messageCountPerpage;
			
			if(this.messageTotalCount % this.messageCountPerpage >0) {
				this.pageTotalCount++;
			}
		}
	}
	//getter만!
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
