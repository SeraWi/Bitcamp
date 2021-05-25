package chapter05;

public class Member {
	String name;
	String phoneNum;
	String major;
	int grade;
	String email;
	String birthday;
	String address;
	
	Member(String name, String phoneNum,String major,int grade,String email){
		this.name = name;
		this.phoneNum = phoneNum;
		this.major = major;
		this.grade = grade;
		this.email = email;
	}
	Member(String name, String phoneNum,String major,int grade,String email,String birthday,String address){
		this(name,phoneNum,major,grade,email);
		this.birthday = birthday;
		this.address = address;
		
	}
	void memberPrint() {
		System.out.println("이름: "+name);
		System.out.println("전화번호: "+phoneNum);
		System.out.println("전공: "+major);
		System.out.println("학년: "+grade);
		System.out.println("email: "+email);
		System.out.println("생일: "+birthday);
		System.out.println("주소: "+address);
	}
	
	public static void main(String[] args) {
		Member mem1 = new Member("지현", "01012349876","Computer",2,"jj123","5월25일","종로구");
		mem1.memberPrint();
	}

}
