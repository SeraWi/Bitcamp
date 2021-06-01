package chapter09;

import java.util.Calendar;
import java.util.Scanner;

public class BirthdayCount {

	public static void main(String[] args) {
		//사용자 생일 입력받기->yy.mm.dd
		//생일을 date1으로 set
		//오늘 날짜를 date2
		//두개의 차이를 구해서 몇일 살았는지 출력
		
		Calendar birthDay = Calendar.getInstance();
		Calendar today = Calendar.getInstance();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("태어난 해를 입력하세요 > ");
		int yy = Integer.parseInt(scanner.nextLine());
		System.out.print("태어난 월을 입력하세요 > ");
		int mm = Integer.parseInt(scanner.nextLine());
		System.out.print("태어난 일를 입력하세요 > ");
		int dd = Integer.parseInt(scanner.nextLine());
		
		birthDay.set(yy,mm,dd);
		long difference = (today.getTimeInMillis() - birthDay.getTimeInMillis())/1000;
		System.out.println("태어난 날 부터 오늘까지 "+ difference/(24*60*60)+"일을 살았습니다. ");

	}

}
