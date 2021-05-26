package chapter07;

import java.util.Calendar;

public class idTest {
	static String id = "020406-2094811";
	static int yy = 1900+Integer.parseInt(id.substring(0, 2));
	static int age = Calendar.getInstance().get(Calendar.YEAR)- yy -1;
	
	public static void main(String[] args) {
		System.out.println(yy);
		System.out.println(age);
	}
	
}
