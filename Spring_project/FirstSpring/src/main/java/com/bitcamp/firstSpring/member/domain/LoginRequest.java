package com.bitcamp.firstSpring.member.domain;

public class LoginRequest {
	
	//form의 name과 일치시키자
	
	private String id;
	private String pw;
	
	
	//기본 생성자 필수
	
	
	//setter/getter
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
	
	@Override
	public String toString() {
		return "LoginRequest [id=" + id + ", pw=" + pw + "]";
	}
	
	


	
	
	
	
}
