package chapter07;

public class Male extends Person{
	String gender;
	String major;
	String phoneNum;

	Male(String name, String id, String gender,String major,String phoneNum){
		super(name, id);
		this.gender = gender;
		this.major = major;
		this.phoneNum = phoneNum;
	}
	void hello() {
		super.hello();
		System.out.println("저는 "+gender+"입니다.");
		System.out.println("전화번호는  "+ phoneNum+"입니다.");
	}
	void studying() {
		System.out.println("전공은 "+major+"입니다.");
	}
}
