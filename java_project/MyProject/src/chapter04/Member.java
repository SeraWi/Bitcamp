package chapter04;

import java.util.Scanner;

public class Member {

	static void fluCheck(int year) {
		int age = 2021 -year+1;
		if( age < 15 || age >= 65) {
			System.out.println("무료 예방 접종이 가능합니다.");
		}else {
			System.out.println("무료 접종 대상이 아닙니다. ");
		}
	}

	static void medicalCheck(int year) {
		int age = 2021 -year+1;
		if(age >= 20) {
			System.out.println("무료로 2년마다 건강검진을 받을 수 있습니다.");
			if( year%2 ==0) {
				System.out.println("짝수해에 태어난 사람은 짝수년에 검사대상이 됩니다.");
			}else {
				System.out.println("홀수해에 태어난 사람은 홀수년에 검사대상이 됩니다. ");
			}
		}else {
			System.out.println("건강검진 대상자가 아닙니다.");
		}
		if(age>= 40) {
			System.out.println("암검사도 무료로 받을 수 있습니다.");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for(;;) {
			System.out.println("========메뉴========");
			System.out.println("1. 독감예방 접종 여부 확인");
			System.out.println("2. 건강검진 대상 여부 확인");
			System.out.print("번호를 입력하세요 >");

			int inputNum = Integer.parseInt(scanner.nextLine());
			int year =0;
			switch(inputNum) {
			case 1:
				System.out.print("태어난 해를 입력하세요 >");
				year = Integer.parseInt(scanner.nextLine());
				fluCheck(year);
				break;
			case 2:
				System.out.print("태어난 해를 입력하세요 >");
				year = Integer.parseInt(scanner.nextLine());
				medicalCheck(year);
				break;
			}
		}
	}
}