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
		int yy = Integer.parseInt(id.substring(0, 2));
		int age = 0;
		if( yy >= 0 && yy <= 21) {
			age = Calendar.getInstance().get(Calendar.YEAR)- (2000+yy) -1;
		}else {
			age = Calendar.getInstance().get(Calendar.YEAR)-(1900+ yy) -1;
		}
		return age;
	}
}

