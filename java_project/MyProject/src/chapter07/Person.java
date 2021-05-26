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

