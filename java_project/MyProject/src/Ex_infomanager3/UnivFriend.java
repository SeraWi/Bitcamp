package Ex_infomanager3;

public class UnivFriend extends Friend{
	
	// 대학 친구는 전공정보를 가진다.
	String major;
	
	public UnivFriend(String name, String phoneNumber, String address,String major) {
		super(name, phoneNumber, address);
		this.major = major;
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("전     공: " + major);
	}

	@Override
	public void showBasicInfo() {
		System.out.println("이      름: "+ name);
		System.out.println("전      화: " + phoneNumber);
		System.out.println("전      공: "+ major);
	}
}
