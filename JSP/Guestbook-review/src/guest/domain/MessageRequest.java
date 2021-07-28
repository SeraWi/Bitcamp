package guest.domain;

public class MessageRequest {
	//사용자가 메세지 남겼을 때 저장하는 클래스
	//빈즈 형태로!
	
	private String guestname;
	private String password;
	private String message;
	
	//getter, setter
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
	
	//db에 저장할 때 Message객체로 바꿔주는 메서드 필요
	public Message toMessage() {
		return new Message(guestname,password,message);
	}
	
	
	@Override
	public String toString() {
		return "MessageRequest [guestname=" + guestname + ", password=" + password + ", message=" + message + "]";
	}
	
	

}
