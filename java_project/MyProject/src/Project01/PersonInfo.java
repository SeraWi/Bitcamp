package Project01;

public class PersonInfo {
	//	변수들은 직접 참조를 막아 캡슐화 처리를 하도록 해봅시다. 
	//	변수의 직접 참조는 안되지만 변수의 값을 얻을 수 있는 메소드(getter)와
	//	변수에 값을 저장할 수 있는 메소드(setter)를 정의합니다.
	//	인스턴스 생성과 함께 데이터를 초기화 할 수 있도록 생성자를 정의해봅시다.

	private String name;
	private String phoneNum;
	private String email;
	private String address;
	private String birthday; // yymmdd 형식
	private String group;

	//생성자
	public PersonInfo(String name, String phoneNum, String email, String address, String birthday, String group) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}
	
	// 전체 데이터를 출력하는 기능
	public void showAllInfo() {
		System.out.println("연락처 정보 입니다.-------------");
		System.out.println("이      름:"+name);
		System.out.println("전화번호:"+phoneNum);
		System.out.println("이메일:"+email);
		System.out.println("주      소:"+address);
		System.out.println("생      일:"+birthday);
		System.out.println("그      룹:"+group);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoneNum() {
		return phoneNum;
	}


	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getGroup() {
		return group;
	}


	public void setGroup(String group) {
		this.group = group;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


}
