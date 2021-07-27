package guest.domain;

public class MessageRequest {
	//사용자가 전달하는(입력한) 값을 저장
	
	private String guestname;
	private String password;
	private String message;
	
	//getter. setter
	public String getGuestname() {
		return guestname;
	}
	public void setGuestname(String guestname) {
		this.guestname = guestname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	//MessageRequest -> Message객체를 만드는 메서드
	public Message toMessage() {
		return new Message(guestname,password,message);
	}
	
	
	@Override
	public String toString() {
		return "MessageRequest [guestname=" + guestname + ", password=" + password + ", message=" + message + "]";
	}
	
	
	
	
}
