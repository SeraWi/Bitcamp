package com.bitcamp.op.member.domain;

import org.springframework.web.multipart.MultipartFile;

public class LoginInfo {
	private int idx;
	private String memberid;
	private String membername;
	private MultipartFile memberphoto;
	
	
	public LoginInfo(int idx, String memberid, String membername, MultipartFile memberphoto) {
		this.idx = idx;
		this.memberid = memberid;
		this.membername = membername;
		this.memberphoto = memberphoto;
	}


	@Override
	public String toString() {
		return "LoginInfo [idx=" + idx + ", memberid=" + memberid + ", membername=" + membername + ", memberphoto="
				+ memberphoto + "]";
	}
	
	
}
