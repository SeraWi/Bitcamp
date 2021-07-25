package domain;

public class LoginInfo {
	
	//로그인 되었을 때 가지고 다닐 데이터 -> 민감하지않은 데이터들만
	private int idx;
	private String memberId;
	private String memberName;
	
	
	//생성자
	public LoginInfo(int idx, String memberId, String memberName) {
		super();
		this.idx = idx;
		this.memberId = memberId;
		this.memberName = memberName;
	}

	//데이터를 바꿀 수 없다. ->getter만
	public int getIdx() {
		return idx;
	}


	public String getMemberId() {
		return memberId;
	}


	public String getMemberName() {
		return memberName;
	}

	@Override
	public String toString() {
		return "LoginInfo [idx=" + idx + ", memberId=" + memberId + ", memberName=" + memberName + "]";
	}
	
	
	
	
}
