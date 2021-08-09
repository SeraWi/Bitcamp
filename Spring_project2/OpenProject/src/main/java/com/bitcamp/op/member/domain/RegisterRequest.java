package com.bitcamp.op.member.domain;

import org.springframework.web.multipart.MultipartFile;

public class RegisterRequest {
	
	//사용자가 입력한 정보 ->command 객체!
	
	private String memberid;
	private String password;
	private String membername;
	private MultipartFile memberphoto;
	
	//기본생성자 사용
	
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
	public MultipartFile getMemberphoto() {
		return memberphoto;
	}
	public void setMemberphoto(MultipartFile memberphoto) {
		this.memberphoto = memberphoto;
	}

	@Override
	public String toString() {
		return "RegisterRequest [memberid=" + memberid + ", password=" + password + ", membername=" + membername + "]";
	}

 
	
}
