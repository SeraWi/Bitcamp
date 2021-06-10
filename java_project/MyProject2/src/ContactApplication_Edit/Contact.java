package ContactApplication_Edit;

import java.util.Scanner;
/*
 * 프로젝트 -1
 */
public class Contact {
	private String name;
	private String phoneNum;
	private String email;
	private String address;
	private String birthday;
	private String group;
	
	//생성자, 데이터 초기화
	public Contact(String name, String phoneNum, String email, String address, String birthday, String group) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}
	

	// 데이터를 출력하는 기능
	public void showInfo() {
		System.out.println("이름:" + name);
		System.out.println("전화번호:"+phoneNum);
		System.out.println("이메일:"+email);
		System.out.println("주소:"+address);
		System.out.println("생일:"+birthday);
		System.out.println("그룹:"+group);
	}
	
	
	// 캡슐화
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
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


	//main 메소드 정의
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Contact contact = new Contact("Lea","1111","lea1@google.com","America","970107","friend");
		
		//데이터를 수정
		contact.setName("지현");
		contact.setPhoneNum("010-1234-5678");
		
		//출력메소드를 다시 실행합니다.
		contact.showInfo();
		
	}
	
	
}
