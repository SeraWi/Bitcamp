package com.bitcamp.orl.feed.domain;

public class FeedView {
	
	//피드 상세보기
	
	private int boardIdx;
	private String boardPhoto;
	private int memberIdx;
	private String memberNickname;
	private String memberProfile;
	
	public FeedView(){}

	public FeedView(int boardIdx, String boardPhoto, int memberIdx, String memberNickname, String memberProfile) {
		super();
		this.boardIdx = boardIdx;
		this.boardPhoto = boardPhoto;
		this.memberIdx = memberIdx;
		this.memberNickname = memberNickname;
		this.memberProfile = memberProfile;
	}

	public int getBoardIdx() {
		return boardIdx;
	}

	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}

	public String getBoardPhoto() {
		return boardPhoto;
	}

	public void setBoardPhoto(String boardPhoto) {
		this.boardPhoto = boardPhoto;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public String getMemberProfile() {
		return memberProfile;
	}

	public void setMemberProfile(String memberProfile) {
		this.memberProfile = memberProfile;
	}

	@Override
	public String toString() {
		return "FeedView [boardIdx=" + boardIdx + ", boardPhoto=" + boardPhoto + ", memberIdx=" + memberIdx
				+ ", memberNickname=" + memberNickname + ", memberProfile=" + memberProfile + "]";
	}

}
