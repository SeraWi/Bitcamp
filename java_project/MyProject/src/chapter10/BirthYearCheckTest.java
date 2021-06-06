package chapter10;

import java.util.Scanner;

public class BirthYearCheckTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("태어난 해를 입력해주세요.");

		try {
			int birthYear = scanner.nextInt();
			if(birthYear <= 0 || birthYear > 2021) {
				throw new BirthYearException("잘못 입력되었습니다.");
			}
		}catch(BirthYearException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
class BirthYearException extends Exception{
	BirthYearException(String msg){
		super(msg);
	}
}