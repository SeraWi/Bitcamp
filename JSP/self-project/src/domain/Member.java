package domain;

import java.sql.Timestamp;
import java.util.Date;

public class Member {
	//변수는 모두 private처리
	
	private int idx;
	private String memberId;
	private String password;
	private String memberName;
	private Timestamp regdate;
	
	//생성자
	public Member(int idx, String memberId, String password, String memberName, Timestamp regdate) {
		this.idx = idx;
		this.memberId = memberId;
		this.password = password;
		this.memberName = memberName;
		this.regdate = regdate;
	}
	
	
	public Member() {}
	//setter, getter
	

	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public Timestamp getRegdate() {
		return regdate;
	}


	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	public Date getDate() {
		return new Date(getRegdate().getTime());
	}


	@Override
	public String toString() {
		return "Member [idx=" + idx + ", memberid=" + memberId + ", password=" + password + ", membername=" + memberName
				+ ", regdate=" + regdate + "]";
	}
	
	
	//loginInfo객체 반환 메소드
	public LoginInfo toLoginInfo() {
		//3가지 정보만 가진 로그인이포 객체 반환한다.
		return new LoginInfo(this.idx,this.memberId, this.memberName);
	}
	
}
