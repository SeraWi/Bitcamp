package com.bitcamp.firstSpring.member.domain;

public class RegisterRequest {
	
	private String memberid;
	private String password;
	private String membername;
	
	
	//getter setter
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	
	@Override
	public String toString() {
		return "RegisterRequest [memberid=" + memberid + ", password=" + password + ", membername=" + membername + "]";
	}

 
	
}
