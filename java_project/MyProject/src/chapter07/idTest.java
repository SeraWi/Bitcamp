package chapter07;

import java.util.Calendar;

public class idTest {
	String id;
	idTest(String id){
		this.id = id;
	}
	void ageCal() {
		int yy = Integer.parseInt(id.substring(0,2));
		int age =0;
		if( yy>= 0 && yy <= 21) {
			age = Calendar.getInstance().get(Calendar.YEAR)- (2000+yy) -1;
		}else {
			age = Calendar.getInstance().get(Calendar.YEAR)-(1900+ yy) -1;
		}
		System.out.println(age);
	}
	
	public static void main(String[] args) {
		idTest id = new idTest("980807-2000000");
		id.ageCal();
		
		idTest id2 = new idTest("120807-2000000");
		id2.ageCal();
	}
	
}
