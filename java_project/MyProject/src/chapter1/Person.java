package chapter1;

import java.util.Scanner;

public class Person {
	String name; // 회원이름 저장
	String phoneNum; // 회원 전화번호 저장
	String id; // 회원 주민번호 저장
	Person(String name, String phoneNum, String id){
		this.name = name;
		this.phoneNum = phoneNum;
		this.id = id;
	}
	public static void main(String[] args) {
		Person p1 = new Person("Sera","010-1234-5678","987654-3210000");
	
		System.out.println("회원 이름:"+p1.name);
		System.out.println("회원 전화번호: "+p1.phoneNum);
		System.out.println("회원 주민번호: "+p1.id);
		
		Person p2 = new Person("Julie","010-1234-5678","9876543210000");
		System.out.println("회원이름: "+ p2.name);
		System.out.println("회원 전화번호: "+p2.phoneNum);
		System.out.println("회원 주민번호: "+p2.id);
	}
}

