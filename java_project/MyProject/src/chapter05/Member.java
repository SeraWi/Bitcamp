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
		System.out.println();
	}
	
	public static void main(String[] args) {
		Member mem1 = new Member("Emma", "012345678","Computer",2,"emma123","May 13","America");
		mem1.memberPrint();
		
		Member mem2 = new Member("Sam","987654321","Music",4,"sam123");
		mem2.memberPrint();
	}

}
