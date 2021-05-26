package chapter07;

import java.util.Calendar;

public class Person {
	String name;
	String id;

	Person(String name, String id){
		this.name = name;
		this.id = id;
	}
	void hello(){
		System.out.println("안녕하세요. 저는 "+name+"입니다." + ageCal(id)+"살 입니다.");
	}

	int ageCal(String id) {
		int yy = 1900+Integer.parseInt(id.substring(0, 2));
		int age = Calendar.getInstance().get(Calendar.YEAR)- yy -1;
		return age;
	}
}

