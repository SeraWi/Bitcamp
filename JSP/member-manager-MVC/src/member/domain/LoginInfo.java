package member.domain;

public class LoginInfo {
	private int idx;
	private String memberId;
	private String memberName;
	private String memberphoto;
	
		
	public LoginInfo(int idx, String memberId, String memberName,String memberphoto) {
		super();
		this.idx = idx;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberphoto =memberphoto;
	}
	
	//getter
	//setter :로그인 상태에서 정보변경되면 안되기때문에 setter 만들지 않는다.
	public int getIdx() {
		return idx;
	}
	public String getMemberId() {
		return memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public String getMemberphoto() {
		return memberphoto;
	}

	@Override
	public String toString() {
		return "LoginInfo [idx=" + idx + ", memberId=" + memberId + ", memberName=" + memberName + ", memberphoto="
				+ memberphoto + "]";
	}
}
