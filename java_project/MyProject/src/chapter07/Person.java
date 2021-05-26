package chapter07;

import java.util.Calendar;

public class Person {
	String name;
	int birthYear;

	Person(String name, int birthYear){
		this.name = name;
		this.birthYear = birthYear;
	}
	void personInfo(){
		System.out.println("안녕하세요. 저는 "+name+"입니다." + ageCal(birthYear)+"살 입니다.");
	}

	int ageCal(int bithYear) {
		this.birthYear = birthYear;
		return Calendar.getInstance().get(Calendar.YEAR)- birthYear-1;
	}
}
class Male extends Person{
	String gender;
	String major;
	String phoneNum;

	Male(String name, int birthYear, String gender,String major,String phoneNum){
		super(name, birthYear);
		this.gender = gender;
		this.major = major;
		this.phoneNum = phoneNum;
	}
	void personInfo() {
		super.personInfo();
		System.out.println("저는 "+gender+"입니다.");
		System.out.println("전화번호는  "+ phoneNum+"입니다.");
	}
	void studying() {
		System.out.println("전공은 "+major+"입니다.");
	}
}
class Female extends Person{
	String gender;
	String major;
	String phoneNum;

	Female(String name, int birthYear, String gender,String major,String phoneNum){
		super(name, birthYear);
		this.gender = gender;
		this.major = major;
		this.phoneNum = phoneNum;
	}
	void personInfo() {
		super.personInfo();
		System.out.println("저는 "+gender+"입니다.");
		System.out.println("전화번호는  "+ phoneNum+"입니다.");
	}
	void studying() {
		System.out.println("전공은 "+major+"입니다.");
	}
}
