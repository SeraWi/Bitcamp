package member.domain;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String regdate;
	
	
	//생성자
	public Member(String id, String pw, String name, String regdate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.regdate = regdate;
	}
	
	public Member() {
		
	}
	
	//getter,setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", regdate=" + regdate + "]";
	}
	
	
	
}
